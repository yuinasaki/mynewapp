package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * ログイン状況に応じて各種ページへ移行するコントローラ
 */

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ログインしているか確認するため、
		//セッションスコープからユーザー情報を確認
		HttpSession session =request.getSession();
		User loginUser=(User)session.getAttribute("loginUser");

		if(loginUser==null) { //ログインしていない場合
			//リダイレクト
			response.sendRedirect("/Sake_Search/"); //index.jsp(トップ画面)にとぶ
		}else { //ログイン済みの場合
			//フォワード
			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/sakeSearch.jsp");//検索ページにとぶ
			dispatcher.forward(request,response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
