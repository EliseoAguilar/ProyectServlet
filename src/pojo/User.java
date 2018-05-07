package pojo;

public class User {
	Integer id;
	String email;
	String password;
	Boolean state;
	String update;
	String create;

	public User() {

	}

	public User(Integer id,String email, String password, Boolean state, String update, String create) {
		this.id=id;
		this.email = email;
		this.password = password;
		this.state = state;
		this.update = update;
		this.create = create;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getCreate() {
		return create;
	}

	public void setCreate(String create) {
		this.create = create;
	}

}
