package com.java.api.strings;

public class StringMethodsTest {
	
	public static void main(String[] args) {
		String review = "food was Great and Good";
		
		String pattern = "food was ";
		
		System.out.println("Here is the opinion on pattern: " + review.substring(review.indexOf(pattern) + pattern.length(), review.indexOf(" ", review.indexOf(pattern) + pattern.length())));

	}

}
