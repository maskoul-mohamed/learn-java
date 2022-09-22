package model;

public class Categorie {
	private Long idCat;
	private String titre;
	private String descriptiion;
	
	public Categorie() {}
	
	
	
	public Categorie(Long idCat, String titre, String descriptiion) {
		super();
		this.idCat = idCat;
		this.titre = titre;
		this.descriptiion = descriptiion;
	}



	public Long getIdCat() {
		return idCat;
	}
	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescriptiion() {
		return descriptiion;
	}
	public void setDescriptiion(String descriptiion) {
		descriptiion = descriptiion;
	}
	
}
