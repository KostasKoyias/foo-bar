package l4.c2.solution;

import javafx.util.Pair;
import utils.Tester;
import utils.Matrix;

import java.util.ArrayList;
import java.util.List;

public class Verify{

    public static void main(String[] args){

        List<Pair<Pair<int[][], Integer>, Object>> tests = new ArrayList<>();

        // Case 1: Provided
        tests.add(new Pair<>(new Pair<>
                (new int[][]{
                {0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0}}, 3), new int[]{0, 1}));

        // Case 2: Provided
        tests.add(new Pair<>(new Pair<>
                (new int[][]{
                {0, 2, 2, 2, -1},
                {9, 0, 2, 2, -1},
                {9, 3, 0, 2, -1},
                {9, 3, 2, 0, -1},
                {9, 3, 2, 2, 0}}, 1), new int[]{1, 2}));

        // Case 3: Infinite negative cycle. Time limit: -500
        tests.add(new Pair<>(new Pair<>
                (new int[][]{
                {0, 2, 2, 2, -1},
                {9, 0, 2, 2, 0},
                {9, 3, 0, 2, 0},
                {9, 3, 2, 0, 0},
                {-1, 3, 2, 2, 0}}, -500), new int[]{0, 1, 2}));

        // Case 4: Max bunnies. No rescue possible. Time limit: 1
        tests.add(new Pair<>(new Pair<>
                (new int[][]{
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1}}, 1), new int[]{}));

        // Case 5: One bunny. Time limit: 2
        tests.add(new Pair<>(new Pair<>
                (new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}}, 2), new int[]{0}));

        // Case 6: Multiple revisits. Time limit: 10
        tests.add(new Pair<>(new Pair<>
                (new int[][]{
                {0, 5, 11, 11, 1},
                {10, 0, 1, 5, 1},
                {10, 1, 0, 4, 0},
                {10, 1, 5, 0, 1},
                {10, 10, 10, 10, 0}}, 10), new int[]{0, 1}));

        // Case 7: Multiple Revisits 2. Time limit: 5
        tests.add(new Pair<>(new Pair<>
                (new int[][]{
                {0, 10, 10, 10, 1},
                {0, 0, 10, 10, 10},
                {0, 10, 0, 10, 10},
                {0, 10, 10, 0, 10},
                {1, 1, 1, 1, 0}}, 5), new int[]{0, 1}));

        // Case 8: Time travel. Time limit: 1
        tests.add(new Pair<>(new Pair<>
                (new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}}, 1), new int[]{0, 1, 2}));

        // Case 9: No bunnies. Time limit: 1
        tests.add(new Pair<>(new Pair<>
                (new int[][]{
                {2, 2},
                {2, 2}}, 1), new int[]{}));

        // Case 10: Backwards bunny path. Time limit: 6
         tests.add(new Pair<>(new Pair<>
                (new int[][]{
                {0, 10, 10, 1, 10},
                {10, 0, 10, 10, 1},
                {10, 1, 0, 10, 10},
                {10, 10, 1, 0, 10},
                {1, 10, 10, 10, 0}}, 6), new int[]{0, 1, 2}));

        int passed = 0;
        for(Pair<Pair<int[][], Integer>, Object> test : tests){
            Pair<int[][], Integer> input = test.getKey();
            int[][] times = input.getKey();
            int limit = input.getValue();
            Solution.solution(times, limit); //@@@
            passed += Tester.testVector(Solution.solution(times, limit),
                    Matrix.matrixToString(times) + ", " + limit,
                    (int[])test.getValue());
        }

        Tester.displayResult(passed, tests.size());
    }
}