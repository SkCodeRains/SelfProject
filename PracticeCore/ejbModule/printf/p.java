package printf;

public class p {
	public static void out(String a) {
		System.out.println(a);

	}

	public static void out(char ch) {
		System.out.println(ch);

	}

	public static void out(int a) {
		System.out.println(a);

	}

	public static void out(String[][] a) {
		System.out.println(a);
	}

	public static void out(int[] a) {
		for (int x : a) {
			System.out.println(x);
		}

	}

	public static void out(String[][][] a3) {
		for (String[][] strings : a3) {
			for (String[] strings2 : strings) {
				for (String strin : strings2) {
					out(strin);
				}

			}
		}
	}

	public static String sizeOf(String[][][] a3) {
		int i = 0;
		for (String[][] strings : a3) {
			i++;
			for (String[] strings2 : strings) {
				i++;
				for (String strin : strings2) {
					i++;

				}

			}
		}
		return "size of array  :  " + i;

	}

	public static String sizeOf(int[][][] a4) {
		int i = 0;
		for (int[][] strings : a4) {
			i++;
			for (int[] strings2 : strings) {
				i++;
				for (int strin : strings2) {
					strin = 0;
					i++;

				}

			}
		}
		return "size of array  :  " + i;
	}

	public static void out(double db) {
		System.out.println(db);

	}

	public static void out(boolean b) {
		System.out.println(b);

	}

}
