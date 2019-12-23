package l3.c1.solution;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.util.Pair;

public class Verify{

    public static void main(String[] args){
        ArrayList<Pair<int[][], Integer>> tests = new ArrayList<>();

        // test cases provided
        tests.add(new Pair<int[][], Integer>(
                new int[][]{{0, 1, 1, 0}, 
                            {0, 0, 0, 1}, 
                            {1, 1, 0, 0}, 
                            {1, 1, 1, 0}}, 7));

        tests.add(new Pair<int[][], Integer>(
            new int[][]{{0, 0, 0, 0, 0, 0}, 
                        {1, 1, 1, 1, 1, 0}, 
                        {0, 0, 0, 0, 0, 0}, 
                        {0, 1, 1, 1, 1, 1}, 
                        {0, 1, 1, 1, 1, 1}, 
                        {0, 0, 0, 0, 0, 0}}, 11));
        
        // random tests found while googling
        tests.add(new Pair<int[][], Integer>(
            new int[][]{{0, 1, 0, 0, 0, 0, 1, 0, 0, 0}, 
                        {0, 1, 0, 1, 0, 0, 0, 1, 0, 0}, 
                        {0, 0, 0, 1, 0, 0, 1, 0, 1, 0}, 
                        {1, 1, 1, 1, 0, 1, 1, 1, 1, 0}, 
                        {0, 0, 0, 1, 0, 0, 0, 1, 0, 1}, 
                        {0, 1, 0, 0, 0, 0, 1, 0, 1, 1}, 
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 0}, 
                        {0, 1, 0, 0, 0, 0, 1, 0, 0, 0}, 
                        {0, 0, 0, 1, 1, 1, 0, 1, 1, 0}}, 34));

        int passed = 0;
        for(Pair<int[][], Integer> test : tests){

            int cost = Solution.solution(test.getKey());
            if(cost == test.getValue()){
                passed++;
                System.out.print("\u001B[32mPassed");
            }
            else
                System.out.print("\u001B[31mFailed");
            System.out.println(" \u001B[0m: " + test.getKey().length + "x" + test.getKey()[0].length + " --> " + cost);
        }

        String result = passed < tests.size() ? "\u001B[1;31mFailure" : "\u001B[1;32mSuccess";
        System.out.println("\n\u001B[0;1;4mResult\u001B[0m: " + result + " \u001B[0m" 
                        + passed + "/" + tests.size() + " test cases passed");
    }

}