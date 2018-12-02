package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserGalleryDAO;
import model.Image;

/**
 * Servlet implementation class GetAllImages
 */
@WebServlet("/gallery/")
public class UserDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDisplay() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserGalleryDAO dao = new UserGalleryDAO();
		try {
			int page = 1;
			int recordsPerPage = 9;
			String username = (String) request.getSession().getAttribute("username");
			if (request.getParameter("page") != null)
				page = Integer.parseInt(request.getParameter("page"));
			ArrayList<Image> list = dao.get((page - 1) * recordsPerPage, recordsPerPage, username);
			int noOfRecords = dao.getNoOfRecords();
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			request.setAttribute("userGallery", list);
			request.setAttribute("noOfPages", noOfPages);
			request.setAttribute("currentPage", page);

			if (list.isEmpty()) {
				String view = "addImage.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request, response);
			}

			else {
				String view = "userHome.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request, response);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
