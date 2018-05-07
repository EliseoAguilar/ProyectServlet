package pojo;

public class Contac {
	String name;
	String number;
	Integer id;
	Integer idUser;

	
	
	public Contac(String name, String number, Integer id, Integer idUser) {
		this.name = name;
		this.number = number;
		this.id = id;
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

}
