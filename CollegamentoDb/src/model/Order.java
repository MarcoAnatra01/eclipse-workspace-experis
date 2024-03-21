package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;

import database.Database;


public class Order extends Database{
	
	private int id;
	private String orderNumber;
	private Date today;
	private int quantity;
	private double totalPrice;
	
	// definizione enum
	public enum orderStatus {
		consegnato, attesa, spedito
	};
	
	// campo che memorizza lo stato dell'ordine
	private orderStatus status;
	
	public Scanner scanNum = new Scanner(System.in);
	public Scanner scanString = new Scanner(System.in);
	public Scanner scanDate = new Scanner(System.in);
	
	public Order(int id, String orderNumber, Date today, int quantity, double totalPrice, orderStatus status) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.today = today;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.status = status;
	}
	
	public Order() {} // costruttore vuoto
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}


	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getToday() {
		return today;
	}
	
	public void setToday(Date today) {
		this.today = today;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public orderStatus getStatus() {
		return status;
	}

	public void setStatus(orderStatus status) {
		this.status = status;
	}

	
	
	public void printColumnOrder() throws SQLException{
		System.out.println("\nnomi colonne tabella orders:");
		ResultSet rs = stmt.executeQuery("select column_name from information_schema.columns where table_schema = 'experis' and table_name = 'orders'");
		
		while(rs.next()) {
			String columnName = rs.getString("column_name");
	        System.out.println(columnName);
		}
	}


	
	public void updateOrder() throws SQLException{
		System.out.println("\n");
		System.out.println("\nORDER UPDATE");
		
		System.out.println("\ninserisci l'id dell'ordine da modificare:");
		int idUpdate = scanNum.nextInt();
		
		System.out.println("\ninserisci il nome della colonna:");
		String columnName = scanString.nextLine();
		
		System.out.println("\ninserisci il valore:");
		String valore = scanString.nextLine();
		
		String queryUpdate = "UPDATE orders SET " + columnName + " = ? WHERE id = ?";
		
		PreparedStatement pstmt = connection.prepareStatement(queryUpdate);
		pstmt.setString(1, valore);
		pstmt.setInt(2, idUpdate);
		pstmt.executeUpdate();
		System.out.println("\nordine modificato con successo");
	}
	
	public void deleteOrder() {
		
	}
	

	@Override
	public String toString() {
		return "id: " + id + "\n" + "order number: " + orderNumber + "\ndata: " + today + "\nquantity: " + quantity + "\ntotal price: " + totalPrice + "\norder status: " + status; 
	}
}
