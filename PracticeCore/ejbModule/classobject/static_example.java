package classobject;

import array.firstarray;
import printf.p;

public class static_example {

	int Age;
	int Class;
	String name;
	static String sub;

	public static void main(String[] args) {

		static_example o1 = new static_example();
		o1.Age = 23;
		o1.Class = 18;
		o1.name = "s54545k";
		o1.sub = "5454545dj";
		static_example o2 = new static_example();
		o2.Age = 22;
		o2.Class = 23;
		o2.name = "dsfd";
		o2.sub = "4545435345";
		static_example o3 = new static_example();
		o3.Age = 34;
		o3.Class = 43;
		o3.name = "sk45454354";
		o3.sub = "454545";
		static_example o4 = new static_example();
		o4.Age = 56;
		o4.Class = 12;
		o4.name = "54545sk45";
		o4.sub = "4543";

		p.out(o1.Age + "  " + o1.Class + "  " + o1.name + "  " + o1.sub);
		p.out(o2.Age + "  " + o2.Class + "  " + o2.name + "  " + o2.sub);
		p.out(o3.Age + "  " + o3.Class + "  " + o3.name + "  " + o3.sub);
		p.out(o4.Age + "  " + o4.Class + "  " + o4.name + "  " + o4.sub);

	}

}
