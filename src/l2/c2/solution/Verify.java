package l2.c2.solution;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.util.Pair;

public class Verify{

    public static void main(String[] args){
        int passed;
        ArrayList<Pair<int[], int[]>> tests = new ArrayList<>();

        tests.add(new Pair<int[], int[]>(new int[]{4, 17, 50}, new int[]{-1, -1}));
        tests.add(new Pair<int[], int[]>(new int[]{4, 30, 50}, new int[]{12, 1}));
        
        passed = 0;
        for(Pair<int[], int[]> test : tests){
            if(Arrays.equals(Solution.solution(test.getKey()), test.getValue())){
                passed++;
                System.out.println("\u001B[32mPassed");
            }
            else{
                System.out.println("\u001B[0m" + Arrays.toString(Solution.solution(test.getKey())));
                System.out.println("\u001B[31mFailed");
            }
        }

        String result = passed < tests.size() ? "\u001B[1;31mFailure" : "\u001B[1;32mSuccess";

        System.out.println("\u001B[0;1;4mResult\u001B[0m: " + result + " \u001B[0m" 
                        + passed + "/" + tests.size() + " test cases passed");
    }
}