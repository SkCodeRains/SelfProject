package beans;

public class encID {
	public static String encrypt(String id) {
		char[] ID;
		String str = "";
		ID = id.toCharArray();
		for (char c : ID) {
			str += String.valueOf(c += 69);
		}
		return str;
	}

	public static String decrypt(String id) {
		char[] ID;
		String str = "";
		ID = id.toCharArray();
		for (char c : ID) {
			str += String.valueOf(c -= 69);
		}
		return str;
	}
	public static void main(String[] args) {
		System.out.println(encrypt(String.valueOf("1245")));
		System.out.println(decrypt(String.valueOf(encrypt(String.valueOf("1245")))));
	}
}
