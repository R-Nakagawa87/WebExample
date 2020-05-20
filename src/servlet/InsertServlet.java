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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			String name = request.getParameter("name");
			String strTanka = request.getParameter("strTanka");

			int tanka = Integer.parseInt(strTanka);


			if(name.isEmpty()) {
				request.setAttribute("msg", "文字を入力してください");
				request.setAttribute("url", "insert.html");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);

				return;
			}


			Shouhin s = new Shouhin(0, name, tanka);


			request.setAttribute("shouhin", s);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/kakunin.jsp");
			dispatcher.forward(request, response);

		}catch (NumberFormatException e) {
			request.setAttribute("msg", "単価には数字を入力してください");
			request.setAttribute("url", "insert.html");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String strTanka = request.getParameter("strTanka");

		int tanka = Integer.parseInt(strTanka);


		shouhinDAO sdao = new shouhinDAO();
		Shouhin s = new Shouhin(0, name, tanka);
		sdao.insert(s);

		response.sendRedirect("http://localhost:8080/example/slist");












//		request.setAttribute("insert", shou);
//
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/insert.jsp");
//		dispatcher.forward(request, response);

	}

}
