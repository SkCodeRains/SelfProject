package com.myEJBs;

import javax.ejb.Local;

@Local
public interface calculatorLocal {
	public double calcDiscount(double amount);

}
