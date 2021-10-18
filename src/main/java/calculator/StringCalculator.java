package calculator;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class StringCalculator {

    public int add(String input) {
        if(input.isEmpty())
        	return 0;
        else {
        	String[] tokens = tokenize(input);
        	List<String> tokenslist = Arrays.asList(tokens);
        	List<Integer> negatives = tokenslist.stream().map(token -> Integer.parseInt(token)).filter(token -> token<0).collect(Collectors.toList());
        	if(negatives.size()>0)
        		throw new RuntimeException("negatives not allowed: "+ negatives.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(" ")));
        	else
        		return tokenslist.stream().filter(token -> Integer.parseInt(token)<=1000).mapToInt(token -> Integer.parseInt(token)).sum();
        } 
    }
    
    private static String[] tokenize(String text) {
    	if(text.startsWith("//")) {
    		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
    		m.matches();
    		String customDelimiter = m.group(1);
    		String numbers = m.group(2);
    		return numbers.split(Pattern.quote(customDelimiter));
    	}
    	else
    		return text.split(",|\n");
    }
}