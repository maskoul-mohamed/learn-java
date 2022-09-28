package actions;

import dao.CategorieDAO;
import model.Categorie;

import java.util.ArrayList;
import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;


import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;


import service.CategorieDAOImpl;

public class CategorieAction extends ActionSupport implements ServletRequestAware,SessionAware
{

	private static final long serialVersionUID = 1L;
	private ArrayList<Categorie> listCategories = new ArrayList<Categorie>();
	private int idCategorie;
	private String nomCategorie;
	private String description;	
	private String keyword ="";	
	
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}




	private Categorie categorie;

	
	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Map<String, Object> getMaSession() {
		return maSession;
	}

	public void setMaSession(Map<String, Object> maSession) {
		this.maSession = maSession;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}




	private HttpServletRequest servletRequest;
	private Map<String, Object> maSession;

	public ArrayList<Categorie> getListCategories() {
		CategorieDAO ct = new CategorieDAOImpl();
		listCategories = (ArrayList<Categorie>) ct.listCategories();
		return listCategories;
	}
	


	public void setListCategories(ArrayList<Categorie> listCategories) {
		this.listCategories = listCategories;
	}
	

	
	@Override
	public void setSession(Map<String, Object> session) {
		this.maSession=session;	
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;
	}



	public Categorie enregistrer() {
		Categorie categorie = new Categorie();
		CategorieDAO ct = new CategorieDAOImpl();

		ct.addCategorie(categorie);
		return categorie;
	}

	public String lister() {
		CategorieDAO ct = new CategorieDAOImpl();
		listCategories = (ArrayList<Categorie>) ct.listCategories();
		for(int i = 0 ; i< listCategories.size(); i++) {
			System.out.println(listCategories.get(i).getDescription());
		}
		return "success";
	}


	public String search() {
		CategorieDAO ct = new CategorieDAOImpl();
		listCategories = (ArrayList<Categorie>) ct.selectCatByKeyword(getKeyword());
		return "success";
	}
	
	public String saisir() {
		return "success";
	}
}
