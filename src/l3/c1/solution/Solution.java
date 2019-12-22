package l3.c1.solution;
import java.lang.Math;
import java.util.HashSet;
import javafx.util.Pair;

public class Solution{

    private static final int WALL = 1;

    // return true if this is the bottom-most right-most cell of the grid
    private static boolean goalTest(int[][] grid, int row, int col){
        int n = grid.length, m = grid[0].length; // get total rows & columns
        return row == n - 1 && col == m - 1 ? true : false;
    }

    private static int findPath(int[][] grid, Pair<Integer, Integer> cell, 
                                boolean wallRemoved, HashSet<Pair<Integer, Integer>> frontier){ 
        int row = cell.getKey(), col = cell.getValue();
        if(Solution.goalTest(grid, row, col))
            return 1;

        // if this cell is out of bounds or we have already either removed a wall or been here, stop 
        boolean outOfBounds = row < 0 || row > grid[0].length-1 || col < 0 || col > grid.length-1;
        boolean outOfRemovals = !outOfBounds && grid[row][col] == Solution.WALL && wallRemoved;
        if(outOfBounds || outOfRemovals || frontier.contains(cell)) 
            return Integer.MAX_VALUE;

        // add this cell to the frontier so that it is ignored in recursive calls
        // down that path, so that we do not end up making cycles
        frontier.add(cell);

        // if there is a wall in this cell, remove it
        if(grid[row][col] == Solution.WALL)
            wallRemoved = true;
        
        // estimate the optimal solution for each possible move
        int left = Solution.findPath(grid, new Pair<Integer, Integer>(row, col - 1), wallRemoved, frontier);
        int top = Solution.findPath(grid, new Pair<Integer, Integer>(row - 1, col), wallRemoved, frontier);
        int right = Solution.findPath(grid, new Pair<Integer, Integer>(row, col + 1), wallRemoved, frontier);
        int down = Solution.findPath(grid, new Pair<Integer, Integer>(row + 1, col), wallRemoved, frontier);

        // remove this cell from the frontier
        frontier.remove(cell);

        // get the best of them
        int cost = Math.min(Math.min(Math.min(left, top), right), down);
        return cost == Integer.MAX_VALUE ? cost : cost + 1;
    }

    // find the path recursively starting from the upper-left corner
    public static int solution(int[][] grid){
        HashSet<Pair<Integer, Integer>> frontier = new HashSet<>();
        return Solution.findPath(grid, new Pair<Integer, Integer>(0, 0), false, frontier); 
    }
}