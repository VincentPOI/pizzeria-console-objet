package fr.pizzeria.ihm;

import static fr.pizzeria.console.PizzeriaAdminConsoleApp.LOG;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {

	private String libelle;
	/**
	 * @param tabpizza
	 */
	public AjouterPizzaOptionMenu(IPizzaDao tabpizza, Scanner scn) {
		super(tabpizza, scn);
		this.libelle = super.getLibelle() + "Ajouter une pizza";
	}

	@Override
	public String getLibelle() {
		return this.libelle;
	}

	@Override
	public boolean execute() {
		LOG.info("Ajout d'une nouvelle pizza :");

		try {
		String code;
		LOG.info("saisir code :");
		code = scn.next();

		String nom;
		LOG.info("saisir nom (sans espace):");
		nom = scn.next();

		double prix;
		LOG.info("saisir prix :");
		prix =  Double.parseDouble(scn.next()) ;	
		
		LOG.info("saisir la catégorie (VIANDE/POISSON/SANS_VIANDE):");
		CategoriePizza cate = CategoriePizza.valueOf(scn.next().toUpperCase());
		
			this.tabpizza.saveNewPizza(new Pizza(code, nom, prix,cate));
		} catch (SavePizzaException e) {
			LOG.info(e.getMessage());
		}catch (NumberFormatException e){		
			LOG.info("le prix doit etre un réel");
		}

		return false;

	}
}
