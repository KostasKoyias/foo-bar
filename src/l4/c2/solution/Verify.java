package l4.c1.solution;

import javafx.util.Pair;
import src.utils.Tester;

import java.util.ArrayList;
import java.util.List;

public class Verify{

    public static void main(String[] args){

        List<Pair<Object, Object>> tests = new ArrayList();

        int passed = 0;
        for(Pair<Object, Object> test : tests)
            passed += Tester.test(test.getValue(), test.getKey().toString(), test.getValue());
        Solution.solution();

        Tester.displayResult(passed, tests.size());
    }
}