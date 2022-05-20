package jdbcPACK;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

	@Mock
	private PetShop mockShop;

	@InjectMocks
	private PetController controller;

//TestDB should be used so actual db isnt affected
//easy way is make copy db 
	Bird bird1 = new Bird("white", 100, "mew");
	Bird birdid = new Bird(1, "white", 100, "mew");

	@Test
	public void addBirdTest() {
		Mockito.when(mockShop.addBird(bird1)).thenReturn(birdid);
		Bird result;

		result = controller.addBird(bird1);
		Assertions.assertEquals(birdid, result);
	

	
		Mockito.verify(mockShop, Mockito.times(1)).addBird(bird1);
	}

	@Test
	public void readByIdTest() {

		// Arrange
		Mockito.when(mockShop.getBirdById(1)).thenReturn(birdid);
		Bird result;
		// act
		result = controller.readBirdById(1);
		// assert
		Assertions.assertEquals(birdid, result);
	}

	@Test
	public void deleteBirdTest() {
		Mockito.when(mockShop.deleteBird(1)).thenReturn(true);
	boolean result;
		result = controller.deleteBird(1);
		Assertions.assertTrue(result);
	}
	
	@Test
	public void updateBirdTest() {
		Mockito.when(mockShop.updateBird(1, bird1)).thenReturn(birdid);
		Bird result;
		result = controller.updateBird(1, bird1);
		Assertions.assertEquals(birdid, result);
		
	}
}
