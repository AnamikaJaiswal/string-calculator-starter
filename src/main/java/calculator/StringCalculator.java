package calculator;

import java.util.*;

class StringCalculator {

    public int add(String input) {
        if(input.isEmpty())
        	return 0;
        else if(input.contains(",")) {
        	String[] tokens = input.split(",");
        	List<String> tokenslist = Arrays.asList(tokens);
        	return tokenslist.stream().mapToInt(token -> Integer.parseInt(token)).sum();
        } else 
        	return Integer.parseInt(input);
    }
}