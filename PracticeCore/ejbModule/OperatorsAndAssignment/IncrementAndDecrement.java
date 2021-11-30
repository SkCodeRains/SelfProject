package OperatorsAndAssignment;

import printf.p;

public class IncrementAndDecrement {
	public static void main(String[] args) {
		// Integer increment
		int x = 10;
		x++;
		p.out(x);
		// character INcremennt
		char ch = 'c';
		ch++;
		ch = (char) (ch + ch);
		System.out.println('a' + 'b');
		p.out(ch);

		double db = 10.54;
		db++;
		p.out(db);

		boolean b = false;
		// b++; error
		p.out(b);

		byte a = 20;
		a++;
		a = (byte) (a + 1);

		// bytee=bytee+1; Type mismatch: cannot convert from int to byte
		// a=a+a; Type mismatch: cannot convert from int to byte
		a = (byte) (++a + a++);
		p.out(a);

		p.out(10 / 0.0);

		

	}
}
