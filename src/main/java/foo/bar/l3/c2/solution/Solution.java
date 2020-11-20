/* create a dictionary mapping from # of bricks to another map
 * that maps for a given 1st layer - base size to the number of
 * possible ways to create the stair-case choosing that size for our base step
 * so we have the total number of ways to create the staircase
 * for each valid base size of each possible number of bricks to use
 *
 * for a given number of bricks, for each possible base size
 * lookup the map to get the total number of ways to build a staircase
 * with what is left, a value that was estimated in some previous iteration past
 * this is called dynamic programming, using previous estimations instead of re-estimating
 *
 * e.g for NUM = 9, possible bases are {4, 5, 6, 7, 8}
 * these are found starting from the minimum number x satisfying the
 * equation (x ^ (x + 1)/2) >= NUM up to NUM-1.
 * Having a smaller base than that there is no way to build a NUM-sized
 * stair-case, even if we used one brick less on each level
 * (e.g 3 + 2 + 1 < 9, so we need a base with size at least 4)
 *
 * Then, sum up the ways to build a staircase with what is left if you choose
 * any of the above possible 1st layer sizes, as your base size
 * (e.g solution(9) = solution(9-4) + solution(9-5) + ... + solution(9-8))
 *
 * if left-overs are lesser than the base add 1 more to the number of building ways
 * which is accomplished by adding all the L left-overs
 * at once, this was not counted before because solution(L) used more than 1 levels!
 */
package foo.bar.l3.c2.solution;

import java.util.HashMap;
import java.util.Map;

class BrickMap {
    Map<Integer, Map<Integer, Integer>> map;

    BrickMap() {
        map = new HashMap<>();
    }

    void put(Integer num, Integer base, Integer value) {
        if (!map.containsKey(num)) {
            map.put(num, new HashMap<Integer, Integer>());
        }

        map.get(num).put(base, value);
    }

    Integer get(Integer num, Integer base) {
        if (!map.containsKey(num)) {
            return null;
        }

        return map.get(num).get(base);
    }
}

public class Solution {

    public static int solution(int number) {

        final int minBricks = 3;
        BrickMap memo = new BrickMap();
        memo.put(minBricks, 2, 1); // base case

        for (int bricks = minBricks + 1; bricks <= number; bricks++) {
            int sum = 0, minBase = (int) Math.ceil((-1 + Math.sqrt(1 + 8 * bricks)) / 2);

            // find the minimum number of bricks required for a given 1st layer - base
            for (int base = minBase; base < bricks; base++) {

                // based on the number of bricks left for a given 1st layer size
                int leftOver = bricks - base;

                // using at most min(leftOver-1, base-1) bricks, how many ways are
                // there to build a staircase with what is left
                if (leftOver >= minBricks) {
                    sum += memo.get(leftOver, Math.min(leftOver - 1, base - 1));
                }

                // if there is also possible to add all leftOver bricks at once
                // then sum++, this was not counted before because we needed at least 2 levels of bricks
                if (leftOver < base) {
                    sum++;
                }

                memo.put(bricks, base, sum);
            }
        }

        return memo.get(number, number - 1);
    }
}