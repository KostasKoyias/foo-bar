package foo.bar.l4.c2.solution;

import foo.bar.utils.Matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    private static int[] successorBunnies(int[] bunniesUntilNow, int successor, int total){
        if(successor == 0 || successor == total -1 || indexOf(bunniesUntilNow, successor) != -1)
            return bunniesUntilNow;
        else
            return addBunny(bunniesUntilNow, successor);
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

    // explore all possible states in level-by-level(BFS), defining one by the node we are at
    // and the number of bunnies we have, returning the one with the most bunnies
    // excluding those with a cost larger than the maximum we could bounce back from
    private static int[] bunnySearch(int[][] graph, int limit, int[] shortestPathsToBulkhead){
        int[] maxBunnies = new int[]{};
        List<State> queue = new LinkedList<>();
        Map<State, Integer> visited = new HashMap<>(); // map from (node, bunnies[]) -> pathCost

        State start = new State(0, maxBunnies);
        queue.add(start);
        visited.put(start, 0);

        while(!queue.isEmpty()){

            State current = queue.remove(0);

            // for each successor state
            for(int nb = 0; nb < graph[current.node].length; nb++){
                int shortestPathToBulkhead = shortestPathsToBulkhead[nb];
                int pathCost = visited.get(current) + graph[current.node][nb];
                State successor = new State(nb, successorBunnies(current.bunnies, nb, graph.length));

                // omit successor state if there is no way of getting to the bulkHead on time by going
                // that way, even by taking the shortest path or we have been to this exact state in the past
                // meaning same node and bunny list, with more time remaining -- smaller pathCost
                boolean tooLate = nb == current.node || (shortestPathToBulkhead + pathCost > limit);
                int previousCost = visited.getOrDefault(successor, Integer.MAX_VALUE);
                if(tooLate || previousCost <= pathCost)
                    continue;

                queue.add(successor);
                visited.put(successor, pathCost);
                maxBunnies = getMaxBunnies(maxBunnies, successor.bunnies);
                if(maxBunnies.length == graph.length - 2)
                    return allBunniesSaved(graph.length);

            }
        }

        return Arrays.stream(maxBunnies).map(bunny -> bunny -1).toArray();
    }

    // update shortest paths vector in case a cheaper path was found
    private static void relaxEdge(int[][] graph, int[] shortestPaths, int src, int dst){

        if(src == dst)
            return;

        int alternativePath = Integer.MAX_VALUE;
        if(shortestPaths[src] < Integer.MAX_VALUE)
            alternativePath = graph[src][dst] + shortestPaths[src];
        shortestPaths[dst] = Math.min(shortestPaths[dst], alternativePath);
    }

    private static boolean negativeTest(int[][] graph, int[] shortestPaths, int src, int dst){
        if(src == dst || shortestPaths[src] == Integer.MAX_VALUE)
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
        int[] shortestPathsToBulkhead = bellmanFord(Matrix.matrixTranspose(graph), graph.length-1);

        // in case of a negative cycle we never run out of time, therefore all bunnies can be saved
        if(shortestPathsToBulkhead == null)
            return allBunniesSaved(graph.length);

        // no bunnies can be saved if even the shortest path
        // from start to bulkhead takes up too much time
        if(shortestPathsToBulkhead[0] > limit)
            return new int[]{};

        return bunnySearch(graph, limit, shortestPathsToBulkhead);
    }
}