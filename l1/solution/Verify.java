package l1.solution;
import java.util.ArrayList;
import javafx.util.Pair;
import l1.solution.Solution;

public class Verify{

    public static void main(String[] args){

        ArrayList<Pair<String, String>> tests = new ArrayList<>();

        tests.add(new Pair<String, String>("code", "100100101010100110100010"));
        tests.add(new Pair<String, String>("Braille", "000001110000111010100000010100111000111000100010"));
        tests.add(new Pair<String, String>("The quick brown fox jumps over the lazy dog", 
                      "000001011110110010100010000000111110101001010100" +
                      "100100101000000000110000111010101010010111101110" +
                      "0000001101001010101011010000000101101010011011001" +
                      "1110001110000000010101011100110001011101000000001" +
                      "1110110010100010000000111000100000101011101111000" +
                      "000100110101010110110"));

        for(Pair<String, String> test : tests){
            String phrase = test.getKey(), code = test.getValue(), myCode = Solution.solution(phrase);
            String result = code.equals(myCode) ? "\u001B[1;32mPassed" : "\u001B[1;31mFailure"; 
            System.out.println(result + "\u001B[0m");
        }

    }
}