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

import dao.SakeDAO;
import model.SakeRecord;

/**
 * 商品検索画面のコントローラ
 */
@WebServlet("/SakeSearch")
public class SakeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Getリクエストを処理します。
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ログイン画面へフォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータより処理種別を取得
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータから検索条件の取得
		String sBunrui = request.getParameter("sakeBunrui");
		int sDosu = Integer.parseInt(request.getParameter("sakeDosu"));
		String sAjiwai =  request.getParameter("sakeAjiwai");

		// 検索条件に該当する情報をSakeテーブルから検索
		SakeDAO sakeDAO = new SakeDAO();
		List<SakeRecord> sakeList = sakeDAO.select(sBunrui, sDosu, sAjiwai);

		HttpSession session = request.getSession();

		// 検索結果をセッションスコープに保存
		session.setAttribute("sakeList", sakeList);

		// 検索条件で指定した内容をそれぞれリクエストスコープに保存
		request.setAttribute("sBunrui", sBunrui);
		request.setAttribute("sDosu", sDosu);
		request.setAttribute("sAjiwai", sAjiwai);

		// 検索結果画面へフォワード
		RequestDispatcher dispatcher =
			request.getRequestDispatcher("/WEB-INF/jsp/sakeSearchResult.jsp");
		dispatcher.forward(request, response);
	}

}
