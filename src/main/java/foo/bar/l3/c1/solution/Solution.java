package foo.bar.l3.c1.solution;

import java.lang.Math;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// user-defined representation of the cell, so that
// both dimensions can be stored in the queue of BFS
class Cell{
    int row;
    int col;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Solution{
    private static final int WALL = 1, NONE = -1;

    // map each cell to a cost until hitting a wall or visiting them all
    // path-cost to each cell will be optimal because of using BFS in
    // a maze with step-cost equal to 1 for each possible step
    private static int[][] findPathBFS(int[][] grid, int row, int col){ 
        Queue<Cell> queue = new LinkedList<>();
        int height = grid.length, width = grid[0].length;
        int[][] costs = new int[height][width];
        Cell[] neighbors = new Cell[]{new Cell(1, 0), new Cell(-1, 0), new Cell(0, -1), new Cell(0, 1)};

        // initialize costs
        for(int[] r : costs)
            Arrays.fill(r, NONE);
        costs[row][col] = 1; //start

        // keep expanding nodes level-by-level until hitting a wall cell
        queue.add(new Cell(row, col));
        while(!queue.isEmpty()){
            Cell cell = queue.poll();

            // for each adjacent cell (left, up, right, down)
            for(Cell n : neighbors){

                // get exact position of this neighbor
                int r = n.row + cell.row, c = n.col + cell.col;
                    
                // if this is an inside the grid, not yet visited cell
                boolean inBounds = r >= 0 && r < height && c >= 0 && c < width;
                if(inBounds && costs[r][c] == NONE){

                    // the cost of the neighbor cell is the cost until that point plus 1 more step
                    costs[r][c] = costs[cell.row][cell.col] + 1;
                    
                    // do not expand wall cells
                    if(grid[r][c] != WALL)
                        queue.add(new Cell(r, c));
                }
            }
        }

        return costs;
    }

    // find the path recursively starting from the upper-left corner
    public static int solution(int[][] grid){
        int n = grid.length, m = grid[0].length;

        // use BFS both from start to goal and from goal to start and get shortest path for each cell
        // until you hit a wall(inclusive), do not expand wall cells so if the two searches meet, 
        // this is either a no-wall path or a single wall path, in which case the wall can be removed
        // finally, get the shortest path of those, be careful not to double count the common cell
        int[][] topBottom = findPathBFS(grid, 0, 0);
        int[][] bottomTop = findPathBFS(grid, n-1, m-1);

        // if the optimal path   [0]  [0]   -> [i][j] takes c1 steps including stepping on [0][0]
        // and the optimal path  [n-1][m-1] -> [i][j] takes c2 steps including stepping on [n-1][m-1]
        // then the optimal path [0]  [0]   -> [n-1][m-1] through [i][j] 
        // takes exactly c1 + c2 - 1 steps(to not double-count the common cell)
        int cost = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                // if this cell is accessible in both ways, then it represents a path with 
                // either no walls or a single wall only, which is the cell the two meet on
                if(topBottom[i][j] != NONE && bottomTop[i][j] != NONE)
                    cost = Math.min(cost, topBottom[i][j] + bottomTop[i][j] - 1);
            }
        }

        return cost;
    }
}