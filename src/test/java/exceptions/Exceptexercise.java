package exceptions;

public class Exceptexercise {
	
	public int dividenums(int x, int y) {
		try{int result = x/y;
				return result;
				
				if (y==10) {
					throw new DivideTenException("divide 10 exception");
				}
	}catch(ArithmeticException e) {
		e.printStackTrace();}
		catch(DivideTenException e) {
			e.printStackTrace();
		}
	finally {System.out.println("we will always run");
return 0;
		return y;

}
}
