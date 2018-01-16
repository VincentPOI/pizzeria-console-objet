package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class IPizzaDaoJDBC implements IPizzaDao {


	EntityManagerFactory entityManagerFact = Persistence.createEntityManagerFactory("pu_pizza");
	EntityManager em = entityManagerFact.createEntityManager();

	public IPizzaDaoJDBC() {

	}

	public List<Pizza> findAllPizzas() {

		List<Pizza> pizzas = new ArrayList<Pizza>();

		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
		for (Pizza p : query.getResultList()) {
			pizzas.add(p);
		}

		return pizzas;
	}

	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		EntityTransaction transaction = em.getTransaction();
		em.persist(pizza);
		transaction.commit();
		return true;
	}

	public boolean updatePizza(String codePizza, Pizza pizza) {

		TypedQuery<Pizza> query = em.createQuery("from Pizza WHERE code=:target", Pizza.class);
		query.setParameter("target", codePizza);
		Pizza p = query.getSingleResult();
		if (p != null) {
			EntityTransaction transaction = em.getTransaction();
			p.setCode(pizza.getCode());
			p.setNom(pizza.getNom());
			p.setPrix(pizza.getPrix());
			p.setCate(pizza.getCate());
			transaction.commit();
			return true;
		}
		return false;
	}

	public boolean deletePizza(String codePizza)  {

		TypedQuery<Pizza> query = em.createQuery("from Pizza where code=:target",Pizza.class);
		query.setParameter("target", codePizza);
		Pizza p = query.getSingleResult();
		if (p != null) {
			EntityTransaction transaction = em.getTransaction();
			em.remove(p);
			transaction.commit();
			return true;
		}
		return false;
	}

	public void closeConn() {
		em.close();
		entityManagerFact.close();
	}

}
