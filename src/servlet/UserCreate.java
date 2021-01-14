package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ユーザー登録に関するリクエストを処理するコントローラ
 */

@WebServlet("/UserCreate")
public class UserCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ユーザー登録画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userCreate.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");


		//登録処理
		//nameとidをMapに格納
		if(name.length() >= 3 && name.length() <= 10 && id.length() >= 3 && id.length() <= 10) {
			ServletContext application = getServletContext();
			Map<String, String> userMap = (Map<String, String>) application.getAttribute("userMap");

			//ユーザーリストをアプリケーションスコープに保存
			//存在しない場合は、新規でインスタンス作成
			if(userMap == null) {
				userMap = new HashMap<String, String>();
			}
			//これから登録するユーザー名が既に存在している場合を調べる
			//登録されていなければ、登録処理を行う
			if(userMap.containsKey(name)) {
				//ここで出されるエラーメッセージをリクエストスコープに保存
				request.setAttribute("message", "そのNAMEは既に登録されています");
			}else {
				//新規登録ユーザーを追加したユーザーリストを、アプリケーションスコープに再登録
				userMap.put(name, id);
				application.setAttribute("userMap", userMap);

				//登録完了メッセージをリクエストスコープに保存
				request.setAttribute("message", "登録が完了しました");
			}
		}else {
			//エラーメッセージ（UserName、IDは必須項目です）をリクエストスコープに保存
			request.setAttribute("message", "NAME、PASSWORDは必須項目です");;
		}
		//ユーザー登録画面にフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userCreate.jsp");
				dispatcher.forward(request, response);

	}

}
