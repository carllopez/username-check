package com.intertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class UsernameApplication {

    private static final Logger logger = LoggerFactory.getLogger(UsernameApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(UsernameApplication.class, args);

		LocalStorage localStorage = new LocalStorage();
		HashSet<String> usernames = localStorage.getContent("/target/classes/storage/usernames.txt");

		
		UsernameHandling uh = new UsernameHandling();

		if(args.length == 0){
			logger.error("You need to pass at least one parameter for username check");
			System.exit(0);
		}

		String in_username = String.valueOf(args[0]);

		CheckResponse checkResponse;
		// Wrapping the check in an exception handler to present a 'nice' output to the user
		try {
			checkResponse = uh.checkUsername(in_username, usernames);	
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
			checkResponse = null;
			System.exit(0);
		}
		

		if(!checkResponse.valid){
			for (String suggestion: checkResponse.suggestions)
				logger.info("Suggestion: " + suggestion);
		}
		else
			logger.info("It is a valid username, congratulations!");

	}
}
