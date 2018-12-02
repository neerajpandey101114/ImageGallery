package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.UserLogin;
import model.UserRegister;

public class RegisterDAO {

	static String url = "jdbc:mysql://localhost:3306/imageGallery";
	static String username = "root";
	static String pass = "mysqlpass";

	public static UserRegister addUserInDb(UserLogin user) {
		// TODO Auto-generated method stub
		UserRegister register = new UserRegister();
		LoginDAO.searchUserInDb(user);
		register.setUserRegistered(false);
		
		if (!user.isUserValid()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, username, pass);
				String sql = "insert into users (username, password) values(?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());

				int flag = ps.executeUpdate();

				if (flag > 0) {
					register.setUserRegistered(true);
				}
			}

			catch (Exception e) {
				System.out.println(e);
			}
		}
		return register;
	}
}