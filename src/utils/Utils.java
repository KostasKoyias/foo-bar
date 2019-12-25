package utils;

import java.util.Arrays;

public class Utils {

    public static String matrixToString(int[][] matrix){

        StringBuilder str = new StringBuilder();
        for(int[] row : matrix)
            str.append("\n\t").append(Arrays.toString(row));

        str.trimToSize();
        return str.toString();
    }
}
