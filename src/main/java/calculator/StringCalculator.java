package calculator;

import java.util.*;
import java.util.regex.*;

class StringCalculator {

    public int add(String input) {
        if(input.isEmpty())
        	return 0;
        else {
        	String[] tokens = tokenize(input);
        	List<String> tokenslist = Arrays.asList(tokens);
        	return tokenslist.stream().mapToInt(token -> Integer.parseInt(token)).sum();
        } 
    }
    
    private static String[] tokenize(String text) {
    	if(text.startsWith("//")) {
    		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
    		m.matches();
    		String customDelimiter = m.group(1);
    		String numbers = m.group(2);
    		return numbers.split(customDelimiter);
    	}
    	else
    		return text.split(",|\n");
    }
}