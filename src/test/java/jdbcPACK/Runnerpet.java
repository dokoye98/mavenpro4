package jdbcPACK;

public class Runnerpet {
public static void main(String[] arg) {
	DBconfig db = new DBconfig();
	
	PetShop paws = new PetShop();
	paws.addBird(new Bird("Green",9,"nico"));
}
}
