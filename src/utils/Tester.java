package utils;

import java.util.Arrays;

public class Tester {

    public static int test(Object sol, String key, Object value){
        if(sol == null)
            return -1;

        System.out.print(sol.equals(value) ? "\u001B[32mPassed" : "\u001B[31mFailed");
        System.out.println("\u001B[0m: solution(" + key + ") = " + sol.toString());
        return sol.equals(value) ? 1 : 0;
    }

    public static int testVector(int[] solution, String test, int[] expected){
        System.out.print(Arrays.equals(solution, expected) ? "\u001B[32mPassed" : "\u001B[31mFailed");
        System.out.println("\u001B[0m: solution(" + test + ") = " + Arrays.toString(solution));
        return Arrays.equals(solution, expected) ? 1 : 0;
    }

    public static void displayResult(int passed, int total){
        String result = passed < total ? "\u001B[1;31mFailure" : "\u001B[1;32mSuccess";
        System.out.println("\n\u001B[0;1;4mResult\u001B[0m: " + result + " \u001B[0m"
                + passed + "/" + total + " test cases passed");
    }
}
