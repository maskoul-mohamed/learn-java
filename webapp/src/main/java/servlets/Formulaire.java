package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Formulaire
 */
@WebServlet("/formulaire")
public class Formulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Formulaire() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter output= response.getWriter();
		output.println("<html>");
		output.println("<head><title>Enregistrement coordonnées</title></head>");
		output.println("<body bgcolor=orange text=yellow>");
		output.println("<hr width=75%>");
		
		output.print("<p><b>Bonjour " + request.getParameter("civilite") + " ");
		output.print(request.getParameter("prenom") +" ");
		output.println(request.getParameter("nom") + ".");
		
		int age = Integer.parseInt(request.getParameter("age"));
		String message = "Vous êtes ";
		if(age >0 && age < 12) 
			message +="un enfant.";
		
		if(age >=12 && age < 18)
			message += "un adolescent.";
		if(age >=18 && age < 60)
			message += "un adulte.";
		if(age >=60)
			message += "une personne du troisième âge.";
		output.println(message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
