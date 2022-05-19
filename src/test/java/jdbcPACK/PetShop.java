package jdbcPACK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

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
public Bird getBirdById(int id) {
	try {
		String query = "SELECT * FROM Bird where id =?";
		PreparedStatement prestmt =conn.prepareStatement(query);
		prestmt.setInt(1, id);
		Resultset results =prestmt.executeQuery();
	}catch(Exception e) {
		e.printStackTrace();
	}
}
public Bird modelBird(Resultset result) {
	try {
		int id = result.getInt("id");
		String featherColour = result.getString("feather_colour");
		int wingspan =result.getInt("wingspan");
		String name=result.getString("name");
		
		
		// make bird object and return
		Bird bird = new Bird(id, featherColour, wingspan, name);
		return bird;
	}catch(Exception e) {
		e.printStackTrace();
		return null;
	}
}
}
