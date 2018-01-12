package fr.pizzeria.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class IPizzaDaoJDBC implements IPizzaDao {

	String driver = "";
	String url = "";
	String user = "";
	String password = "";
	public Connection conn = null;
	

	public IPizzaDaoJDBC() throws ClassNotFoundException, SQLException {
		driver = ResourceBundle.getBundle("jdbc").getString("driver");
		url = ResourceBundle.getBundle("jdbc").getString("url");
		user = ResourceBundle.getBundle("jdbc").getString("user");
		password = ResourceBundle.getBundle("jdbc").getString("password");
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
	}
	

	public List<Pizza> findAllPizzas() {

		List<Pizza> pizzas = new ArrayList<Pizza>();
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet resultats = statement.executeQuery("SELECT * FROM pizza");
			while (resultats.next()) {
				String code = resultats.getString("Code");
				String name = resultats.getString("Name");
				double price = resultats.getDouble("Price");
				CategoriePizza cate = CategoriePizza.valueOf(resultats.getString("Category").toUpperCase());
				Pizza pizza = new Pizza(code, name, price, cate);
				pizzas.add(pizza);			
			}
			resultats.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pizzas;
	}

	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		PreparedStatement savePizza;
		try {
			savePizza = conn.prepareStatement("INSERT INTO pizza VALUES (?,?,?,?)");
			savePizza.setString(1, pizza.getCode());
			savePizza.setString(2, pizza.getNom());
			savePizza.setDouble(3, pizza.getPrix());
			savePizza.setString(4, pizza.getCate().toString());
			savePizza.executeUpdate();
			savePizza.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
		PreparedStatement updtPizza;
		try {
			updtPizza = conn.prepareStatement("UPDATE pizza SET Code=?, Name=?, Price=?, Category=? WHERE Code=?");
			updtPizza.setString(1, pizza.getCode());
			updtPizza.setString(2, pizza.getNom());
			updtPizza.setDouble(3, pizza.getPrix());
			updtPizza.setString(4, pizza.getCate().toString());
			updtPizza.setString(5,codePizza);
			updtPizza.executeUpdate();
			updtPizza.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean deletePizza(String codePizza) throws DeletePizzaException {	
		PreparedStatement dltPizza;
		try {
			dltPizza = conn.prepareStatement("DELETE FROM pizza WHERE code=?");
			dltPizza.setString(1, codePizza);
			dltPizza.executeUpdate();
			dltPizza.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	

	// Statement statement = conn.createStatement();
	// int nbPizzaInsere = statement.executeUpdate("INSERT INTO pizza
	// VALUES('PEP', 'Pépéroni', 12.50, 'VIANDE'),('MAR', 'Margherita', 14.00,
	// 'SANS_VIANDE'),('REIN', 'La Reine', 11.50, 'VIANDE'),('FRO', 'Les 4
	// fromages', 12.00,'SANS_VIANDE'),('CAN', 'La cannibale',
	// 12.50,'VIANDE'),('SAV', 'La savoyarde', 13.00,'VIANDE'),('ORI',
	// 'L''Orientale', 13.50,'VIANDE'),('IND', 'L''indienne', 14.00,'VIANDE')");
	// System.out.println();
	// statement.close();

}
