package jdbcPACK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import wk4Wed.Drink;

public class Cafe { 
	JDBCMain db = new JDBCMain();
	Connection conn=null;
	Statement  stmt=null;

public void addDrink (Drink drink) {
	try {
		conn= db.connect();
        stmt=conn.createStatement();
       String queryOld = "INSERT INTO drink(type, size, dairyFree, cost) VALUES('latte', 'grande', false, 3.32);";
        String query =    "INSERT INTO drink(type, size, dairyFree, cost) VALUES('"+ drink.getType() + "', '"+ drink.getSize() +"', " + drink.isDairyFree()+ ", "+ drink.getCost()+");";
        System.out.println(query);
        System.out.println("all connected");
        stmt.executeUpdate(query); // pass in our SQL query into stmt.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
  
       

    	}

    	
    	

//public Drink getDrinkById(int id) {
	//try {

		conn = db.connect();
		stmt = conn.createStatement();
	//	String query = "SELECT * FROM drinks WHERE id = " + id;
		// return an object of type ResultSet - A set of data from the database
		//ResultSet results = stmt.executeQuery(query); 
		results.next(); // moves the selection cursor down to the next row
//		System.out.println(results); // We need to convert to a useful object
		//Drink drinkResult = modelDrink(results);
		//return drinkResult;

	} 
public ArrayList<Drink> getDrinksByQuery(String query,String value){
	ArrayList<Drink> resultList = new ArrayList<>();
	try {
		conn = db.connect();
		stmt = conn.createStatement();
		String query1 = "SELECT ";
	}
	
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
}
public Drink updateDrinkById(Drink drink ,int id) {
	try {
		conn =db.connect();
		String query = "UPDATE drink SET type =?, size =?,dairyFree =?,cost=? ";
	PreparedStatement preStmt = conn.prepareStatement(query);
		preStmt.setString(1,drink.getType());
	preStmt.setString(2,drink.getSize());
	preStmt.setboolean(3,drink.getisDairyFree());
	preStmt.setFloat(4, drink.getCost());
	preStmt.setInt(5, id);
	preStmt.executeUpdate();
	return getDrinkById(id);
	}catch (Exception e) {
		e.printStackTrace();
		return null;}}
	
	
}}
}






