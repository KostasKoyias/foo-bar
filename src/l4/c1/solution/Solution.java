package l4.c1.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution{

    public static int solution(int[] entrances, int[] out, int[][] path) {
        final int MAX_STEPS = 50;
        List<Integer> entries = Arrays.stream(entrances).boxed().collect(Collectors.toList());
        List<Integer> exits = Arrays.stream(out).boxed().collect(Collectors.toList());

        // memo represents the number of bunnies in each room at a certain moment in time
        int[] memo = memoInit(entrances, path.length);

        // max bunnies is the maximum number of bunnies having reached an exit at any given moment
        int maxBunnies = 0, steps = 0;

        // as long as the starting list is not the same as the ending list
        while(!entries.equals(exits) && steps++ < MAX_STEPS){

            // update number of bunnies in each room
            List<Integer> nextEntries = memoUpdate(entries, path, memo);

            // update maximum bunnies escaping per moment of time
            // by looking at the number of bunnies in each exit
            maxBunnies += Math.max(atExits(exits, memo), maxBunnies);
            entries = nextEntries;
        }

        return maxBunnies;
    }

    // update memo for each starting point of a given moment in time
    private static List<Integer> memoUpdate(List<Integer> entries, int[][] path, int[] memo){
        List<Integer> nextEntries = new ArrayList<>();
        //@System.out.println("Entries: " + entries.toString());

        // for each starting point of this given moment in time
        for(int i = 0; i < entries.size() && memo[entries.get(i)] > 0; i++){
            int entry = entries.get(i);
            //@System.out.println("Entry: " + i);

            // for each neighbor in the adjacency matrix
            for(int nb = 0; nb < path[entry].length; nb++){
                if(path[entry][nb] == 0)
                    continue;

                //@System.out.println("\tNeighbor: " + nb);
                int fit = Math.min(path[entry][nb], memo[entry]);
                memo[entry] -= fit;
                memo[nb] += fit;

                //@System.out.println("\tMemo: " + Arrays.toString(memo));
                if(!nextEntries.contains(nb))
                    nextEntries.add(nb);
            }
        }

        return nextEntries;
    }

    // initialize memo, representing the number of bunnies in each room
    private static int[] memoInit(int[] entries, int len){
        int[] memo = new int[len];

        // starting rooms initially contain the maximum number of bunnies possible
        for(int entry : entries)
            memo[entry] = Integer.MAX_VALUE;

        return memo;
    }

    // estimate the number of bunnies reaching the ending points at this time step
    private static int atExits(List<Integer> exits, int[] memo){
        int bunnies = 0;
        for(int exit : exits)
            bunnies += memo[exit];
        return bunnies;
    }
}