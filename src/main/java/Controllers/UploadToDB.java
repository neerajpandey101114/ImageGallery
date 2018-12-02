package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/gallery/UploadToDB")
@MultipartConfig(maxFileSize = 16177215)
public class UploadToDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadToDB() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String title = request.getParameter("title");
		String caption = request.getParameter("caption");
		
		String url = "jdbc:mysql://localhost:3306/imageGallery";
		String user = "root";
		String pass = "mysqlpass";
		
		InputStream isr = null;
		
		Part filePart = request.getPart("image");
		Connection con = null;
		
		if(filePart != null) {
			isr = filePart.getInputStream();
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			String sql = "Insert into gallery (username, title, caption, image) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, title);
			ps.setString(3, caption);
			
			if(isr != null) {
				ps.setBlob(4, isr);
			}
			
			int flag = ps.executeUpdate();
			
			if(flag > 0) {
				response.sendRedirect(request.getContextPath() + "");
			}
			con.close();
		}
		catch(Exception e) {
			out.println(e);
			System.out.println(e);
		}
	}

}
