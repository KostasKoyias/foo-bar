package l3.c1.solution;

import java.lang.Math;
import java.util.Arrays;
import java.util.Stack;

class Cell{
    int row;
    int col;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString(){
        return "(" + row + ", " + col + ")";
    }
}

public class Solution{

    private static final int WALL = 1;
    private static final int NONE = -1;

    private static int[][] findPathDFS(int[][] grid, int row, int col){ 
        Stack<Cell> stack = new Stack<>();
        int height = grid.length, width = grid[0].length;
        int[][] costs = new int[height][width];
        Cell[] neighbors = new Cell[]{new Cell(1, 0), new Cell(-1, 0), new Cell(0, -1), new Cell(0, 1)};

        // initialize costs
        for(int[] r : costs)
            Arrays.fill(r, NONE);
        costs[row][col] = 1; //start

        stack.push(new Cell(row, col));
        while(!stack.isEmpty()){
            Cell cell = stack.pop();

            // for each adjacent cell (left, up, right, down)
            for(Cell n : neighbors){

                int r = n.row + cell.row, c = n.col + cell.col;
                    
                // if this is an inside the grid, not yet visited cell
                boolean inBounds = r >= 0 && r < height && c >= 0 && c < width;
                
                /*@@if(r == 2 && c == 4){
                    System.out.println(costs[r][c] + " <== " + costs[cell.row][cell.col]);
                    for(int[] rr : costs)
                        System.out.println(Arrays.toString(rr));
                
                    System.out.println("----------------\n");
                }*/

                if(inBounds && (costs[r][c] == NONE || costs[r][c] > costs[cell.row][cell.col] + 1)){

                    // the cost to it is the cost to get here plus 1 step
                    costs[r][c] = costs[cell.row][cell.col] + 1;
                    
                    // do not expand wall cells
                    if(grid[r][c] != WALL)
                        stack.push(new Cell(r, c));
                }
            }
        }

        return costs;
    }

    // find the path recursively starting from the upper-left corner
    public static int solution(int[][] grid){
        int n = grid.length, m = grid[0].length;

        // use DFS both start to goal and goal to start and get shortest path for each cell
        // do not expand wall cells so if the two meet, one wall was removed at most
        // they either meet on some empty cell or a wall
        int[][] topBottom = findPathDFS(grid, 0, 0);
        int[][] bottomTop = findPathDFS(grid, n-1, m-1);

        for(int[] r : topBottom)
            System.out.println(Arrays.toString(r));
        
        System.out.println("----------------\n");

        for(int[] r : bottomTop)
            System.out.println(Arrays.toString(r));

        // if the optimal path   [0]  [0]   -> [i][j] takes c1 steps including stepping on [0][0]
        // and the optimal path  [n-1][m-1] -> [i][j] takes c2 steps including stepping on [n-1][m-1]
        // then the optimal path [0]  [0]   -> [n-1][m-1] through [i][j] takes c1 + c2 - 1 steps
        int cost = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                // if this cell is accessible in both ways, update min cost
                if(topBottom[i][j] != NONE && bottomTop[i][j] != NONE){
                    cost = Math.min(cost, topBottom[i][j] + bottomTop[i][j] - 1);
                    System.out.println(new Cell(i, j).toString());
                }
            }
        }

        return cost;
    }
}