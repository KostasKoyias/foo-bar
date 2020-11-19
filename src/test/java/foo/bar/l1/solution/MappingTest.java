package foo.bar.l1.solution;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MappingTest {

    @Test
    public void testGetCodeMap() {
        String string = "The quick brown fox jumps over the lazy dog";
        String code = "000001011110110010100010000000111110101001010100" +
                "100100101000000000110000111010101010010111101110" +
                "0000001101001010101011010000000101101010011011001" +
                "1110001110000000010101011100110001011101000000001" +
                "1110110010100010000000111000100000101011101111000" +
                "000100110101010110110";
        final Map<Character, String> expected = new HashMap<>();
        expected.put(' ', "000000"); expected.put('a', "100000"); expected.put('b', "110000");
        expected.put('c', "100100"); expected.put('d', "100110"); expected.put('e', "100010");
        expected.put('f', "110100"); expected.put('g', "110110"); expected.put('h', "110010");
        expected.put('i', "010100"); expected.put('j', "010110"); expected.put('k', "101000");
        expected.put('l', "111000"); expected.put('m', "101100"); expected.put('n', "101110");
        expected.put('o', "101010"); expected.put('p', "111100"); expected.put('q', "111110");
        expected.put('r', "111010"); expected.put('s', "011100"); expected.put('t', "011110");
        expected.put('u', "101001"); expected.put('v', "111001"); expected.put('w', "010111");
        expected.put('x', "101101"); expected.put('y', "101111"); expected.put('z', "101011");


        final Map<Character, String> codeMap = Mapping.getCodeMap(string, code);
        codeMap.keySet().retainAll(expected.keySet()); // keep values for keys of interest only
        assertEquals(expected, codeMap);
    }
}