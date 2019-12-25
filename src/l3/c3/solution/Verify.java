package l3.c3.solution;

import javafx.util.Pair;
import l3.Tester;

import java.util.ArrayList;
import java.util.List;

public class Verify{

    public static void main(String[] args){
        List<Pair<Object, Object>> tests = new ArrayList<>();

        tests.add(new Pair<>(new int[]{1, 1, 1}, 1));
        tests.add(new Pair<>(new int[]{1, 2, 3, 4, 5, 6}, 3));

        int passed = 0;
        for(Pair<Object, Object> test : tests)
            passed += Tester.test(Solution.solution((int[])test.getKey()), test);

        Tester.displayResult(passed, tests.size());
    }
}