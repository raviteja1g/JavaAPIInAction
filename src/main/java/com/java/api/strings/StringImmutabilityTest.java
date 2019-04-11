package com.java.api.strings;

import org.junit.jupiter.api.Test;

public class StringImmutabilityTest {

	private String apiURL;

	private String[] acceptedURLs = { "url1", "url2", "url3" };

	public boolean addAPIUrlIfValid(String url) {
		for (String acceptedURL : acceptedURLs) {
			if (url.equals(acceptedURL)) {
				this.apiURL = url;
				return true;
			}
		}
		return false;
	}

	@Test
	public void testStringImmutability() {
		StringImmutabilityTest testRun = new StringImmutabilityTest();

		String testURL = "url3";
		testRun.addAPIUrlIfValid(testURL);

		testURL = "HackersURL";

		// If in case Strings are not made immutable, then above update of URL should
		// also update apiURL used in above class which would be serious security
		// problem

		System.out.println("Here is the value of apiURL: " + testRun.apiURL);

		// Since Strings are immutable, apiURL did not get updated to HackersURL, as
		// testURL now has total new copy of String
	}
}
