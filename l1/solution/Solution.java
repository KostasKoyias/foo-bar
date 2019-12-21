package l1.solution;
import java.util.HashMap;

public class Solution {
    
    public static String solution(String s) {
        
        // declare all information about Braille encoding
        final String capMark = "000001";
        HashMap<Character, String> map = new HashMap<>();
    
        // map each character to it's code, we got those
        // from the 3rd example that is known to contain
        // all letters of the alphabet
        map.put(' ', "000000"); map.put('a', "100000"); map.put('b', "110000");
        map.put('c', "100100"); map.put('d', "100110"); map.put('e', "100010");
        map.put('f', "110100"); map.put('g', "110110"); map.put('h', "110010");
        map.put('i', "010100"); map.put('j', "010110"); map.put('k', "101000");
        map.put('l', "111000"); map.put('m', "101100"); map.put('n', "101110");
        map.put('o', "101010"); map.put('p', "111100"); map.put('q', "111110");
        map.put('r', "111010"); map.put('s', "011100"); map.put('t', "011110");
        map.put('u', "101001"); map.put('v', "111001"); map.put('w', "010111");
        map.put('x', "101101"); map.put('y', "101111"); map.put('z', "101011");
        
        // we will use a character vector instead of a String
        // in order to have more efficient append operations
    	StringBuilder code = new StringBuilder();
    	
    	// map each character to the corresponding 6-bit code
    	for(char ch : s.toCharArray()){
    	       
    	   // append Braille capitalization mark if this is an upper-case
    	   if(ch >= 'A' && ch <= 'Z'){
    	       code.append(capMark);
    	       code.append(map.get((char)(ch - 'A' + 'a')));       
    	   }
    	   else
    	        code.append(map.get(ch));
    	}
    	
    	code.trimToSize();
    	return code.toString();
    }
}