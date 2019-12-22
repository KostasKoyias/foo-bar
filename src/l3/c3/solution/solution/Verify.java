package l3.c1.solution;
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
        Solution.solution();
    }
}