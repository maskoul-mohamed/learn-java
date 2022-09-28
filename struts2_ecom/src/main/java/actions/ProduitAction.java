package actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProduitDAO;
import model.Categorie;
import model.Produit;
import service.ProduitDAOImpl;

public class ProduitAction extends ActionSupport implements ServletRequestAware, SessionAware {
	private static final long serialVersionUID = 1L;

	private HttpServletRequest servletRequest;
	private Map<String, Object> maSession;

	private ArrayList<Produit> listProduits = new ArrayList<Produit>();
	private int id;
	private String designation;
	private String prix;
	private int quantite;
	private java.util.Date dateInscription;

	private File photo;
	private String photoContentType;
	private String photoFileName;

	public Map<String, Object> getMaSession() {
		return maSession;
	}

	public void setMaSession(Map<String, Object> maSession) {
		this.maSession = maSession;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.maSession = session;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public ArrayList<Produit> getListProduits() {
		return listProduits;
	}

	public void setListProduits(ArrayList<Produit> listProduits) {
		this.listProduits = listProduits;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public java.util.Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(java.util.Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String AllProduits() {
		ProduitDAO produitDao = new ProduitDAOImpl();
		listProduits = (ArrayList<Produit>) produitDao.listProduits();
		System.out.println(	this.listProduits.size());
		return "success";
	}
}
