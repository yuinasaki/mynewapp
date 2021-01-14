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
import model.SakeRecord;
import model.User;

/**
 * お気に入り情報追加のコントローラ
 */

@WebServlet("/FavServlet")
public class FavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータから検索条件の取得
		request.setCharacterEncoding("UTF-8");

		//セッションスコープからユーザー名を取得
		HttpSession session =request.getSession();
		User name = (User)session.getAttribute("loginUser");

		//セッションスコープからsakeListを取得
		List<SakeRecord> sakeList = (List<SakeRecord>)session.getAttribute("sakeList");

		// リクエストパラメータからSakeId情報の取得
		String[] fav = request.getParameterValues("fav");

		// 取得したSakeIDを元に、Favoriteテーブルへお気に入り情報を登録
		FavDAO favDAO = new FavDAO();

		for(String id : fav) {
			for(SakeRecord sake : sakeList) {
				if(sake.getSakeId().equals(id)) {
					favDAO.insert(name, sake);
				}
			}
		}

			// お気に入りリスト画面へフォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/FavViewServlet");
		dispatcher.forward(request, response);

	}


}
