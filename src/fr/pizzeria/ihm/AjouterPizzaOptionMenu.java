package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {

	private String libelle;
	private static final Logger LOG = LoggerFactory.getLogger("dev.console");
	/**
	 * @param tabpizza
	 */
	public AjouterPizzaOptionMenu(PizzaDaoImpl tabpizza, Scanner scn) {
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

		String code;
		LOG.info("saisir code :");
		code = scn.next();

		String nom;
		LOG.info("saisir nom (sans espace):");
		nom = scn.next();

		double prix;
		LOG.info("saisir prix :");
		prix = scn.nextDouble();
		
		
		LOG.info("saisir la cat�gorie (VIANDE/POISSON/SANS_VIANDE):");
		CategoriePizza cate = CategoriePizza.valueOf(scn.next().toUpperCase());
		
		try {
			this.tabpizza.saveNewPizza(new Pizza(code, nom, prix,cate));
		} catch (SavePizzaException e) {
			LOG.info(e.getMessage());
		}

		return false;

	}
}
