package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String designation;
	private String photo;

	private int prix;

	private int quantite;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie categorie;

	public Produit() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int idProduit) {
		this.id = idProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getPrix() {
		return this.prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}