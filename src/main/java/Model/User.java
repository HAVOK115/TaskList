package Model;

public class User {
	private Integer id;
	private String username;
	private String mail;
	private String password;

	public User(Integer id, String username, String mail, String password) {
		super();
		this.id = id;
		this.username = username;
		this.mail = mail;
		this.password = password;
	}

	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", mail=" + mail + ", password=" + password + "]";
	}
}