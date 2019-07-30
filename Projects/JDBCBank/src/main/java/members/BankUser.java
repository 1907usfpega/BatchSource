package members;

public class BankUser {
	private String username;
	private String password;
	
	public BankUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	@Override
	public String toString() {
		return "BankUser [username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
}
