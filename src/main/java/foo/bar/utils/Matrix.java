package foo.bar.utils;

import java.util.Arrays;

public class Matrix {

    public static int[][] matrixCopy(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }

        return copy;
    }

    public static int[][] matrixTranspose(int[][] matrix) {
        int[][] transpose = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }
}
