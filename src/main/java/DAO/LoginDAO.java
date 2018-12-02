package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.UserLogin;

public class LoginDAO {

	static String url = "jdbc:mysql://localhost:3306/imageGallery";
	static String username = "root";
	static String pass = "mysqlpass";

	public static UserLogin searchUserInDb(UserLogin user) {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pass);
			String sql = "select * from users where username=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();
			boolean found = rs.next();

			if (found) {
				user.setUserValid(true);
			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}
}