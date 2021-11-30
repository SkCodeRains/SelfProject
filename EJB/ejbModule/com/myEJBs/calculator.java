package com.myEJBs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class calculator
 */
@Stateless(mappedName = "cal")
@LocalBean
public class calculator implements calculatorLocal {

	/**
	 * Default constructor.
	 */
	public calculator() {

	}

	public double calcDiscount(double amount) {
		double discount = 0.0;
		if (amount > 20000) {
			discount = amount * 13 / 100;
		} else {
			discount = amount * 9 / 100;
		}

		return discount;
	}

}
