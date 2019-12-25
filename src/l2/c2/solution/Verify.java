package l2.c2.solution;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.util.Pair;
import l3.Tester;

public class Verify{

    public static void main(String[] args){
        int passed;
        ArrayList<Pair<Object, Object>> tests = new ArrayList<>();

        tests.add(new Pair<>(new int[]{4, 17, 50}, new int[]{-1, -1}));
        tests.add(new Pair<>(new int[]{4, 30, 50}, new int[]{12, 1}));
        
        passed = 0;
        for(Pair<Object, Object> test : tests) {
            int[] solution = Solution.solution((int[])test.getKey()), value = (int[])test.getValue();
            System.out.print(Arrays.equals(solution, value) ? "\u001B[32mPassed" : "\u001B[31mFailed");
            System.out.println("\u001B[0m: solution(" +
                    Arrays.toString((int[])test.getKey()) + ") = " + Arrays.toString(solution));
            passed += Arrays.equals(solution, (int[])test.getValue()) ? 1 : 0;
        }

        Tester.displayResult(passed, tests.size());
    }
}