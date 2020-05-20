package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Shouhin;
import model.Uriage;
import model.UriageDAO;
import model.shouhinDAO;

/**
 * Servlet implementation class UriageServlet
 */
@WebServlet("/uriage")
public class UriageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UriageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sidStr = request.getParameter("sidStr");
		int sid = Integer.parseInt(sidStr);

		UriageDAO udao = new UriageDAO();
		shouhinDAO sdao = new shouhinDAO();

		Uriage u = udao.findBySid(sid);
		Shouhin s = sdao.findBySid(sid);

		ArrayList<Uriage> list = udao.findAll();

		request.setAttribute("list", list);


		request.setAttribute("uriage", u);
		request.setAttribute("shouhin", s);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/uriage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String sidStr = request.getParameter("sidStr");
			String kosuStr = request.getParameter("kosuStr");

			int sid = Integer.parseInt(sidStr);
			int kosu = Integer.parseInt(kosuStr);



			UriageDAO dao = new UriageDAO();



			Uriage u = new Uriage(0, sid, kosu, null);

			dao.insert(u);


			response.sendRedirect("uriage?sidStr="+sid);

			}catch (NumberFormatException e) {
				request.setAttribute("msg", "個数には数字を入力してください");
				request.setAttribute("url", "uinsert.html");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
			}
	}

}
