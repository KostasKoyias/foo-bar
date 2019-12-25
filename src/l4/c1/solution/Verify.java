package l4.c1.solution;

import javafx.util.Pair;
import utils.Tester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Test{
    int[] entrances;
    int[] exits;
    int[][] matrix;

    Test(int[] startingRooms, int[] exitRooms, int[][] matrix){
        this.entrances = startingRooms;
        this.exits = exitRooms;
        this.matrix = matrix;
    }

    @Override
    public String toString() {
        return "Test{" +
                "startingRooms=" + Arrays.toString(entrances) +
                ", exitRooms=" + Arrays.toString(exits) +
                ", matrix=" + Arrays.toString(matrix) +
                '}';
    }
}

public class Verify{

    public static void main(String[] args){

        List<Pair<Object, Object>> tests = new ArrayList<>();

        tests.add(new Pair<>(new Test(new int[]{0}, new int[]{3},
                    new int[][]{{0, 7, 0, 0},
                                {0, 0, 6, 0},
                                {0, 0, 0, 8},
                                {9, 0, 0, 0}}), 6));

        tests.add(new Pair<>(new Test(new int[]{0, 1}, new int[]{4, 5},
                new int[][]{ {0, 0, 4, 6, 0, 0},
                             {0, 0, 5, 2, 0, 0},
                             {0, 0, 0, 0, 4, 4},
                             {0, 0, 0, 0, 6, 6},
                             {0, 0, 0, 0, 0, 0},
                             {0, 0, 0, 0, 0, 0}}), 16));

        int passed = 0;
        for(Pair<Object, Object> test : tests){
            Test t = (Test)test.getKey();
            int bunnies = Solution.solution(t.entrances, t.exits, t.matrix);
            passed += Tester.test(bunnies, t.toString(), test.getValue());
        }

        Tester.displayResult(passed, tests.size());
    }
}