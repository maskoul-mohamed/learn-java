package bd;

public class Person extends ConnexionBD {
	private String firstname;
	private String lastname;
	private String password;
	public Person() {
		super();
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname.substring(0,1).toUpperCase() + firstname.substring(1, firstname.length()).toLowerCase();
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname.toUpperCase();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean save() {
		if(isExist()) {
			return false;
		} else {
			 miseAJour("INSERT INTO person(firstname, lastname, password) VALUES(\"" +firstname+"\" ,\"" +lastname+"\",\"" +password+"\")");
			 return true;
		}
		
	}
	
	private boolean isExist() {
		lire("SELECT * FROM person WHERE firstname=\""+firstname +"\" AND lastname=\"" +lastname +"\"");
		return suivant();
	}
}
