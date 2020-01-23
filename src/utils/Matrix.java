package utils;

import javafx.util.Pair;
import java.util.Arrays;

public class Matrix {

    public static String matrixToString(int[][] matrix){
        StringBuilder str = new StringBuilder();
        for(int[] row : matrix)
            str.append("\n\t").append(Arrays.toString(row));

        str.trimToSize();
        return str.toString();
    }

    public static String gridToString(boolean[][] matrix){
        StringBuilder str = new StringBuilder();
        for(boolean[] row : matrix)
            str.append("\n\t").append(Arrays.toString(row));

        str.trimToSize();
        return str.toString();
    }

    public static String gridToString(char[][] matrix){
        StringBuilder str = new StringBuilder();
        for(char[] row : matrix)
            str.append("\n\t").append(Arrays.toString(row));

        str.trimToSize();
        return str.toString();
    }

    public static boolean setGrid(char[][] dst, Pair<Integer, Integer> dstFrom,
                               char[][] src, Pair<Integer, Integer> srcFrom, Pair<Integer, Integer> srcTo){
        int srcFromRow = srcFrom.getKey(), srcFromCol = srcFrom.getValue();
        int srcToRow = srcTo.getKey(), srcToCol = srcTo.getValue();
        int dstFromRow = dstFrom.getKey(), dstFromCol = dstFrom.getValue();
        int rows = srcToRow - srcFromRow + 1, cols = srcToCol - srcFromCol + 1;

        boolean srcRowOk = !(srcFromRow < 0 || srcFromRow > srcToRow || srcToRow >= src.length);
        boolean srcColOk = !(srcFromCol < 0 || srcFromCol > srcToCol || srcToCol >= src[srcToRow].length);
        boolean dstRowOk = !(dstFromRow < 0 || dstFromRow + rows > dst.length);
        boolean dstColOk = !(dstFromCol < 0 || dstFromCol + cols > dst[dstFromRow].length);

        //@@System.out.println("Copying from src: " + srcFrom + " - " + srcTo + " - " + dstFrom + " that many " + rows + ", " + cols);
        //@@System.out.println(Matrix.gridToString(src));

        if(!srcRowOk || !srcColOk || !dstRowOk || !dstColOk)
            return false;

        for(int i = srcFromRow; i <= srcToRow; i++){
            for(int j = srcFromCol; j <= srcToCol; j++){
                int r = dstFromRow + i - srcFromRow, c = dstFromCol + j - srcFromCol;
                dst[r][c] = src[i][j];
            }
        }

        //@@System.out.println("Result: " + Matrix.gridToString(dst));
        return true;
    }

    public static int[][] matrixCopy(int[][] matrix){
        int[][] copy = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++)
            copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);

        return copy;
    }

    public static int[][] matrixTranspose(int[][] matrix){
        int[][] transpose = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++)
                transpose[j][i] = matrix[i][j];
        }

        return  transpose;
    }
}
