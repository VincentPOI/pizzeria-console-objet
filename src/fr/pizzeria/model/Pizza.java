package fr.pizzeria.model;
import fr.pizzeria.utils.StringUtils;
import fr.pizzeria.utils.ToString;
public class Pizza {
	
	private int id;
	
	@ToString(uppercase = true, separateur = " -> ")
	private String code;
	
	@ToString(separateur = " (")
	private String nom;
	
	@ToString(separateur = "€) ")
	private double prix;
	
	@ToString
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

	public String toString(){
		return StringUtils.getStringValue(this);
	}
	
}
