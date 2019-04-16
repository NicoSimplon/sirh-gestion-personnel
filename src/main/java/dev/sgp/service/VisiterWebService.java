package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.VisiteWeb;

public class VisiterWebService {

	static List<VisiteWeb> listeVisiterWeb = new ArrayList<>();

	public static List<VisiteWeb> listerVisites() {
		return listeVisiterWeb;
	}

	public static void sauvegarderVisite(VisiteWeb visite) {
		listeVisiterWeb.add(visite);
	}
	
}
