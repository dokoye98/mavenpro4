package jdbcPACK;

public class Runnerpet {
public static void main(String[] arg) {
	DBconfig db = new DBconfig();
	
	PetShop paws = new PetShop();
	PetController control = new PetController(paws);
	//control.delBird(1);
	//control.delBird(3);
	//control.addBird(new Bird("silver",22,"athena"));
	System.out.println(control.readBirdById(5));
	
	System.out.println(new Bird("black",27,"hades").makeNoise());;
}
}
