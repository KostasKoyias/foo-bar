package l3.c2.solution;

import java.util.List;
import java.util.ArrayList;
import javafx.util.Pair;

public class Verify{

    public static void main(String[] args){

        List<Pair<Integer, Integer>> tests = new ArrayList<>();

        tests.add(new Pair<Integer, Integer>(3, 1));
        tests.add(new Pair<Integer, Integer>(4, 1));
        tests.add(new Pair<Integer, Integer>(5, 2));
        tests.add(new Pair<Integer, Integer>(6, 3));
        tests.add(new Pair<Integer, Integer>(7, 4));
        tests.add(new Pair<Integer, Integer>(8, 5));
        tests.add(new Pair<Integer, Integer>(9, 7));
        tests.add(new Pair<Integer, Integer>(10, 9));
        tests.add(new Pair<Integer, Integer>(11, 11));
        tests.add(new Pair<Integer, Integer>(100, 444792));
        tests.add(new Pair<Integer, Integer>(150, 19406015));
        tests.add(new Pair<Integer, Integer>(200, 487067745));

        int passed = 0;
        for(Pair<Integer, Integer> test : tests){
            int ways = Solution.solution(test.getKey());

            if(ways == test.getValue()){
                passed++;
                System.out.print("\u001B[32mPassed");
            }
            else
                System.out.print("\u001B[31mFailed");
            System.out.println("\u001B[0m solution(" + test.getKey() + ") = " + ways);
        }

        String result = passed < tests.size() ? "\u001B[1;31mFailure" : "\u001B[1;32mSuccess";
        System.out.println("\n\u001B[0;1;4mResult\u001B[0m: " + result + " \u001B[0m" 
                        + passed + "/" + tests.size() + " test cases passed");
    }
}