package calculator;

class StringCalculator {

    public int add(String input) {
        if(input.isEmpty())
        	return 0;
        else if(input.contains(",")) {
        	String[] tokens = input.split(",");
        	return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]);
        } else 
        	return Integer.parseInt(input);
    }

}