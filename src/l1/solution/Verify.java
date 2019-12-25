package l1.solution;

import java.util.ArrayList;
import javafx.util.Pair;
import l3.Tester;

public class Verify{

    public static void main(String[] args){
        ArrayList<Pair<Object, Object>> tests = new ArrayList<>();

        tests.add(new Pair<>("code", "100100101010100110100010"));
        tests.add(new Pair<>("Braille", "000001110000111010100000010100111000111000100010"));
        tests.add(new Pair<>("The quick brown fox jumps over the lazy dog",
                      "000001011110110010100010000000111110101001010100" +
                      "100100101000000000110000111010101010010111101110" +
                      "0000001101001010101011010000000101101010011011001" +
                      "1110001110000000010101011100110001011101000000001" +
                      "1110110010100010000000111000100000101011101111000" +
                      "000100110101010110110"));

        int passed = 0;
        for(Pair<Object, Object> test : tests){
            String phrase = (String)test.getKey(), code = (String)test.getValue(), myCode = Solution.solution(phrase);
            passed += Tester.test(myCode, phrase, code);
        }

        Tester.displayResult(passed, tests.size());
    }
}