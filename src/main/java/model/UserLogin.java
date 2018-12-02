package model;

public class UserLogin {
	String username;
	String password;
	boolean userValid;

	public boolean isUserValid() {
		return userValid;
	}

	public void setUserValid(boolean userValid) {
		this.userValid = userValid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
