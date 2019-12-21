package l2.c1.solution;
import java.util.ArrayList;
import java.util.Arrays;

class Test{
    protected int height;
    protected int[] indexes;
    protected int[] parents;

    public Test(int height, int[] indexes, int[] parents){
        this.height = height;
        this.indexes = indexes;
        this.parents = parents;
    }
}

public class Verify{

    public static void main(String[] args){
        ArrayList<Test> tests = new ArrayList<>();
        int[] result;

        tests.add(new Test(3, new int[]{1, 4, 7}, new int[]{3, 6, -1}));
        tests.add(new Test(5, new int[]{19, 14, 28}, new int[]{21, 15, 29}));
        tests.add(new Test(3, new int[]{7, 3, 5, 1}, new int[]{-1, 7, 6, 3}));

        for(Test test : tests){
            result = Solution.solution(test.height, test.indexes);
            System.out.print(Arrays.equals(result, test.parents) ? "\u001B[1;32mPassed" : "\u001B[1;31mFailed");
            System.out.println("\u001B[0m");
        }
    }
}