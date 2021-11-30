package OperatorsAndAssignment;

import printf.p;

public class greterLessEqulOrNot {

	public static void main(String[] args) {
		p.out("Greater than and Less Than \n");
		p.out(10 > 1);
		p.out(10 > 1.1);
		p.out(10 < 'a');
		p.out('a' > 'A');

		p.out("\nObject And == Operator \n");
		p i = new p();
		p k = new p();
		p.out(i == k);

		Thread t1 = new Thread();
		Thread t2 = new Thread();
		Object t3 = t1;
		String s = new String();
		p.out(t1 == t2);
		p.out(t1 == t3);
		p.out(s == t3);
		p.out(true == false);
		// p.out(s == t1);

		p.out("\nequel() Function \n");
		p.out(s);
		s = "shaaikh";
		String s2 = "shaikh";

		s2 = "";

		p.out(s == null);

	}

}
