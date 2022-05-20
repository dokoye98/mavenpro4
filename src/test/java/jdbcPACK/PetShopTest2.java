package jdbcPACK;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PetShopTest2 {
PetShop shop = new PetShop();
DBconfig db = new DBconfig();
Connection conn = db.connect();
Bird bird =new Bird("test colour", 1, "test name");
Bird birdid = new Bird(1,"test colour",1,"test name");
Bird bird2id = new Bird(2, "prac colour", 4, "prac name");
@BeforeEach
public void Setup() {
	try {
		String query ="TRUNCATE table Bird;\r\n" + "INSERT INTO Bird(feather_colour,wingspan,name) values(\"test_colour\",1,\"test_name\");";
		PreparedStatement prestmt =conn.prepareStatement(query);
		prestsmt.excuteUpdate();
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	
}
@Test
public void addBirdTest() {
	Bird result;
	result =shop.addBird(bird2id);
	Assertions.assertEquals(bird2id, result);
}
}
