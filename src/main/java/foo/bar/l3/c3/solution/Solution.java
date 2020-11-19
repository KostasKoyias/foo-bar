package foo.bar.l3.c3.solution;

public class Solution{

    public static int solution(int[] list){
        int countJ, countK, count, i, j, k;

        // for each possible 1st part of the triplet
        for(i = 1, count = 0; i < list.length - 1; i++) {

            // count the multiples smaller than it
            for (j = countJ = 0; j < i; j++)
                countJ += list[i] % list[j] == 0 ? 1 : 0;

            // count the multiples larger than it
            for (k = i + 1, countK = 0; k < list.length; k++)
                countK += list[k] % list[i] == 0 ? 1 : 0;

            // update counter
            count += countK * countJ;
        }

        return count;
    }
}