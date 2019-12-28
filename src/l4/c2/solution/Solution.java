package l4.c2.solution;

import utils.Matrix;
import java.util.*;

public class Solution{

    private static int indexOf(int[] array, int elem){
        int i = 0;
        while(i < array.length && array[i] != elem)
            i++;

        return i == array.length ? -1 : i;
    }

    private static int[] addBunny(int[] bunnies, int bunny){
        int[] rv = new int[bunnies.length + 1];

        // insert elements < bunny into the array to be returned
        int i;
        for(i = 0; i < bunnies.length && bunnies[i] < bunny; i++)
            rv[i] = bunnies[i];


        // insert bunny in the middle
        rv[i] = bunny;

        // insert elements > bunny into the array to be returned
        while(i++ < bunnies.length)
            rv[i] = bunnies[i-1];

        return rv;
    }

    // add a bunny in the appropriate position of a bunnies array, if it does not exist already
    private static int[] successorBunnies(int[] bunniesUntilNow, int successor){
        return indexOf(bunniesUntilNow, successor) != -1 ? bunniesUntilNow : addBunny(bunniesUntilNow, successor);
    }

    // save all bunnies, return a list with all index from 0 to bunnies by excluding starting and bulkhead points
    private static int[] allBunniesSaved(int points){
        int[] bunnies = new int[points-2];

        for(int i = 1; i < points-2; i++)
            bunnies[i] = i;
        return bunnies;
    }

    // return the largest of 2 list or the one with the smallest IDs if lengths are equal
    private static int[] getMaxBunnies(int[] maxBunnies, int[] bunnies){

        // return list of the largest length
        if(maxBunnies.length > bunnies.length)
            return maxBunnies;
        else if(maxBunnies.length < bunnies.length)
            return bunnies;

        // if lengths are equal, return the one with the lowest prisonerID
        int i = 0;
        while (i < maxBunnies.length && bunnies[i] == maxBunnies[i])
            i++;

        return i < maxBunnies.length && maxBunnies[i] < bunnies[i] ? maxBunnies : bunnies;
    }

    // explore all possible states, defining one by the point we are at, the number of bunnies
    // we have and the time left in the game(limit - pathCost) and return the one with the most
    // bunnies excluding those with a cost larger than the maximum we could bounce back from
    private static int[] bunniesBFS(int[][] graph, int limit, int[] shortestPathsToBulkhead){
        int[] maxBunnies = new int[]{};
        List<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        State start = new State(0, 0, maxBunnies);
        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()){
            State current = queue.remove(0);

            // for each successor state
            for(int nb = 0; nb < graph[current.node].length; nb++){
                int shortestPathToBulkhead = shortestPathsToBulkhead[nb];
                int pathCost = current.pathCost + graph[current.node][nb];
                State successor = new State(nb, pathCost, successorBunnies(current.bunnies, nb));

                // omit successor state if there is no way of getting to the bulkHead on time by going
                // that way, even by taking the shortest path or if this state has already been visited
                if(nb == current.node || shortestPathToBulkhead > pathCost || visited.contains(successor))
                    continue;

                queue.add(successor);
                visited.add(successor);
                maxBunnies = getMaxBunnies(maxBunnies, successor.bunnies);

            }
        }

        return maxBunnies;
    }

    // update shortest paths vector in case a cheaper path was found
    private static void relaxEdge(int[][] graph, int[] shortestPaths, int src, int dst){

        if(graph[src][dst] == 0)
            return;

        int alternativePath = Integer.MAX_VALUE;
        if(shortestPaths[src] < Integer.MAX_VALUE)
            alternativePath = graph[src][dst] + shortestPaths[src];
        shortestPaths[dst] = Math.min(shortestPaths[dst], alternativePath);
    }

    private static boolean negativeTest(int[][] graph, int[] shortestPaths, int src, int dst){
        if(graph[src][dst] == 0 || shortestPaths[src] == Integer.MAX_VALUE)
            return false;

        return graph[src][dst] + shortestPaths[src] < shortestPaths[dst];
    }

    // find the shortest path to any node from a source node in the graph
    // and also determine whether there is any negative-cost cycle in the graph
    private static int[] bellmanFord(int[][] graph, int source){
        int[] shortestPaths = new int[graph.length];
        Arrays.fill(shortestPaths, Integer.MAX_VALUE);
        shortestPaths[source] = 0;

        // execute |V|-1 iterations
        for(int i = 0; i < graph.length-1; i++){

            // in each iteration, relax all edges of the graph
            for(int u = 0; u < graph.length; u++)
                for(int v = 0; v < graph[u].length; v++)
                    relaxEdge(graph, shortestPaths, u, v);
        }


        // determine whether there is a negative-cost cycle in the graph
        for(int u = 0; u < graph.length; u++)
            for(int v = 0; v < graph[u].length; v++)
                if(negativeTest(graph, shortestPaths, u, v))
                    return null;

        return shortestPaths;
    }
    
    public static int[] solution(int[][] graph, int limit){
        int[] shortestPathsToBulkhead = bellmanFord(graph, graph.length-1);

        // in case of a negative cycle we never run out of time, therefore all bunnies can be saved
        if(shortestPathsToBulkhead == null)
            return allBunniesSaved(graph.length);

        System.out.println(Arrays.toString(shortestPathsToBulkhead));
        return new int[]{};  //bunniesBFS(graph, limit, shortestPathsToBulkhead);
    }
}