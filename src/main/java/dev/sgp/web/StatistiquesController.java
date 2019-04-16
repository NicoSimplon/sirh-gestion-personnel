package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiterWebService;
import dev.sgp.util.Constantes;

public class StatistiquesController extends HttpServlet {

	private static final long serialVersionUID = 2350792770555860495L;
	private VisiterWebService freqService = Constantes.VISITE_SERVICE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		
		List<VisiteWeb> listeVisites = freqService.listerVisites();

		req.setAttribute("listeVisites", listeVisites);
		req.getRequestDispatcher("/WEB-INF/views/collab/statistiques.jsp")
		.forward(req, resp);
	
	}
	
}
