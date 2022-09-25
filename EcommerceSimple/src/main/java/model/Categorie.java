package model;

public class Categorie {
	private Long idCat;
	private String titre;
	private String description;
	
	public Categorie() {}
	
	
	
	public Categorie(Long idCat, String titre, String description) {
		super();
		this.idCat = idCat;
		this.titre = titre;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
