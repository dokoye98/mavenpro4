package jdbcPACK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PetShop {

	
	
	DBconfig db = new DBconfig();
	Statement stmt = null; 
	Connection conn = db.connect();
	
	//Add bird to petshop 
	public boolean addBird(Bird bird) {
		try {
			String query = "INSERT INTO Bird(feather_colour,wingspan,name) values(?,?,?)"; 
			PreparedStatement prestmt =conn.prepareStatement(query);
			prestmt.setString(1,bird.getFeatherColour());
			prestmt.setInt(2, bird.getWingspan());
			prestmt.setString(3,bird.getName());
			prestmt.executeUpdate();//used to change data 
			return true;
		}catch (Exception e) {
			//exception = error in  the code 
			// when there is an error it is caught 
		}
		return false;
		
	}
}
