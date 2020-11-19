package foo.bar.l1.solution;

import java.util.HashMap;

public class Mapping {

    private Mapping() {
    }

    public static HashMap<Character, String> getCodeMap(String string, String code) {
        HashMap<Character, String> map = new HashMap<>();
        final int size = 6;
        int i, j;
        char[] array = string.toCharArray();

        for (i = j = 0; i < array.length; i++, j += size) {

            char letter = array[i];
            if (letter >= 'A' && letter <= 'Z') {
                j += size;
            }

            String value = code.substring(j, j + size);
            map.put(letter, value);
        }

        return map;
    }
}
