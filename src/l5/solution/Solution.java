package l5.solution;

import java.util.*;

public class Solution{

    private static List<Integer> memo = (new ArrayList<>(Arrays.asList(1, 1)));
    private static int factorial(int num){
        if(num < 0)
            return -1;

        if(num >= memo.size())
            for(int n = memo.size(); n <= num; n++)
                memo.add(n * memo.get(n-1));

        return memo.get(num);
    }

    private static int nChooseK(int n, int k, boolean rep){
        int up = rep ? n : n + k -1;
        int divisor = factorial(k) * factorial(up - k);
        return factorial(up)/divisor;
    }

    private static int distinctValues(List<Integer> list){
        int distinct = list.size();
        Set<Integer> set = new HashSet<>();

        for(Integer num : list){
            if(set.contains(num))
                distinct--;
            else
                set.add(num);
        }

        return distinct;
    }

    public static String solution(int width, int height, int states){

        List<Integer> row = new ArrayList<>();
        int distinctRows = nChooseK(states, width, false);
        int returnValue = 0;

        return Integer.toString(returnValue);
    }
}