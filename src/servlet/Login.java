package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * ログイン画面のコントローラ
 */

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメーターを取得
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String id=request.getParameter("id");

		//Userインスタンスの生成
		User user =new User(name,id);

		//エラーメッセージ用の変数宣言
		String errorMsg = "";

		//ログイン処理
		LoginLogic loginLogic =new LoginLogic();
		ServletContext application =getServletContext();
		Map<String,String>userMap=(Map<String,String>)application.getAttribute("userMap");
		boolean isLogin=loginLogic.execute(user, userMap);

		//ログイン成功時の処理
		if(isLogin) {
			HttpSession session =request.getSession();
			session.setAttribute("loginUser",user);

			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/sakeSearch.jsp");//検索画面にとぶ
			dispatcher.forward(request,response);

		}else if(name.length()==0||id.length()==0||name==null||id==null) { //どちらかが空白の場合
			errorMsg+="NAMEとPASSWORDは入力必須です";
			request.setAttribute("errorMsg",errorMsg);

			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");//ログイン画面にとぶ
			dispatcher.forward(request,response);

		}else if(name.length()>11||name.length()<3||id.length()<3||id.length()>11) {
			errorMsg+="NAMEとPASSWORDは3文字以上10文字以下で入力してください";
			request.setAttribute("errorMsg",errorMsg);

			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");//ログイン画面にとぶ
			dispatcher.forward(request,response);

		}else{//ログイン失敗ページにフォワード

			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");//ログイン失敗画面にとぶ
			dispatcher.forward(request,response);
		}
	}

}
