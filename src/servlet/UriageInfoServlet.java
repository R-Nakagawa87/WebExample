package servlet;

import java.io.IOException;

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
 * Servlet implementation class UriageInfoServlet
 */
@WebServlet("/uinfo")
public class UriageInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UriageInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String uidStr = request.getParameter("uidStr");
		int uid = Integer.parseInt(uidStr);


		UriageDAO udao = new UriageDAO();
		shouhinDAO sdao = new shouhinDAO();

		Uriage u = udao.findByUid(uid);
		Shouhin s = sdao.findBySid(u.getSid());

		int kotae = u.getKosu()*s.getTanka();


		request.setAttribute("shouhin", s);
		request.setAttribute("uriage", u);
		request.setAttribute("kotae", kotae);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/uinfo.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
