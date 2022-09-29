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
	@OneToMany(mappedBy="categorie1")
	private List<Produit> produits1;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="categorie2")
	private List<Produit> produits2;

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

	public List<Produit> getProduits1() {
		return this.produits1;
	}

	public void setProduits1(List<Produit> produits1) {
		this.produits1 = produits1;
	}

	public Produit addProduits1(Produit produits1) {
		getProduits1().add(produits1);
		produits1.setCategorie1(this);

		return produits1;
	}

	public Produit removeProduits1(Produit produits1) {
		getProduits1().remove(produits1);
		produits1.setCategorie1(null);

		return produits1;
	}

	public List<Produit> getProduits2() {
		return this.produits2;
	}

	public void setProduits2(List<Produit> produits2) {
		this.produits2 = produits2;
	}

	public Produit addProduits2(Produit produits2) {
		getProduits2().add(produits2);
		produits2.setCategorie2(this);

		return produits2;
	}

	public Produit removeProduits2(Produit produits2) {
		getProduits2().remove(produits2);
		produits2.setCategorie2(null);

		return produits2;
	}

}