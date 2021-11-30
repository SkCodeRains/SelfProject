package assingment;

import java.util.Scanner;

public class EmpDetails {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")
			String empName = null, designation = null, id = null;
			double salary = 0;
			int i = 0;
			while (i <= 4) {
				switch (i) {
				case 0:
					System.out.print("\nPlease Enter Employee Name                         :   ");
					empName = getData();
					i++;
					break;
				case 1:
					System.out.print("\nPlease Enter your Designation                      :   ");
					designation = getData();
					if (designation.equalsIgnoreCase("back")) {
						i = 0;
					} else if (validation(designation)) {
						i++;
					} else {
						System.out.print("\nplease provide valid Designation\n");
					}
					break;
				case 2:
					System.out.print("\nPlease Enter your ID                               :   ");
					String temp = getData();
					if (validate(temp) && !"back".equalsIgnoreCase(temp)) {
						i++;
						id = temp;
					} else if ("back".equalsIgnoreCase(temp)) {
						i = 1;
					} else {
						System.out.print("\nplease provide valid ID \n");
					}
					break;
				case 3:
					System.out.print("\nPlease Enter your Salary                           :   ");
					temp = getData();
					if (temp.equalsIgnoreCase("back")) {
						i = 2;
					} else if (validation(salary = Double.parseDouble(temp))) {
						i++;
					} else {
						System.out.print("\nplease provide valid Designation");
					}
					break;
				case 4:
					System.out.print(
							"\n=================================================================\nEMPLOYEE NAME IS                                  :   "
									+ empName);
					System.out.print("\nEMPLOYEE DESIGNATION IS                           :   " + designation);
					System.out.print("\nEMPLOYEE ID IS                                    :   " + id);
					System.out.print("\nEMPLOYEE BASIC SALARY IS                          :   " + salary);
					System.out.print("\nEMPLOYEE TATOL SALARY IS                          :   " + totalsal(salary));
					i++;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static boolean validate(String temp) {
		if (temp.length() == 4) {
			char[] ch = temp.toCharArray();
			for (char c : ch) {
				if (Character.isDigit(c)) {
					return true;
				}
			}
		}
		return false;
	}

	private static double totalsal(double salary) {
		return salary + (salary / 100) * 93 + (salary / 100) * 63;
	}

	private static boolean validation(double salary) {
		if (salary > 4999)
			return true;
		return false;
	}

	private static boolean validation(String designation) {
		if (designation.equalsIgnoreCase("ME") || designation.equalsIgnoreCase("TE")
				|| designation.equalsIgnoreCase("SE"))
			return true;
		return false;
	}

	private static String getData() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int i = 0;
		String data = null;
		while (i == 0) {
			data = sc.nextLine();
			if (data.equals("")) {
				System.out.println("Please provide your data                           :   ");
			} else {
				i++;
			}
		}
		return data;
	}
}