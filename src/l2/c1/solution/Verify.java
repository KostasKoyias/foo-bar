package l2.c1.solution;
import utils.Tester;

import java.util.ArrayList;
import java.util.Arrays;

class Test{
    int height;
    int[] indexes;
    int[] parents;

    Test(int height, int[] indexes, int[] parents){
        this.height = height;
        this.indexes = indexes;
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "Test{" +
                "height=" + height +
                ",\tindexes=" + Arrays.toString(indexes) +
                ",\tparents=" + Arrays.toString(parents) +
                '}';
    }
}

public class Verify{

    public static void main(String[] args){
        ArrayList<Test> tests = new ArrayList<>();
        int passed;

        tests.add(new Test(3, new int[]{1, 4, 7}, new int[]{3, 6, -1}));
        tests.add(new Test(5, new int[]{19, 14, 28}, new int[]{21, 15, 29}));
        tests.add(new Test(3, new int[]{7, 3, 5, 1}, new int[]{-1, 7, 6, 3}));

        passed = 0;
        for(Test test : tests){
            int[] result = Solution.solution(test.height, test.indexes);
            boolean equal = Arrays.equals(result, test.parents);
            passed += equal ? 1 : 0;
            System.out.print(equal ? "\u001B[1;32mPassed" : "\u001B[1;31mFailed");
            System.out.println("\u001B[0m: " + test.toString() + "\t--> " + Arrays.toString(result));
        }

        Tester.displayResult(passed, tests.size());
    }
}