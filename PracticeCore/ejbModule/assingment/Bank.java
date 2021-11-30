package assingment;

import java.util.Scanner;

class CheckPinNo {
	int verify(int pin) {
		if (pin == 1111 || pin == 2222 || pin == 3333) {
			return pin;
		}
		return 0;

	}
}

class Withdraw {
	protected void wDraw(int d) {
		if (d > 0 && d % 100 == 0 && d < 2001) {
			System.out.println("\n+----------------------+----------------------+----------------------+"
					+ "\n|   Amount WithDrawn   |        Balance       |      Transaction     |"
					+ "\n+----------------------+----------------------+----------------------+" + "\n|     " + d
					+ "                        " + (2000 - d) + "             Completed     "
					+ "\n+----------------------+----------------------+----------------------+");

		} else {
			System.out.println("============================Amount Cant Be deducted============================");
		}

	}

}

class Deposit {
	protected void deposit(int d) {
		if (d > 0) {
			System.out.println("\n+----------------------+----------------------+----------------------+"
					+ "\n|   Amount WithDrawn   |        Balance       |      Transaction     |"
					+ "\n+----------------------+----------------------+----------------------+" + "\n|     " + d
					+ "                        " + (2000 + d) + "             Completed     "
					+ "\n+----------------------+----------------------+----------------------+");
		}

	}
}

public class Bank {// Main Class]

	public static String getdata() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public static void main(String[] args) {
		verify(0);
		amountProcess(getChoice());
	}

	private static void amountProcess(String type) {
		System.out.print("Enter Amount                                     : ");
		if (type.equals("withdraw")) {
			Withdraw wh = new Withdraw();
			wh.wDraw(Integer.parseInt(getdata()));
		} else {
			Deposit wh = new Deposit();
			wh.deposit(Integer.parseInt(getdata()));
		}
	}

	private static String getChoice() {
		System.out.print("     1. Deposit\n     2. WithDraw \nEnter Choice                                     : ");
		int ch = Integer.parseInt(getdata());
		if (ch == 1) {
			return "deposit";
		} else if (ch == 2) {
			return "withdraw";
		} else {
			System.out.print("\n \n           ====Transaction Block Retry==== ");
			System.exit(0);
		}
		return null;
	}

	private static int verify(int i) {
		if (i >= 3) {
			System.out.print("\n \n           ====Transaction Block==== ");
			System.exit(0);
		}
		System.out.print("\nPlease Enter Your Pin                            : ");
		int pin = Integer.parseInt(getdata());
		CheckPinNo ch = new CheckPinNo();
		if (ch.verify(pin) > 0)
			return pin;

		return verify(++i);
	}

}