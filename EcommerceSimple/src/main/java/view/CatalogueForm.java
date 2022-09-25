package view;

import java.util.ArrayList;
import java.util.Vector;

import model.Categorie;

public class CatalogueForm {
	private long idCat;
	private String motCle;
	private String nomCat;
	private String description;
	private ArrayList<Categorie>  lesCat = new ArrayList<Categorie>();
	public long getIdCat() {
		return idCat;
	}
	public void setIdCat(long idCat) {
		this.idCat = idCat;
	}
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Categorie> getLesCat() {
		return lesCat;
	}
	public void setLesCat(ArrayList<Categorie> lesCat) {
		this.lesCat = lesCat;
	}
	
	
}
