package l2.c1.solution;
import java.lang.Math;
import java.util.Arrays;

public class Solution{

    // move either left or right in the tree based on the current
    // value and the goal's value
    public static int nextChild(int parent, int power, int goal){
        int leftChild = parent - power;
        int rightChild = parent - 1;

        return leftChild < goal ? rightChild : leftChild;
    }

    public static int findParent(int height, int power, int goal){
        int parent, depth, child;
        depth = 0;
        parent = -1;
        child = power-1; // root

        // traverse a certain branch of the tree -> O(h)
        // looking for the node and return the corresponding parent
        while(depth < height && child != goal){
            parent = child;
            child = nextChild(parent, power/2, goal);
            power/=2;
            depth++;
        }

        return depth < height ? parent : -1;
    }

    public static int[] solution(int h, int[]q){
        int[] parents = new int[q.length];
        int power = (int)Math.pow(2, h);

        // find parent of each node and put it
        // at the appropriate position of the result list
        for(int i = 0; i < q.length; i++)
            parents[i] = findParent(h, power, q[i]);

        return parents;
    }
}