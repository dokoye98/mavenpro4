package jdbcPACK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import wk4Wed.Drink;

public class Cafe { 
	JDBCMain db = new JDBCMain();
	Connection conn=db.connect();
	Statement  stmt=null;

public void addDrink (Drink drink) {
	try {
		conn= db.connect();
        stmt=conn.createStatement();
       String query = "INSERT INTO drink(type, size, dairyFree, cost) VALUES(?,?,?);";
         System.out.println(query);
         PreparedStatement prestmt =conn.prepareStatement(query);
         prestmt.setString(1,drink.getType());
         prestmt.setString(2, drink.getSize());
         prestmt.setBoolean(3, drink.isDairyFree());
         prestmt.setFloat(4,drink.getCost());
         prestmt.executeUpdate();
        System.out.println("all connected");
        stmt.executeUpdate(query); // pass in our SQL query into stmt.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();}
  
       

    	}

    	
    	

public Drink getDrinkById(int id) {
	try {
		String query = "SELECT * FROM drink WHERE id =?;";
		PreparedStatement prestmt =conn.prepareStatement(query);
prestmt.setInt(1, id);
ResultSet results = prestmt.executeQuery();

	}catch(Exception e) {
	e.printStackTrace();
}
	return null;
		
	
	 

	
	
}

public int deleteorder(int id) {
	try {
		conn=db.connect();
		String query = "DELETE FROM drink WHERE id = ?;";
		PreparedStatement preStmt = conn.prepareStatement(query);
	preStmt.setInt(1, id);
	return preStmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}
	return 0;
}}

//public Drink updateDrinkById(Drink drink ,int id) {
	//try {
		//conn =db.connect();
		//String query = "UPDATE drink SET type =?, size =?,dairyFree =?,cost=? ";
//	PreparedStatement preStmt = conn.prepareStatement(query);
	//	preStmt.setString(1,drink.getType());
	//preStmt.setString(2,drink.getSize());
	//preStmt.setBoolean(3,drink.isDairyFree());
	//preStmt.setFloat(4, drink.getCost());
	//preStmt.setInt(5, id);
	//preStmt.executeUpdate();
	//return getDrinkById(id);
//	}catch (Exception e) {
	//	e.printStackTrace();
		//return null;}}
	
	








