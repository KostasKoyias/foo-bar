package l4.c2.solution;

import javafx.util.Pair;
import utils.Tester;
import utils.Matrix;

import java.util.ArrayList;
import java.util.List;

public class Verify{

    public static void main(String[] args){

        List<Pair<Pair<int[][], Integer>, Object>> tests = new ArrayList<>();

        tests.add(new Pair<>(new Pair<>
                (new int[][]{
                {0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0}}, 3), new int[]{0, 1}));

        tests.add(new Pair<>(new Pair<>
                (new int[][]{
                {0, 2, 2, 2, -1},
                {9, 0, 2, 2, -1},
                {9, 3, 0, 2, -1},
                {9, 3, 2, 0, -1},
                {9, 3, 2, 2, 0}}, 1), new int[]{1, 2}));

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