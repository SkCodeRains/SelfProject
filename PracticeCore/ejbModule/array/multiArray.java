package array;

import printf.p;

public class multiArray {

	public static void main(String[] args) {

		int totalLength = 0;
		// array of arrays
		String[][] a = new String[2][];
		a[0] = new String[1];
		a[1] = new String[5];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = "Shaikh    " + i + "    " + j;
				p.out(a[i][j]);
			}
		}

		// arrays of arrays of array
		String[][][] a2 = new String[2][][];
		a2[0] = new String[2][];
		a2[1] = new String[3][];
		a2[0][0] = new String[2];
		a2[0][1] = new String[3];
		a2[1][0] = new String[3];
		a2[1][1] = new String[4];
		a2[1][2] = new String[5];

		for (int i = 0; i < a2.length; i++) {
			for (int j = 0; j < a2[i].length; j++) {
				for (int j2 = 0; j2 < a2[i][j].length; j2++) {
					a2[i][j][j2] = "Shaikh    " + i + "    " + j + "    " + j2;
					p.out(a2[i][j][j2]);
				}

			}

		}
		p.out("wewewew \n\n");
		String[][][] a3 = { { { "shaikh", "mohammed" }, { "mohammed", "abdullah", "shaikh" } },
				{ { "bca", "2020", "62" },
						{ "amravati", "UG", "sant gadge baba university", "l.baban rao dekhmikh colloge" },
						{ "chaman shahwali", "amravati", "maharashtra", "india", "asia" } } };
		p.out(a3);
		p.out("end end \n\n");

		int[][][] a4 = { { { 10, 20, 30, 40 }, { 50, 60 } }, { { 70, 80, 90 }, { 100, 45, 11, 12 }

				} };
		for (int i = 0; i < a4.length; i++) {
			for (int j = 0; j < a4[i].length; j++) {
				for (int j2 = 0; j2 < a4[i][j].length; j2++) {
					p.out(a4[i][j][j2]);
					totalLength++;
				}

			}

		}
		p.out("the size of a4 total array is : " + totalLength);

		p.out(p.sizeOf(a4));

	}

}
