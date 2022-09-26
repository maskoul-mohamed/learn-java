package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Catalogue;
import view.CatalogueForm;

/**
 * Servlet implementation class CatalogueServlet
 */
@WebServlet("/catalogue")
public class CatalogueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		CatalogueForm cf = new CatalogueForm();
		Catalogue cata = new Catalogue();
		
		if(request.getParameter("addCat") != null) {
			cf.setNomCat(request.getParameter("nomCat"));
			cf.setDescription(request.getParameter("description"));
			
			cata.addCategorie(cf.getNomCat(), cf.getDescription());
			
			cf.setLesCat(cata.selectAllCategories());
		} else if(request.getParameter("chercheCat")!=null ) {
			cf.setMotCle(request.getParameter("motCle"));
			cf.setLesCat(cata.selectByKeyword(cf.getMotCle()));
		
		} else if(request.getParameter("idCat") != null) {
			cf.setIdCat(Long.parseLong(request.getParameter("idCat")));
			
			cata.deleteCategorie(cf.getIdCat());
			cf.setLesCat(cata.selectAllCategories());
		}else {
			cf.setLesCat(cata.selectAllCategories());
		}
		
		
		
		HttpSession session = request.getSession();
		session.setAttribute("catForm", cf);
		response.sendRedirect("admin_categorie.jsp");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
