package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {

	// public Pizza[] pizzas;
	public List<Pizza> pizzas = new ArrayList<Pizza>();

	public PizzaDaoImpl() {
		super();
		pizzas.add(new Pizza("PEP", "Pépéroni", 12.50));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00));
		pizzas.add(new Pizza("REIN", "La Reine", 11.50));
		pizzas.add(new Pizza("FRO", "Les 4 fromages", 12.00));
		pizzas.add(new Pizza("CAN", "La cannibale", 12.50));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.00));
		pizzas.add(new Pizza("ORI", "L'Orientale", 13.50));
		pizzas.add(new Pizza("IND", "L'indienne", 14.00));
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {

		// boolean pizzaSauvegarde = false;
		this.pizzas.add(pizza);

		// for (int i = 0; i < this.pizzas.length; i++) {
		// if (this.pizzas[i] == null) {
		// this.pizzas[i] = pizza;
		// pizzaSauvegarde = true;
		// }
		// if (!pizzaSauvegarde){
		// throw new SavePizzaException("le tableau est plein");
		// }
		// }
		//

		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {

		boolean pizzaUpdate = false;

		for (Pizza piz : this.pizzas) {
			if (piz.getCode().equals(codePizza)) {
				this.pizzas.set(this.pizzas.indexOf(piz), pizza);
				pizzaUpdate = true;
			}
		}
		if (!pizzaUpdate) {
			throw new UpdatePizzaException("la pizza n'existe pas");
		}

		// for (int i = 0; i < this.pizzas.length; i++) {
		// if (this.pizzas[i] != null) {
		// if (this.pizzas[i].getCode().equals(codePizza)) {
		// this.pizzas[i] = pizza;
		// pizzaUpdate = true;
		// }
		// }
		// if (!pizzaUpdate){
		// throw new UpdatePizzaException("la pizza n'existe pas");
		// }
		// }
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {

		boolean pizzaDelete = false;
		Pizza todelete = null;

		for (Pizza piz : this.pizzas) {
			if (piz.getCode().equals(codePizza)) {
				todelete = piz;
				pizzaDelete = true;
			}
		}

		if (!pizzaDelete) {
			throw new DeletePizzaException("la pizza n'existe pas et n'as pas pu etre supprimée");
		} else {
			this.pizzas.remove(this.pizzas.indexOf(todelete));
		}

		// for (int i = 0; i < this.pizzas.length; i++) {
		// if (this.pizzas[i] != null) {
		// if (this.pizzas[i].getCode().equals(codePizza)) {
		// this.pizzas[i] = null;
		// pizzaDelete = true;
		// }
		// }
		// if (!pizzaDelete){
		// throw new DeletePizzaException("la pizza n'existe pas et n'as pas pu
		// etre supprimée");
		// }
		// }
		return false;
	}

}
