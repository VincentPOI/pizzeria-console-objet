package fr.pizzeria.model;

public class Pizza {
	
	private int id;
	private String code;
	private String nom;
	private double prix;
	private CategoriePizza cate;
	private static int nbpizzas;

	public Pizza(String code, String nom, double prix, CategoriePizza cate) {
		super();	
		this.id= nbpizzas;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.cate = cate;
		Pizza.nbpizzas++;	
	}

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public void afficher() {
			System.out.println(code + " -> "+ nom + " (" + prix+"€)"+" / categorie :"+cate.toString());
	}
}
