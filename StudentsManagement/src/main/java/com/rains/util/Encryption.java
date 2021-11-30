package com.rains.util;

public class Encryption {
	public static String encrypt(String data) {
		String enc = "";
		for (char ch : data.toCharArray()) {
			enc += (char) (ch + 7);
		}
		return enc;
	}

	public static String decrypt(String data) {
		String enc = "";
		for (char ch : data.toCharArray()) {
			enc += (char) (ch - 7);
		}
		return enc;
	}

}
