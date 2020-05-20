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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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


		shouhinDAO dao = new shouhinDAO();

		Shouhin s = dao.findBySid(sid);


		request.setAttribute("shouhin", s);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String sname = request.getParameter("sname");
		String sidStr = request.getParameter("sidStr");
		String tankaStr = request.getParameter("tankaStr");

		int sid = Integer.parseInt(sidStr);
		int tanka = Integer.parseInt(tankaStr);


		shouhinDAO dao = new shouhinDAO();
		Shouhin s = new Shouhin(sid, sname, tanka);

		dao.update(s);

		response.sendRedirect("slist");
	}

}
