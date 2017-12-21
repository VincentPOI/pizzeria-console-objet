package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans_Viande");
	private String categorie = "";

	CategoriePizza(String categorie) {
		this.categorie = categorie;
	}
	
	public String toString(){
		return categorie;
	}
}
