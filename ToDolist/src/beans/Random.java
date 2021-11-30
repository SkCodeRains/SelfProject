package beans;

public class Random {
	public static int getID() {
		String randomPIN = String.valueOf((Math.random() * 9000) + 1000);
		randomPIN = randomPIN.substring(0,4);
		return Integer.parseInt(randomPIN);
	}
	
}
