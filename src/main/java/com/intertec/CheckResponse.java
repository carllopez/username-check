package com.intertec;

import java.util.ArrayList;

public class CheckResponse {

	public final Boolean valid;
	public final ArrayList<String> suggestions;

	public CheckResponse(Boolean valid, ArrayList<String> suggestions) {
        this.valid = valid;
        this.suggestions = suggestions;
    }
}