package com.intertec;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class LocalStorage {

	public HashSet getContent(String fileName){
		HashSet<String> usernames = new HashSet<String>();	
		String base_dir = System.getProperty("user.dir");

		try (BufferedReader br = new BufferedReader(new FileReader(base_dir + fileName))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       usernames.add(line.toLowerCase());
		    }
		}
		catch (Exception e) {
		    System.err.println(e.getMessage()); // handle exception
		}

		return usernames;
	}
}