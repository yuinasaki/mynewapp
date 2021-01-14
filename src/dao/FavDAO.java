package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FavBeans;
import model.SakeRecord;
import model.User;

/*
 * 「Favorite」テーブルへのアクセスを担当するDAOクラス
 */

public class FavDAO {
	//データーベース接続する情報
	private final String url = "jdbc:postgresql://localhost:5432/sake";
    private final String user = "postgres";
    private final String password = "test";

    /*
     * 「Favorite」テーブルに選択されたデータを登録します。
     */


    public void insert(User Luser,
    		SakeRecord resultData) {

    	Connection con = null;
    	PreparedStatement st = null;

    try {
    	/* JDBCドライバの定義 */
        Class.forName("org.postgresql.Driver");

        /* PostgreSQLへの接続 */
        con = DriverManager.getConnection(url, user, password);

        /* INSERTの準備 */
        String sql = "";
        sql = "INSERT INTO favorite(name, sake_id, sake_mei, sake_bunrui, sake_dosu, sake_ajiwai,img_location)";
        sql += "VALUES(?, ?, ?, ?, ?, ?, ?);";

        st = con.prepareStatement(sql);

        st.setString(1, Luser.getName());
        st.setString(2, resultData.getSakeId());
        st.setString(3, resultData.getSakeMei());
        st.setString(4, resultData.getSakeBunrui());
        st.setInt(5, resultData.getSakeDosu());
        st.setString(6, resultData.getSakeAjiwai());
        st.setString(7, resultData.getImglocation());



        /* INSERT文の実行 */
        st.executeUpdate();

    }catch(Exception e){

    	System.out.println("DBアクセス時にエラーが発生しました。");
		e.printStackTrace();
	} finally {
        /* PostgreSQLとの接続を切断 */
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {}
		}

		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {}
		}
	}

}
       /*
        * favoriteテーブルからすべてのデータを検索して
        * その名前に紐づいている結果をすべて返す
        */

    public List<FavBeans> findAll(User Fuser){
    	Connection con = null;
		  PreparedStatement st = null;
		  ResultSet rs = null;

		  List<FavBeans> sakeF = new ArrayList<FavBeans>();

		  try {

			//JDBCドライバの定義
				Class.forName("org.postgresql.Driver");

		   //PostgreSQLへの接続
				con = DriverManager.getConnection(url, user, password);

		   //SELECT文の準備
				String sql = "";
				sql="SELECT * FROM favorite WHERE name=? ORDER BY no ASC";
				st = con.prepareStatement(sql);

				st.setString(1, Fuser.getName());


		   //SELECT文の実行
				rs = st.executeQuery();
				sakeF = makeResultData(rs);

    }catch(Exception e) {
		System.out.println("DBアクセス時にエラーが発生しました");
		e.printStackTrace();
	}finally {

		//PostSQLとの接続を切断
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException e) {}
		}
	}
	if(st != null) {
		try {
			st.close();
		}catch(SQLException e) {}
	}
	if(con != null) {
		try {
			con.close();
		}catch(SQLException e) {}
	}

return sakeF;

}

    //↓お気に入り検索結果をリストに格納するメソッド

    public ArrayList<FavBeans> makeResultData(ResultSet rs) throws Exception {

    	// 全検索結果を格納するリストを準備
    	ArrayList<FavBeans> viewDatas=new ArrayList<FavBeans>();

    	while(rs.next()) {
		   //おきにいり検索結果をリストに格納
			   String name = rs.getString("name");
	    		String sakeId = rs.getString("sake_id");
	    		String sakeMei = rs.getString("sake_mei");
	    		String sakeBunrui = rs.getString("sake_bunrui");
	    		int sakeDosu = rs.getInt("sake_dosu");
	    		String sakeAjiwai = rs.getString("sake_ajiwai");
    	    String sakeImg = rs.getString("img_location");

	    		FavBeans records = new FavBeans(name,sakeId,sakeMei,sakeBunrui,sakeDosu,sakeAjiwai,sakeImg);
	    		viewDatas.add(records);

		  }
		   return viewDatas;
    	}

    }



