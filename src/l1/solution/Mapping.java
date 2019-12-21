package l1.solution;

import java.util.Map;
import java.util.HashMap;
import javafx.util.Pair;

public class Mapping{

    // convert string to integer for a given base in [2, 10]
    private static int atoi(String str, int base){
        int i, factor, value, len = str.length();
        
        for(i = value = 0, factor = 1; i < len; i++, factor *= base)
            value += (str.charAt(len -1 - i) - '0') * factor;

        return value;
    }

    private static HashMap<Character, String> getCodeMap(Pair<String, String> phrase){
        HashMap<Character, String> map = new HashMap<>();
        final int size = 6;
        int i, j;
        String str = phrase.getKey(), code = phrase.getValue();
        char[] array = str.toCharArray();

        for(i = j = 0; i < array.length; i++, j += size){

            Character letter = array[i];
            if(letter >= 'A' && letter <= 'Z'){
                System.out.println("Found capital " + letter + ": " + code.substring(j, j + 2 * size));
                j += size;
            }
            
            String value = code.substring(j, j + size);
            map.put(letter, value);
        }

        return map;
    }

    public static void main(String[] args){
        final int codeBase = 2;
        HashMap<Character, String> mapBinString;
        HashMap<Character, Integer> mapInt = new HashMap<>();
        String str = "The quick brown fox jumps over the lazy dog"; // this sentence contains all letters of the alphabet!!!
        String code = "000001011110110010100010000000111110101001010100" +
                      "100100101000000000110000111010101010010111101110" +
                      "0000001101001010101011010000000101101010011011001" +
                      "1110001110000000010101011100110001011101000000001" +
                      "1110110010100010000000111000100000101011101111000" +
                      "000100110101010110110";

        mapBinString = Mapping.getCodeMap(new Pair<String, String>(str, code));
        for(Map.Entry<Character, String> entry : mapBinString.entrySet()){
            mapInt.put(entry.getKey(), atoi(entry.getValue(), codeBase));
            System.out.println("map.put('" + entry.getKey() + "', \"" + entry.getValue() + "\");");
        }

        System.out.println(mapInt);
    }

}
