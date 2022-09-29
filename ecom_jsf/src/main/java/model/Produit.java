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
	private int idProduit;

	private String photo;

	private int prix;

	private int quantite;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie categorie1;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie categorie2;

	public Produit() {
	}

	public int getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
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

	public Categorie getCategorie1() {
		return this.categorie1;
	}

	public void setCategorie1(Categorie categorie1) {
		this.categorie1 = categorie1;
	}

	public Categorie getCategorie2() {
		return this.categorie2;
	}

	public void setCategorie2(Categorie categorie2) {
		this.categorie2 = categorie2;
	}

}