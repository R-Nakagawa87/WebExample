package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Keisan;

/**
 * Servlet implementation class KeisanServlet
 */
@WebServlet("/keisan")
public class KeisanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public KeisanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/keisan.jsp");
		dispatcher.forward(request, response);

		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String strMode = request.getParameter("strMode");
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		int mode = Integer.parseInt(strMode);

		Keisan k = new Keisan(n1, n2, mode);

		request.setAttribute("keisan", k);



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String strMode = request.getParameter("strMode");
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		int mode = Integer.parseInt(strMode);

		Keisan k = new Keisan(n1, n2, mode);

		request.setAttribute("keisan", k);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/keisan.jsp");
		dispatcher.forward(request, response);
	}

}
