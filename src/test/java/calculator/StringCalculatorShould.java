package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

    @Test
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }
    
    @Test
    void string_with_two_numbers_delimited_by_comma_should_return_sum_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("1,2"));
    }
    
    @Test
    void string_with_multiple_numbers_delimited_by_comma_should_return_sum_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1,2,3"));
    }
    
    @Test
    void string_with_multiple_numbers_delimited_by_newline_should_return_sum_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }
    
    @Test
    void string_with_multiple_numbers_with_custom_delimiter_should_return_sum_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }
    
    @Test
    void string_with_multiple_numbers_with_regex_Spl_char_as_custom_delimiter_should_return_sum_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("//.\n1.2"));
    }
    
    @Test
    void string_with_negative_numbers_should_raise_exception() {
    	try {
    		StringCalculator stringCalculator = new StringCalculator();
            stringCalculator.add("-1,-2,3");
            fail("Exception expected.");
    	} 
    	catch(RuntimeException ex){
    		assertEquals("negatives not allowed: -1 -2", ex.getMessage());    		
    	}        
    }
 
    @Test
    void string_with_numbers_greater_than_thousand_should_be_ignored() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(2, stringCalculator.add("2,1001"));
    }
    
}
