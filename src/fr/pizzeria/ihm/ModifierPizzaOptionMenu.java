package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {

	private String libelle;
	private static final Logger LOG = LoggerFactory.getLogger("dev.console");

	/**
	 * @param tabpizza
	 */
	public ModifierPizzaOptionMenu(PizzaDaoImpl tabpizza, Scanner scn) {
		super(tabpizza, scn);
		this.libelle = super.getLibelle() + "Modifier une pizza";
	}

	@Override
	public String getLibelle() {
		return this.libelle;
	}

	@Override
	public boolean execute() {
		LOG.info("Mise � jour d'une pizza :");
		LOG.info("Code de la pizza � mettre � jours ?");
		LOG.info("(99 pour abandoner)");

		String codeupdatepizza = scn.next();

		if (codeupdatepizza.equals(99)) {
			return false;
		}
		
		String code;
		LOG.info("saisir code :");
		code = scn.next();
		

		String nom;
		LOG.info("saisir nom (sans espace):");
		nom = scn.next();

		double prix;
		LOG.info("saisir prix :");
		prix = scn.nextDouble();
		
		LOG.info("saisir la cat�gorie (VIANDE/POISSON/SANS_VIANDE) :");
		CategoriePizza cate = CategoriePizza.valueOf(scn.next().toUpperCase());
		
		try {
			this.tabpizza.updatePizza(codeupdatepizza, new Pizza(code, nom, prix,cate));
		} catch (UpdatePizzaException e) {
			System.out.println(e.getMessage());
		}
		

		return true;

	}
}
