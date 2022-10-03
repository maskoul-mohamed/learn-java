package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Categorie;
import service.CategorieDAOImpl;

@ManagedBean(name = "adminCategories", eager = true)
@SessionScoped
public class AdminCategories implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private List<Categorie> allCategories;
	private List<Categorie> filteredCategories;

	private Categorie categorieToAdd = new Categorie();
	private int categorie;
	private Categorie selectedCategorie;

	private boolean editMode = false;
	private boolean addMode = false;

	private CategorieDAOImpl categDao = new CategorieDAOImpl();
	private CategorieDAOImpl categService;
	{
		categService = new CategorieDAOImpl();
	}

	@PostConstruct
	public void init() {
		allCategories = getAllCategories();
		System.out.print(allCategories.get(0));
	}

	public void edit() {
		System.out.println("edit clicked");
		editMode = true;
		addMode = false;
	}

	public void cancelUpdate() {
		editMode = false;
	}

	public void prepareAdd() {
		addMode = true;
		editMode = false;
	}

	public void cancelAdd() {
		categorieToAdd = new Categorie();
		addMode = false;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

	public List<Categorie> getAllCategories() {
		allCategories = categDao.listCategories();
		return allCategories;
	}

	public void setAllCategories(List<Categorie> allCategories) {
		this.allCategories = allCategories;
	}

	public Categorie getSelectedCategorie() {
		return selectedCategorie;
	}

	public void setSelectedCategorie(Categorie selectedCategorie) {
		this.selectedCategorie = selectedCategorie;
	}

	public List<Categorie> getFilteredCategories() {
		return filteredCategories;
	}

	public void setFilteredCategories(List<Categorie> filteredCategorie) {
		this.filteredCategories = filteredCategorie;
	}

	public CategorieDAOImpl getCategService() {
		return categService;
	}

	public void setCategService(CategorieDAOImpl categService) {
		this.categService = categService;
	}

	public Categorie getCategorieToAdd() {
		return categorieToAdd;
	}

	public void setCategorieToAdd(Categorie categorieToAdd) {
		this.categorieToAdd = categorieToAdd;
	}

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	public CategorieDAOImpl getCategDao() {
		return categDao;
	}

	public void setCategDao(CategorieDAOImpl categDao) {
		this.categDao = categDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void deleteSelectedCategorie() {
		categService.removeCategorie(selectedCategorie.getIdCategorie());
		System.out.println("deleting... => " + selectedCategorie);
	      FacesContext context = FacesContext.getCurrentInstance();
	      context.addMessage("msgDel", new FacesMessage(FacesMessage.SEVERITY_INFO, "Categorie Supprimée", selectedCategorie.toString()));
	      allCategories=getAllCategories();

	}

	public void updateCategorie() {
		if (selectedCategorie != null) {
			System.out.println("Updating... => " + selectedCategorie);
			categService.updateCategorie(selectedCategorie);
			System.out.println("Modification de la catégorie avec Succès");
			addMessage(FacesMessage.SEVERITY_INFO, "Modification Réussie", "Modification de la catégorie avec Succès");
		} else {
			addMessage(FacesMessage.SEVERITY_WARN, "Modification échouée",
					"Erreur lors de la modification de la catégorie");
		}
		editMode = false;
	}

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}
	
	public void addCategorie() {
		if(categorieToAdd != null) {
			System.out.println("Adding... => " + categorieToAdd);
			categService.addCategorie(categorieToAdd);
			System.out.println("Addtion new categorie success!");
			addMessage(FacesMessage.SEVERITY_INFO, "Addition success!", "new categorie added");
		} else {
			addMessage(FacesMessage.SEVERITY_WARN, "Addition error",
					"Error while adding new categorie");
		}
		addMode = false;
	}
}
