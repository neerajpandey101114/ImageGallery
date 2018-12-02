package model;

public class UserRegister {
	String username;
	String password;
	boolean userRegistered;

	public boolean isUserRegistered() {
		return userRegistered;
	}

	public void setUserRegistered(boolean userRegistered) {
		this.userRegistered = userRegistered;
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
