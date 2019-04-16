package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class AjouterCollaborateursController extends HttpServlet {
	
	private static final long serialVersionUID = -8706709601290964032L;
	
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/collab/ajouterCollaborateurs.jsp")
		.forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String date_naissance = req.getParameter("date_naissance");
		String adresse = req.getParameter("adresse");
		String num_secu = req.getParameter("num_secu");
		
		if (nom != null && prenom != null && date_naissance != null && adresse != null && num_secu != null) {

			LocalDate naissance = LocalDate.parse(date_naissance, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			
			int id = collabService.listerCollaborateurs().size() + 1;
			
			Collaborateur nouveauCollab = new Collaborateur();
			nouveauCollab.setNom(nom);
			nouveauCollab.setPrenom(prenom);
			nouveauCollab.setAdresse(adresse);
			nouveauCollab.setEmailPro(prenom.replaceAll("\\W", "") + "." + nom.replaceAll("\\W", "") + "@societe.com");
			nouveauCollab.setNumeroDeSecuriteSociale(num_secu);
			nouveauCollab.setDateDeNaissance(naissance);
			nouveauCollab.setDateHeureCreation(ZonedDateTime.now());
			nouveauCollab.setMatricule("M" + id);
			nouveauCollab.setPhoto("img" + id);
			nouveauCollab.setActif(true);
			
			collabService.sauvegarderCollaborateur(nouveauCollab);
			
			
			resp.setContentType("text/html");

			resp.getWriter().write(
					"Nom: " + nouveauCollab.getNom() + " " + nouveauCollab.getPrenom() + "<br>"
					+ "Adresse: " + nouveauCollab.getAdresse() + "<br>"
					+ "Email: " + nouveauCollab.getEmailPro() + "<br>"
					+ "Numéro de Sécurité Sociale: " + nouveauCollab.getNumeroDeSecuriteSociale() + "<br>"
					+ "Date de Naissance: " + nouveauCollab.getDateDeNaissance() + "<br>"
					+ "Matricule: " + nouveauCollab.getMatricule() + "<br>"
			);
			
		} else {
			
			resp.sendError(400, "Tous les champs sont requis");
			
		}
		
	
	}

}
