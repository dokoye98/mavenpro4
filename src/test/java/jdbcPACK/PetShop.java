package jdbcPACK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class PetShop {

	
	
	DBconfig db = new DBconfig();
	Statement stmt = null; 
	Connection conn = db.connect();
	
	//Add bird to petshop 
	//return bird added to database
	public Bird addBird(Bird bird) {
		try {
			String query = "INSERT INTO Bird(feather_colour,wingspan,name) values(?,?,?)"; 
			PreparedStatement prestmt =conn.prepareStatement(query);
			prestmt.setString(1,bird.getFeatherColour());
			prestmt.setInt(2, bird.getWingspan());
			prestmt.setString(3,bird.getName());
			prestmt.executeUpdate();//used to change data 
			return readLatest();
		}catch (Exception e) {
			//exception = error in  the code 
			// when there is an error it is caught 
		}
		return null;
		
	}
	
	//new method to see id of latest bird added 
	public Bird readLatest() {
		try {
			String query = "SELECT * FROM Bird ORDER BY id DESC LIMIT 1;";
			PreparedStatement prestmt =conn.prepareStatement(query);
			ResultSet results =prestmt.executeQuery();
			return modelBird(results);
	}catch(Exception e) {
		e.printStackTrace();
		return null;
	}}
	
	
public Bird getBirdById(int id) {
	try {
		String query = "SELECT * FROM Bird where id =?";
		PreparedStatement prestmt =conn.prepareStatement(query);
		prestmt.setInt(1, id);
		ResultSet results =prestmt.executeQuery();
		return modelBird(results);
	}catch(Exception e) {
		e.printStackTrace();
	return null;
	}
	
}


public boolean deleteBird(int id) {
	try {
		String query = "DELETE FROM Bird WHERE id =?;";
		PreparedStatement prestmt =conn.prepareStatement(query);
		prestmt.setInt(1, id);
		prestmt.executeUpdate();
		return true;
	}catch(Exception e) {
		return false;
	}
}
public Bird updateBird(int id , Bird bird) {
	try {
		String query ="UPDATE Bird set feather_colour =?, winspan =?, name =? WHERE id =?; ";
				PreparedStatement prestmt =conn.prepareStatement(query);
				prestmt.setString(1,bird.getFeatherColour());
		prestmt.setInt(2, bird.getWingspan());
		prestmt.setString(3,bird.getName());
		prestmt.executeUpdate();
		
	return getBirdById(id);
	}catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}

public String birdNoiseById(int id) {
	try {Bird bird = getBirdById(id);
	return bird.makeNoise();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return null;
}

public Bird modelBird(ResultSet result) {
	try {
		
		result.next();
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
