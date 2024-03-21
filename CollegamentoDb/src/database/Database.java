/**
 * 
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Order;


public class Database {
	private Connection connection;
	private Statement stmt;
	
	private String url = "jdbc:mysql://localhost:3306/experis";
	private String user = "root";
	private String psw = "Anatra";
	
	// lista con oggetti tipo Order creati tramite dati estratti dal db experis dalla tabella orders
	ArrayList<Order> ordini = new ArrayList<>();
	
	/**
	 * costruttore classe Database() in cui inizializzo:
	 * oggetto Connection connection per effettuare la connessione al db mysql
	 * oggetto Statement stmt per l'esecuzione di query e istruzioni sql
	 * 
	 * si utilizza il try catch per gestire eventuali errori di connessione
	 */
	public Database() {		
		try {
			// connessione al db mysql tramite DriverManager
			this.connection = DriverManager.getConnection(url,user,psw);
			
			// creo l'oggetto Statement che servirà per eseguire le query
			this.stmt = connection.createStatement();
			
		} catch (SQLException e) {
			System.out.println("Errore di connessione al db: " + e.getMessage());
		}
	}
	
	
	/**
	 * esegue una query sulla tabella orders del db experis
	 * 
	 * per ogni record che viene ritornato si crea un oggetto Order 
	 * ogni oggetto Order viene inserito nell'ArrayList ordini
	 * infine ciclo l'arraylist e stampo ogni oggetto sfruttando il metodo toString() sovrascritto dalla classe Order
	 */
	public void testDb() {
		try {
			// eseguo l'update di un record
			// stmt.executeUpdate("update orders set order_number = 'ORD021' where id = 22");
			
			// inserimento di un nuovo record
			// stmt.executeUpdate("insert INTO orders (order_number, today, quantity, total_price, order_status) values ('ORD0021', '2024-03-20 10:06:07', 2, 10.00, 'consegnato')");
			
			// l'oggetto ResultSet contiene le righe ritornate dalla query
			ResultSet rs = stmt.executeQuery("select id, order_number, today, quantity, total_price from orders");
			
			while(rs.next()) {
				/*
				System.out.println(rs.getInt("id") + " " + 
								   rs.getString("order_number") + " " + 
								   rs.getDate("today") + " " +
								   rs.getInt("quantity") + " " +
								   rs.getDouble("total_price"));
								   */
				Order ordine = new Order(rs.getInt("id"), rs.getString("order_number"), rs.getDate("today"), rs.getInt("quantity"), rs.getDouble("total_price"));
				
				ordini.add(ordine);
			}
			
		} catch (SQLException e) {
			System.out.println("Errore nell'esecuzione della query");
		}
		
		System.out.println("\nlista ordini:");
		
		for (Order order : ordini) {
			System.out.println("\n" + order);
		}
;	}

}