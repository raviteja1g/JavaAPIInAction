package com.java.api.usecases;

import java.util.Arrays;

/** 
 * 
 * Problem was taken from Dheeru Mundluru Java In-Depth Course
 * 
 * https://www.udemy.com/java-in-depth-become-a-complete-java-engineer/learn/quiz/276020#content
 *
 */
public class SentimentAnalyzer {
    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
	public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
			String[] negOpinionWords) {
		int[] featureOpinions = new int[featureSet.length]; // output
		
		review = review.toLowerCase();
		
		for (int i = 0; i < featureSet.length; i++) {
			for (int j = 0; j < featureSet[i].length; j++) {
				// your code ~ you will be invoking getOpinionOnFeature		
				featureOpinions[i] = (featureOpinions[i]!=1 || featureOpinions[i]!= -1) ? getOpinionOnFeature(review , featureSet[i][j], posOpinionWords, negOpinionWords) : 0;
			}
		}
		return featureOpinions;
	}

	// First invoke checkForWasPhrasePattern and 
	// if it cannot find an opinion only then invoke checkForOpinionFirstPattern
	private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
		
		int pattern = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
		
		if(pattern==0)
			pattern = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
		
		return pattern;
	}	

	// Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
	// Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
	// You can first look for positive opinion. If not found, only then you can look for negative opinion
	private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
		int opinion = 0;
		String pattern = feature + " was ";
		
		if(review.contains(pattern))
		{
			String opinionWord = review.substring(review.indexOf(pattern) + pattern.length(), review.indexOf(" ", review.indexOf(pattern) + pattern.length()));
			
			opinion = Arrays.asList(posOpinionWords).contains(opinionWord) ? 1: 0;
			
			if(opinion != 1)
			opinion = Arrays.asList(negOpinionWords).contains(opinionWord) ? -1: 0;
			
		} else {
			return 0;
		}

		return opinion; 	
	}
	
	// You can first look for positive opinion. If not found, only then you can look for negative opinion
	private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,
			String[] negOpinionWords) {
		// Extract sentences as feature might appear multiple times. 
		// split() takes a regular expression and "." is a special character 
		// for regular expression. So, escape it to make it work!!
		String[] sentences = review.split("\\.");
		int opinion = 0;
		
		// your code for processing each sentence. You can return if opinion is found in a sentence (no need to process subsequent ones)		
		
		for (String reviewLine : sentences) {
			for (String posOpinion : posOpinionWords) {
				if(reviewLine.contains(posOpinion)) {
					String featureWord = review.substring(review.indexOf(posOpinion) + posOpinion.length(), review.indexOf(" ", review.indexOf(posOpinion) + posOpinion.length()));
					if(featureWord.equals(feature)) {
						opinion = 1;
						return opinion;
					}
				}
			}
			
			for (String negOpinion : negOpinionWords) {
				if(reviewLine.contains(negOpinion)) {
					String featureWord = review.substring(review.indexOf(negOpinion) + negOpinion.length(), review.indexOf(" ", review.indexOf(negOpinion) + negOpinion.length()));
					if(featureWord.equals(feature)) {
						opinion = -1;
						return opinion;
					}
				}
			}
		}

		return opinion;
	}

	public static void main(String[] args) {
		String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
		
		//String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";
		
		String[][] featureSet = { 
		        { "ambiance", "ambience", "atmosphere", "decor" },
				{ "dessert", "ice cream", "desert" }, 
				{ "food" }, 
				{ "soup" },
				{ "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
		String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
				"delicious" };
		String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

		int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
		System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
	}
}