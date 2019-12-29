package l5.solution;

import javafx.util.Pair;
import utils.Tester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Verify{

    public static void main(String[] args){

        List<Pair<Object, Object>> tests = new ArrayList<>();

        tests.add(new Pair<>(new int[]{2, 3, 4}, "430"));
        tests.add(new Pair<>(new int[]{2, 2, 2}, "7"));

        int passed = 0;
        for(Pair<Object, Object> test : tests){
            int[] props = (int[])test.getKey();
            passed += Tester.test(Solution.solution(props[0], props[1], props[2]), Arrays.toString(props), test.getValue());
        }

        Tester.displayResult(passed, tests.size());
    }
}