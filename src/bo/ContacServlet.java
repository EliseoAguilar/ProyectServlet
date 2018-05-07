package bo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContacDao;
import pojo.Contac;
import pojo.User;

/**
 * Servlet implementation class ContacServlet
 */
@WebServlet("/ContacServlet")
public class ContacServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContacServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Contac> listCont = ContacDao.getAllContac();
		String opt = request.getParameter("opt");
		
		if(opt != null && opt.equals("UPDATE")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Contac con = ContacDao.getContac(id);
			request.setAttribute("con", con);
		}
		request.setAttribute("contacsList", listCont);
		RequestDispatcher rd = request.getRequestDispatcher("contac.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opt = request.getParameter("opt");
		HttpSession sesion = request.getSession();
		User us = (User) sesion.getAttribute("user");
		Contac con = null;
		int id = 0;
		switch (opt) {
		case "CREATE":
			con = new Contac(request.getParameter("name"), request.getParameter("number"), 0, us.getId());
			ContacDao.insertContac(con);
			break;
		case "UPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			con = new Contac(request.getParameter("name"), request.getParameter("number"), id, us.getId());
			ContacDao.updateContac(con);
			break;
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ContacDao.deleteContac(id);
			break;
		default:
			break;
		}

		response.sendRedirect("ContacServlet");
	}

}
