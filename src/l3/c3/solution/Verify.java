package l3.c3.solution;

import javafx.util.Pair;
import utils.Tester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Verify{

    public static void main(String[] args){
        List<Pair<Object, Object>> tests = new ArrayList<>();

        tests.add(new Pair<>(new int[]{1, 1, 1}, 1));
        tests.add(new Pair<>(new int[]{1, 2, 3, 4, 5, 6}, 3));

        int passed = 0;
        for(Pair<Object, Object> test : tests){
            String key = Arrays.toString((int[])test.getKey());
            passed += Tester.test(Solution.solution((int[])test.getKey()), key, test.getValue());
        }

        Tester.displayResult(passed, tests.size());
    }
}