package fr.pizzeria.console;


import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.Menu;

public class PizzeriaAdminConsoleApp {

	public static Pizza[] pizzas = new Pizza[1000];
	private static final Logger LOG = LoggerFactory.getLogger("dev.console");

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int choix = 99;
		PizzaDaoImpl pizzas = new PizzaDaoImpl();

		Menu menu = new Menu(pizzas, scn);

		do {
			menu.afficher();
			LOG.info("99. Quitter");
			choix = scn.nextInt();
				switch (choix) {

				case 1:

					menu.getOptions(0).execute();

					break;

				case 2:
					menu.getOptions(1).execute();

					break;

				case 3:

					menu.getOptions(2).execute();

					break;

				case 4:

					menu.getOptions(3).execute();

					break;

				default:
					break;
				}

		} while (choix != 99);

		LOG.info("Aurevoir :(");
		scn.close();
	}
}
