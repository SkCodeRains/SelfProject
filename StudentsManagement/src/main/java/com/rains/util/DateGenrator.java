package com.rains.util;

public class DateGenrator {
	public static String generate(String date) {
		String[] parts = date.split("-");
		return parts[2] + "-" + parts[1] + "-" + parts[0];

	}
}
