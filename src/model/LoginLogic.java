package model;
import java.util.Map;


/*ログインに関する処理を行うモデル
 * */

//ユーザーがログイン画面から入力したname,passをMapに格納して処理
public class LoginLogic {
	public boolean execute(User user,Map<String,String>userMap) {


		/*Login.javaから[User user = new User(name, pass);]でインスタンス生成される。
		 * ここの(name,pass)にはgetAttributeでユーザーが入力した値が返る
		 * userMapには登録されているユーザーリストが格納されている。
		 *Login.javaから [boolean isLogin = loginLogic.execute(user, userMap);]
		  で、ここのexecuteメソッドが呼び出される。*/

		//入力されたname,passが空白でなければ、
		if(userMap!=null) {
			String id=userMap.get(user.getName());
			// id=(格納されたユーザーリスト).get(今入力されたユーザー情報).のなまえ());
			if(user.getId().equals(id)) {
				return true;
			}
		}
		// userMapがnull（ユーザーリストが未登録）の場合はログイン失敗として処理
		return false;
	}

}
