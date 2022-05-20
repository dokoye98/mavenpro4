package jdbcPACK;

public class PetController {

	private PetShop petShop;

	public PetController(PetShop petShop) {
		super();
		this.petShop = petShop;
	}
	
	
	//add a bird
	public Bird addBird(Bird bird) {
		Bird addedBird = petShop.addBird(bird);
		return addedBird;
	}
	
	
	//get bird by id
	
	public Bird readBirdById(int id) {
		Bird bird=petShop.getBirdById(id);
		return bird;
	}
	//delete bird
	public boolean delBird(int id) {
		boolean deleted = petShop.deleteBird(id);
		return deleted;
	}
	//update bird
	public Bird updateBird(int id, Bird bird) {
		Bird updatebird =petShop.updateBird(id,bird);
		 System.out.println(bird.getName()+" has been updated!");
		 return updatebird;
	}
}
