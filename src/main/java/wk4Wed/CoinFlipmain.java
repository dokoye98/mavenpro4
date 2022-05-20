package wk4Wed;

import java.util.Random;

public class CoinFlipmain {
	
	Random rng = new Random();
	
	public String Coinflip() {
		int randNum = rng.nextInt(101);
		
		if (randNum<=49) {
			return "heads";
		}else if (randNum <=99) {
			return "tails";}
		else if (randNum ==100) {
			return "edge";}
		return null;
		}
		
	public String higherLower(int x) {
		
	int randnUM = rng.nextInt(50);
	if(randnUM < x) {
		return "higher";}
		else if (x<randnUM) {
			return "lower";}
			else {
				return "same number";
			}

	}}
