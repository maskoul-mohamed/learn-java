package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorie database table.
 * 
 */
@Entity
@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c")
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCategorie;

	private String description;

	private String nomCategorie;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="categorie")
	private List<Produit> produits;

	public Categorie() {
	}

	public int getIdCategorie() {
		return this.idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNomCategorie() {
		return this.nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setCategorie(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setCategorie(null);

		return produit;
	}

}