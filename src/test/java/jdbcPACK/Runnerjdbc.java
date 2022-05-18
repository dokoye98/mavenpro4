package jdbcPACK;

import wk4Wed.Drink;

public class Runnerjdbc {
public static void main(String[] arg) {
	JDBCMain jdbc = new JDBCMain();
	//jdbc.connect();
//create cafe object
	Cafe newcafe = new Cafe();
	Drink latte = new Drink("latte", "Grande", false, 2.53f);
Cafe newCafe = new Cafe();
newCafe .addDrink(latte);
newCafe.addDrink(new Drink( "coke", "large", true, 2.05f));
}
}
