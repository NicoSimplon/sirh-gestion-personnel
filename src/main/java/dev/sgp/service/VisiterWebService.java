package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.VisiteWeb;

public class VisiterWebService {

	List<VisiteWeb> listeVisiterWeb = new ArrayList<>();

	public List<VisiteWeb> listerVisites() {
		return listeVisiterWeb;
	}

	public void sauvegarderVisite(VisiteWeb visite) {
		listeVisiterWeb.add(visite);
	}
	
}
