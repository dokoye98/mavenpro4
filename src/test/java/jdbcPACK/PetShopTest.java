package jdbcPACK;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

//ExtendWith (MockitoExtention.class) 
public class PetShopTest {

	
//@Mock
private Bird mockBird;
//@Mock
private PetShop mockShop;
//@InjectMocks
private PetShop petShop;

Bird birdid = new Bird(1, "test colour", 10, "test name");
Bird birdie = new Bird( "test colour", 10, "test name");




public void birdNoidByIdTest() {
	//Mockito.when(mockBird.makeNoise()).thenReturn("test String");
	//Mokcito.when(mockShop.getBirdById(1)).thenReturn(birdid);
String result;


result =petShop.birdNoiseById(1);

}
}
