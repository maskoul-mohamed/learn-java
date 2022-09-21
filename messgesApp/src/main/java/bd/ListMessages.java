package bd;

import java.sql.SQLException;

public class ListMessages extends ConnexionBD {
	
	public ListMessages(int idPerson) {
		lire("SELECT * FROM message WHERE idPerson=\""+idPerson+"\"");
	}
	
	
	public String title() {
		try {
			return résultat.getString("title");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String text() {
		try {
			return résultat.getString("text");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
