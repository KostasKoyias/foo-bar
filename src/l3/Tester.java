package l3;

import javafx.util.Pair;

public class Tester {

    public static int test(Object sol, Pair<Object, Object> test){

        System.out.print(sol.equals(test.getValue()) ? "\u001B[32mPassed" : "\u001B[31mFailed");
        System.out.println("\u001B[0m solution(" + test.getKey().toString() + ") = " + sol.toString());
        return sol.equals(test.getValue()) ? 1 : 0;
    }

    public static void displayResult(int passed, int total){
        String result = passed < total ? "\u001B[1;31mFailure" : "\u001B[1;32mSuccess";
        System.out.println("\n\u001B[0;1;4mResult\u001B[0m: " + result + " \u001B[0m"
                + passed + "/" + total + " test cases passed");
    }
}
