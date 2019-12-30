package l3.c2.solution;

import java.util.List;
import java.util.ArrayList;
import javafx.util.Pair;
import utils.Tester;

public class Verify{

    public static void main(String[] args){

        List<Pair<Object, Object>> tests = new ArrayList<>();

        tests.add(new Pair<>(3, 1));
        tests.add(new Pair<>(4, 1));
        tests.add(new Pair<>(5, 2));
        tests.add(new Pair<>(6, 3));
        tests.add(new Pair<>(7, 4));
        tests.add(new Pair<>(8, 5));
        tests.add(new Pair<>(9, 7));
        tests.add(new Pair<>(10, 9));
        tests.add(new Pair<>(11, 11));
        tests.add(new Pair<>(100, 444792));
        tests.add(new Pair<>(150, 19406015));
        tests.add(new Pair<>(200, 487067745));

        int passed = 0;
        for(Pair<Object, Object> test : tests)
            passed += Tester.test(Solution.solution((int)test.getKey()), test.getKey().toString(), test.getValue());

        Tester.displayResult(passed, tests.size());
    }
}