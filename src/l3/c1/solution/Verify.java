package l3.c1.solution;
import java.util.ArrayList;
import javafx.util.Pair;

public class Verify{

    public static void main(String[] args){
        ArrayList<Pair<int[][], Integer>> tests = new ArrayList<>();

        tests.add(new Pair<int[][], Integer>(new int[][]{{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 0}}, 7));
        tests.add(new Pair<int[][], Integer>(
            new int[][]{{0, 0, 0, 0, 0, 0}, 
                        {1, 1, 1, 1, 1, 0}, 
                        {0, 0, 0, 0, 0, 0}, 
                        {0, 1, 1, 1, 1, 1}, 
                        {0, 1, 1, 1, 1, 1}, 
                        {0, 0, 0, 0, 0, 0}}, 11));

        int passed = 0;
        for(Pair<int[][], Integer> test : tests){

            int cost = Solution.solution(test.getKey());
            if(cost == test.getValue()){
                passed++;
                System.out.println("\u001B[32mPassed \u001B[0m" + cost);
            }
            else
                System.out.println("\u001B[31mFailed \u001B[0m" + cost);
        }

        String result = passed < tests.size() ? "\u001B[1;31mFailure" : "\u001B[1;32mSuccess";
        System.out.println("\u001B[0;1;4mResult\u001B[0m: " + result + " \u001B[0m" 
                        + passed + "/" + tests.size() + " test cases passed");
    }

}