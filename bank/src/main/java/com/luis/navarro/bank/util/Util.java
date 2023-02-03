package com.luis.navarro.bank.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Util {

    // Function to convert camel case
    // string to snake case string
    public static String camelToSnake(String str) {
 
        // Empty String
        String result = "";
 
        // Append first character(in lower case)
        // to result string
        char c = str.charAt(0);
        result = result + Character.toLowerCase(c);
 
        // Traverse the string from
        // ist index to last index
        for (int i = 1; i < str.length(); i++) {
 
            char ch = str.charAt(i);
 
            // Check if the character is upper case
            // then append '_' and such character
            // (in lower case) to result string
            if (Character.isUpperCase(ch)) {
                result = result + '_';
                result
                    = result
                      + Character.toLowerCase(ch);
            }
 
            // If the character is lower case then
            // add such character into result string
            else {
                result = result + ch;
            }
        }
 
        // return the result
        return result;
    }
    
    /**
     * @param n
     * @return
     */
    public static Integer solutionSumDigits(int n) {
    	String number = String.valueOf(n);
    	Integer result = 0;
    	for(int i = 0; i < number.length(); i++) {
    	    int j = Character.digit(number.charAt(i), 10);
    	    result += Integer.valueOf(j);
    	}
    	
    	return result;
    }
    
    /**
     * @param picture
     * @return
     */
    public static String[] solutionTextAsteric(String[] picture) {
    List<String> result = new LinkedList<>();
    	var wrapper = new Object(){ int index = 0; String textAsteric = "";};
    	Arrays.asList(picture).stream().forEach(p -> {
    		if (wrapper.index == 0) {
                for (int i=0;i<p.length();i++){
    			wrapper.textAsteric = wrapper.textAsteric + "*";
    		}
    			result.add("*" + wrapper.textAsteric + "*");
    		}
    		result.add("*" + p + "*");
    		wrapper.index += 1;
    	});
    	result.add("*" + wrapper.textAsteric + "*");
    	
    	return result.toArray(new String[0]);
    }

}
