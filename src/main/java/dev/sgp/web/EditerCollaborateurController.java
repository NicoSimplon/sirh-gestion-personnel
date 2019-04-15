package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2796943719061702802L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String matriculeParam = req.getParameter("matricule");

		if (matriculeParam != null && !matriculeParam.equals("")) {

			resp.setContentType("text/html");

			resp.getWriter().write("<h1>Liste des collaborateurs</h1>" + "Matricule : " + matriculeParam);

		} else {
			resp.sendError(400, "Un matricule est attendu");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String matriculeParam = req.getParameter("matricule");
		String titreParam = req.getParameter("titre");
		String nomParam = req.getParameter("nom");
		String prenomParam = req.getParameter("prenom");
		
		List<String> parametres = new ArrayList<>();
		parametres.add(matriculeParam);
		parametres.add(titreParam);
		parametres.add(nomParam);
		parametres.add(prenomParam);
		
		List<String> params = new ArrayList<>();
		params.add("matricule");
		params.add("titre");
		params.add("nom");
		params.add("prenom");
		
		int i = 0;
		
		String message = "Les paramètres suivants sont incorrects: ";

		if (matriculeParam != null && titreParam != null && nomParam != null && prenomParam != null) {

			resp.setStatus(201);
			resp.setContentType("text/html");

			resp.getWriter().write("<h1>Liste des collaborateurs</h1>" 
					+ "Matricule : " + matriculeParam + ", "
					+ "Titre : " + titreParam + ", " 
					+ "Nom : " + nomParam + ", " 
					+ "Prénom : " + prenomParam);

		} else {
			
			for (String p : parametres) {
				if (p == null) {
					message += params.get(i);
					i++;
				}
			}
			
			resp.sendError(400, message);		
		}

	}

}
