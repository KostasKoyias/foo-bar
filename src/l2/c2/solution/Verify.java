package l2.c2.solution;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.util.Pair;
import utils.Tester;

public class Verify{

    public static void main(String[] args){
        int passed;
        ArrayList<Pair<Object, Object>> tests = new ArrayList<>();

        tests.add(new Pair<>(new int[]{4, 17, 50}, new int[]{-1, -1}));
        tests.add(new Pair<>(new int[]{4, 30, 50}, new int[]{12, 1}));
        
        passed = 0;
        for(Pair<Object, Object> test : tests) {
            int[] solution = Solution.solution((int[])test.getKey()), expected = (int[])test.getValue();
            passed += Tester.testVector(solution, Arrays.toString((int[])test.getKey()), expected);
        }

        Tester.displayResult(passed, tests.size());
    }
}