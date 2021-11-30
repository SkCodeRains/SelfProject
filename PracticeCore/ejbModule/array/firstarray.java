package array;

import printf.p;

public class firstarray {

	strictfp synchronized final public static void main(String[] sk) {
		int[] a = new int[20];

		for (int i = 0; i < a.length; i++) {
			a[i] = i;
			System.out.println(a[i]);
		}

		int[] test = { 10, 20, 30, 40, 50, 60 };
		int[] test1 = { 10, 20, 30, 40 };

		// test = test1;
		test1 = test;

		for (int i : test1) {
			p.out(i);
		}
		p.out("thinssssss new \n");
		p.out(a);

	}

}
