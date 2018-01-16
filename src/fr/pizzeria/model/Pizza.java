package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.pizzeria.utils.StringUtils;
import fr.pizzeria.utils.ToString;

@Entity
@Table(name = "pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ToString(uppercase = true, separateur = " -> ")
	@Column(name = "code")
	private String code;

	@ToString(separateur = " (")
	@Column(name = "Name")
	private String nom;

	@ToString(separateur = "€) ")
	@Column(name = "Price")
	private double prix;

	@ToString
	@Enumerated(EnumType.STRING)
	@Column(name = "Category")
	private CategoriePizza cate;


	public Pizza(String code, String nom, double prix, CategoriePizza cate) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.cate = cate;
	}
	
	public Pizza() {
	}

	public CategoriePizza getCate() {
		return cate;
	}

	public void setCate(CategoriePizza cate) {
		this.cate = cate;
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

	public String toString() {
		return StringUtils.getStringValue(this);
	}

}
