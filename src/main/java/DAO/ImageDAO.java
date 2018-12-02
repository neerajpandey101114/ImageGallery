package DAO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import model.Image;

public class ImageDAO {

	String url = "jdbc:mysql://localhost:3306/gallery";
	String user = "root";
	String pass = "mysqlpass";

	public Image get(int id) throws SQLException, IOException {
		Image image = null;

		String sql = "select * from images where id=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				image = new Image();
				String author= rs.getString(2);
				String description = rs.getString(3);
				Blob blob = rs.getBlob(4);

				InputStream isr = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[16177215];
				int bytesRead = -1;

				while ((bytesRead = isr.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				isr.close();
				outputStream.close();

				image.setUsername(author);
				image.setCaption(description);
				image.setBase64image(base64Image);
			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return image;
	}
}
