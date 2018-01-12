package fr.pizzeria.ihm;

import static fr.pizzeria.console.PizzeriaAdminConsoleApp.LOG;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {

	private String libelle;


	/**
	 * @param tabpizza
	 */
	public ModifierPizzaOptionMenu(IPizzaDao tabpizza, Scanner scn) {
		super(tabpizza, scn);
		this.libelle = super.getLibelle() + "Modifier une pizza";
	}

	@Override
	public String getLibelle() {
		return this.libelle;
	}

	@Override
	public boolean execute() {
		try {
		LOG.info("Mise à jour d'une pizza :");
		LOG.info("Code de la pizza à mettre à jours ?");
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
		prix =  Double.parseDouble(scn.next()) ;	
		
		LOG.info("saisir la catégorie (VIANDE/POISSON/SANS_VIANDE) :");
		CategoriePizza cate = CategoriePizza.valueOf(scn.next().toUpperCase());
		
		
			this.tabpizza.updatePizza(codeupdatepizza, new Pizza(code, nom, prix,cate));
		} catch (UpdatePizzaException e) {
			System.out.println(e.getMessage());
		}catch (NumberFormatException e){		
			LOG.info("le prix doit etre un réel");
		}catch(IllegalArgumentException e){
			LOG.info("veuillez saisir une catégorie valable : VIANDE/POISSON/SANS_VIANDE " +e.getMessage());
			}
		

		return true;

	}
}
