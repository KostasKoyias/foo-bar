package foo.bar.l4.c1.solution;

import foo.bar.utils.Matrix;
import java.util.*;

public class Solution{

    // given the target list and the flow matrix, add up each target's column
    private static int totalFlow(int[][] flow, int[] targets){
        int total = 0;

        for(int target : targets)
            for(int[] fl : flow)
                total += fl[target];

        return total;
    }

    // based on what flows, determine whether we could add or remove flow amongst any pair of nodes
    private static int[][] updateResidualGraph(int[][] capacity, int[][] flow){
        int[][] residualGraph = new int[capacity.length][capacity[0].length];

        for(int i = 0; i < capacity.length; i++){
            for(int j = 0; j < capacity[0].length; j++){

                // create a forward edge for unused capacity
                if(capacity[i][j] > flow[i][j])
                    residualGraph[i][j] = capacity[i][j] - flow[i][j];

                // create a backwards edge for used capacity to be restored
                if(flow[i][j] > 0)
                    residualGraph[j][i] = flow[i][j];
            }
                
        }

        return residualGraph;
    }

    private static Set<Integer> getTargetSet(int[] targets){
        Set<Integer> set = new HashSet<>();

        for(int target : targets)
            set.add(target);
        return set;
    }

    // initialize storage for a BFS, adding all sources to the queue as if there was a super-starting-node
    // connected to all of them, also put them in the visited map, mapping from node to parent(null in the 1st level)
    private static List<Integer> storageInit(int[] sources, Map<Integer, Integer> visited){
        List<Integer> queue = new LinkedList<>();

        for(int source : sources){
            queue.add(source);
            visited.put(source, null);
        }
        return queue;
    }

    // construct path given the goal and map, mapping from node to parent along the path
    private static List<Integer> constructPath(Map<Integer, Integer> visited, int target){
        Integer current, parent;
        List<Integer> path = new ArrayList<>();

        // until reaching the root of the path, move from current to parent,
        // add current in a stack each time so that you get the path in the appropriate order
        path.add(target);
        for(current = target, parent = visited.get(current); parent != null; current = parent, parent = visited.get(current))
            path.add(0, parent);

        return path;
    }

    private static List<Integer> bfs(int[][] graph, int[] sources, int[] targets){
        Map<Integer, Integer> visited = new HashMap<>();
        Set<Integer> targetSet;
        List<Integer> queue;

        // put targets in a HashSet for faster goal-test
        targetSet = getTargetSet(targets);

        // initialize queue with all source nodes & mark them as visited with no parent
        queue = storageInit(sources, visited);
        while(!queue.isEmpty()){
            int parent = queue.remove(0);

            for(int neighbor = 0; neighbor < graph[parent].length; neighbor++){

                // ignore node if not connected or already visited
                if(graph[parent][neighbor] == 0 || visited.containsKey(neighbor))
                    continue;

                // map neighbor to it's parent and apply goal-test
                visited.put(neighbor, parent);
                if(targetSet.contains(neighbor))
                    return constructPath(visited, neighbor);

                // push neighbor in the queue to be processed
                queue.add(neighbor);
            }
        }

        return null;
    }

    // get the minimum weight edge along a path in a graph, here applied on the residual graph
    private static int minWeightEdge(int[][] graph, List<Integer> path){
        int bottleNeck = Integer.MAX_VALUE;

        for(int i = 0; i < path.size()-1; i++)
            bottleNeck = Math.min(bottleNeck, graph[path.get(i)][path.get(i + 1)]);
        return bottleNeck;
    }

    // increment total flow from s to t flow by either adding or removing flow
    // amongst nodes of the augmenting path in the residual graph
    private static void updateFlow(int[][] capacity, int[][] residualGraph, List<Integer> path, int[][] flow){
        int bottleNeck = minWeightEdge(residualGraph, path);

        for(int i = 0; i < path.size()-1; i++){
            int u = path.get(i), v = path.get(i + 1);

            if(capacity[u][v] > 0)
                flow[u][v] += bottleNeck;
            else
                flow[v][u] -= bottleNeck;
        }
    }

    public static int solution(int[] sources, int[] targets, int[][] capacity) {
        int[][] residualGraph, flow = new int[capacity.length][capacity[0].length];
        List<Integer> path;

        // residual graph is initially same as the original because nothing flows
        residualGraph = Matrix.matrixCopy(capacity);
        path = bfs(residualGraph, sources, targets);

        // as long as there is an augmenting path, update flow amongst nodes of that path
        // increasing total flow from sources to targets
        while(path != null){
            updateFlow(capacity, residualGraph, path, flow);
            residualGraph = updateResidualGraph(capacity, flow);
            path = bfs(residualGraph, sources, targets);
        }

        return totalFlow(flow, targets);
    }
}