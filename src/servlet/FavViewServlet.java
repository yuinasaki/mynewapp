package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FavDAO;
import model.FavBeans;
import model.User;

/**
 * お気に入り画面のコントローラ
 */
@WebServlet("/FavViewServlet")
public class FavViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータから検索条件の取得
		request.setCharacterEncoding("UTF-8");

		//セッションスコープからユーザー名を取得
		HttpSession session =request.getSession();
		User name = (User)session.getAttribute("loginUser");

		// お気に入り情報を取得
		FavDAO favDAO = new FavDAO();
		List<FavBeans> resultDatas=favDAO.findAll(name);
		session.setAttribute("resultDatas",resultDatas);

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/favorite.jsp");
		dispatcher.forward(request, response);

		// セッションスコープに保存されたインスタンスの削除
		session.removeAttribute("resultDatas");
	}


}
