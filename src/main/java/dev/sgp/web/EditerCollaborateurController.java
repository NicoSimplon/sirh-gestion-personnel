package dev.sgp.web;

import java.io.IOException;

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

		if (matriculeParam != null && titreParam != null && nomParam != null && prenomParam != null) {

			resp.setStatus(201);
			resp.setContentType("text/html");

			resp.getWriter().write("<h1>Liste des collaborateurs</h1>" 
					+ "Matricule : " + matriculeParam + ", "
					+ "Titre : " + titreParam + ", " 
					+ "Nom : " + nomParam + ", " 
					+ "Prénom : " + prenomParam);

		} else {

			if (matriculeParam == null && titreParam != null && nomParam != null && prenomParam != null) {

				resp.sendError(400, "Les paramètres suivants sont incorrects: matricule");

			} else if (matriculeParam == null && titreParam == null && nomParam != null && prenomParam != null) {

				resp.sendError(400, "Les paramètres suivants sont incorrects: matricule, titre");

			} else if (matriculeParam == null && titreParam == null && nomParam == null && prenomParam != null) {

				resp.sendError(400, "Les paramètres suivants sont incorrects: matricule, titre, nom");

			} else if (matriculeParam == null && titreParam == null && nomParam == null && prenomParam == null) {

				resp.sendError(400, "Les paramètres suivants sont incorrects: matricule, titre, nom, prenom");

			}
		}

	}

}
