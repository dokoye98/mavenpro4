package jdbcPACK;

import org.junit.Test;
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
Bird bird1 = new Bird("white", 100,"mew" );
Bird birdid = new Bird(1, "white", 100, "mew");
@Test
public void addBirdTest() {
	Mockito.when(mockShop.addBird(null)).thenReturn(birdid);
Bird result;

result= controller.addBird(bird1);
	
}

}
