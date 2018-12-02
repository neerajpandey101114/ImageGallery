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
import java.util.ArrayList;
import java.util.Base64;

import model.Image;

public class UserGalleryDAO {
	String url = "jdbc:mysql://localhost:3306/imageGallery";
	String user = "root";
	String pass = "mysqlpass";
	ArrayList<Image> gallery = new ArrayList<Image>();
	private int noOfRecords;
	
	public ArrayList<Image> get(int offset, int noOfRecords, String user) throws SQLException, IOException {
		Image all = null;

		String sql = "select SQL_CALC_FOUND_ROWS * from gallery where username=? limit "
                + offset + ", " + noOfRecords;

		try {  
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				all = new Image();
				String username = rs.getString(2);
				String title = rs.getString(3);
				String caption = rs.getString(4);
				
				Blob blob = rs.getBlob(5);

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
				
				all.setUsername(username);
				all.setTitle(title);
				all.setCaption(caption);
				all.setBase64image(base64Image);
				gallery.add(all);
			}
			rs.close();
			rs = ps.executeQuery("SELECT FOUND_ROWS()");
			if(rs.next())
                this.noOfRecords = rs.getInt(1);
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return gallery;
	}
	public int getNoOfRecords() {
        return noOfRecords;
    }
}
