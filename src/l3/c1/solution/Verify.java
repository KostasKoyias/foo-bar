package l3.c1.solution;

import java.util.ArrayList;

import javafx.util.Pair;
import utils.Tester;
import utils.Matrix;

public class Verify{

    public static void main(String[] args){
        ArrayList<Pair<Object, Object>> tests = new ArrayList<>();

        // test cases provided
        tests.add(new Pair<>(
                new int[][]{{0, 1, 1, 0}, 
                            {0, 0, 0, 1}, 
                            {1, 1, 0, 0}, 
                            {1, 1, 1, 0}}, 7));

        tests.add(new Pair<>(
            new int[][]{{0, 0, 0, 0, 0, 0}, 
                        {1, 1, 1, 1, 1, 0}, 
                        {0, 0, 0, 0, 0, 0}, 
                        {0, 1, 1, 1, 1, 1}, 
                        {0, 1, 1, 1, 1, 1}, 
                        {0, 0, 0, 0, 0, 0}}, 11));
        
        // random tests found while googling
        tests.add(new Pair<>(
            new int[][]{{0, 1, 0, 0, 0, 0, 1, 0, 0, 0}, 
                        {0, 1, 0, 1, 0, 0, 0, 1, 0, 0}, 
                        {0, 0, 0, 1, 0, 0, 1, 0, 1, 0}, 
                        {1, 1, 1, 1, 0, 1, 1, 1, 1, 0}, 
                        {0, 0, 0, 1, 0, 0, 0, 1, 0, 1}, 
                        {0, 1, 0, 0, 0, 0, 1, 0, 1, 1}, 
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 0}, 
                        {0, 1, 0, 0, 0, 0, 1, 0, 0, 0}, 
                        {0, 0, 0, 1, 1, 1, 0, 1, 1, 0}}, 34));

        int passed = 0;
        for(Pair<Object, Object> test : tests){
            String key = Matrix.matrixToString((int[][])test.getKey());
            passed += Tester.test(Solution.solution((int [][])test.getKey()), key, test.getValue());
        }

        Tester.displayResult(passed, tests.size());
    }

}