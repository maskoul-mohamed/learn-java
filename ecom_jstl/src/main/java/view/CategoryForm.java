package view;


import java.util.List;

import model.Category;


public class CategoryForm {
	private long idCat;
	private String motCle="";
    private String nomCat;
	private String description;
	private List<Category> lesCats;

	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	
	public long getIdCat() {
		return idCat;
	}
	public void setIdCat(long idCat) {
		this.idCat = idCat;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Category> getLesCats() {
		return lesCats;
	}
	public void setLesCats(List<Category> lesCats) {
		this.lesCats = lesCats;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}

}
