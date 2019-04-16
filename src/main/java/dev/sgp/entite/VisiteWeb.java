package dev.sgp.entite;

public class VisiteWeb {
	
	private Integer id;
	
	private String chemain;
	
	private Integer tempsExecution;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the chemain
	 */
	public String getChemain() {
		return chemain;
	}

	/**
	 * @param chemain the chemain to set
	 */
	public void setChemain(String chemain) {
		this.chemain = chemain;
	}

	/**
	 * @return the tempsExecution
	 */
	public Integer getTempsExecution() {
		return tempsExecution;
	}

	/**
	 * @param tempsExecution the tempsExecution to set
	 */
	public void setTempsExecution(Integer tempsExecution) {
		this.tempsExecution = tempsExecution;
	}
}
