package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Shouhin;
import model.shouhinDAO;

/**
 * Servlet implementation class DelServlet
 */
@WebServlet("/del")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String sidStr = request.getParameter("sidStr");

		int sid = Integer.parseInt(sidStr);


//		if(sidStr == null) {
//			request.setAttribute("msg", "文字を入力してください");
//		request.setAttribute("url", "insert.html");
//			equestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
//		dispatcher.forward(request, response);
//
//		return;
//	}


		shouhinDAO dao = new shouhinDAO();

		Shouhin s = dao.findBySid(sid);


		request.setAttribute("shouhin", s);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/delKakunin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String sidStr = request.getParameter("sidStr");

		int sid = Integer.parseInt(sidStr);


		shouhinDAO dao = new shouhinDAO();

		dao.delete(sid);

		response.sendRedirect("slist");
	}

}
