package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SakeRecord;

public class SakeDAO {
	/**
	 * 「Sake」テーブルへのアクセスを担当するDAOクラス
	 */
	    private final String url = "jdbc:postgresql://localhost:5432/sake";
	    private final String user = "postgres";
	    private final String password = "test";

		/**
		 * 「Sake」テーブルからベース・度数・味わいでデータを検索し、検索結果を返します。
		 */
	    public List<SakeRecord> select(String sakeBunrui, int sakeDosu, String sakeAjiwai) {
	        Connection con = null;
	        PreparedStatement st = null;
	        ResultSet rs = null;

	        List<SakeRecord> sRecords = null;

			try {
		         /* JDBCドライバの定義 */
		         Class.forName("org.postgresql.Driver");

		         /* PostgreSQLへの接続 */
		         con = DriverManager.getConnection(url, user, password);

		         /* SELECT文の準備 */
		         String sql = "SELECT * ";
		         sql += "FROM Sake ";
		         sql += "WHERE sake_bunrui like ? ";

		         switch(sakeDosu) {
		         case 1:
		        	 sql += "AND sake_dosu between 1 and 10 ";
		        	 break;
		         case 2:
		        	 sql += "AND sake_dosu between 11 and 20 ";
		        	 break;
		         case 3:
		        	 sql += "AND sake_dosu between 21 and 50 ";
		        	 break;
		        	 default:
		        	 sql += "AND sake_dosu between 1 and 50 ";
		         }

		         sql += "AND sake_ajiwai like ? ";
		         sql += "ORDER BY sake_id; ";
		         st = con.prepareStatement(sql);
		         st.setString(1, "%" + sakeBunrui + "%");
		         st.setString(2, "%" + sakeAjiwai + "%");

		         /* SELECT文の実行 */
		         rs = st.executeQuery();

		         /* 結果をリストに移し替える */
		         sRecords = makeResultData(rs);

			} catch(Exception e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			} finally {
		         /* PostgreSQLとの接続を切断 */
				if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {}
				}

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

	        return sRecords;
	    }

	    /**
	     * 検索結果をリストで返します。
	     */
	    public ArrayList<SakeRecord> makeResultData(ResultSet rs) throws Exception {

	    	// 全検索結果を格納するリストを準備
	    	ArrayList<SakeRecord> sRecords = new ArrayList<SakeRecord>();

	    	while(rs.next()) {
	    		// 1行分のデータを読込む
	    		String sakeId = rs.getString("sake_id");
	    		String sakeMei = rs.getString("sake_mei");
	    		String sakeBunrui = rs.getString("sake_bunrui");
	    		int sakeDosu = rs.getInt("sake_dosu");
	    		String sakeAjiwai = rs.getString("sake_ajiwai");
	    		String imgLocation = rs.getString("img_Location");

	    		// 1行分のデータを格納するインスタンス
	    		SakeRecord sRecord = new SakeRecord(sakeId,
	    												sakeMei,
	    												sakeBunrui,
	    												sakeDosu,
	    												sakeAjiwai,
	    												imgLocation);

	            // リストに1行分のデータを追加する
	            sRecords.add(sRecord);
	    	}
	    	return sRecords;
	    }
}
