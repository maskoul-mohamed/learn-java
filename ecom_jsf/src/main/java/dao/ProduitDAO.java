package dao;

import java.util.List;

import model.Categorie;
import model.Produit;

public interface ProduitDAO {
	public void addProduit(Produit produit);
	public Produit getAllProduits();
	public Produit getProduitById(int id);
	public List<Produit> listProduitsByCategorie(Categorie categ);
	public void updateProduit(Produit produit);
	public void removeproduit(int id);
}
