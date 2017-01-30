package com.intertec;

import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class UsernameHandling {

	public CheckResponse checkUsername(String username, HashSet existing){
		if(username.length() < 6)
			throw new IllegalArgumentException("Username should be at least 6 characters long");

		Boolean isValid = !existing.contains(username.toLowerCase());

		CheckResponse checkResponse;
		ArrayList<String> suggestions = new ArrayList<String>();
		if(isValid)
			checkResponse = new CheckResponse(isValid, suggestions);
		else{
			suggestions = getSuggestions(username.toLowerCase(), existing);
			checkResponse = new CheckResponse(isValid, suggestions);
		}
		return checkResponse;
	}

	public ArrayList<String> getSuggestions(String username, HashSet existing){
		ArrayList<String> suggestions = new ArrayList<String>();

		Random random = new Random();
		int min = 10;
		int max = 99;
		for(int i = 0; i <= 13; i++){
			int rnd_suffix = random.nextInt(max - min + 1) + min;
			String suggestion = username + String.valueOf(rnd_suffix);
			if(existing.contains(suggestion)){
				suggestion += getRandomSuffix();
				// Drop this suggestion, start again
				if(existing.contains(suggestion))
					i--;
				
			} else {
				suggestions.add(suggestion);
			}
		}

		return suggestions;
	}

	private String getRandomSuffix(){
		Random random = new Random();
		int max = 122;
		int min = 97;
		int a = random.nextInt(max - min + 1) + min;
		int b = random.nextInt(max - min + 1) + min;
		int c = random.nextInt(max - min + 1) + min;
		char x = (char) a;
		char y = (char) a;
		char z = (char) b;
		String new_s = "" + x + y + z;
		
		return new_s;
	}
}