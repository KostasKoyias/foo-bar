package foo.bar.l4.c1.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    static Stream<Arguments> getCases() {
        return Stream.of(
                // single S & T test cases
                Arguments.arguments(new int[]{0}, new int[]{1},
                    new int[][]{
                        {0, 200},
                        {0,   0}}, 200),

                Arguments.arguments(new int[]{0}, new int[]{3},
                    new int[][]{
                        {0, 20, 10,  0},
                        {0,  0, 30, 10},
                        {0,  0,  0,  20},
                        {0,  0,  0,  0}}, 30),
                Arguments.arguments(new int[]{0}, new int[]{3},
                    new int[][]{
                            {0, 7, 0, 0},
                            {0, 0, 6, 0},
                            {0, 0, 0, 8},
                            {9, 0, 0, 0}}, 6),

                Arguments.arguments(new int[]{0}, new int[]{6},
                    new int[][]{
                            {0, 9, 6, 0, 0, 6, 0},
                            {0, 0, 0, 8, 0, 0, 0},
                            {0, 0, 0, 0, 3, 0, 0},
                            {0, 0, 0, 0, 0, 0, 7},
                            {0, 0, 0, 0, 0, 0, 5},
                            {0, 0, 0, 2, 4, 0, 4},
                            {0, 0, 0, 0, 0, 0, 0}}, 16),

                // multiple S & T test cases
                Arguments.arguments(new int[]{0, 1}, new int[]{4, 5},
                        new int[][]{
                                {0, 0, 4, 6, 0, 0},
                                {0, 0, 5, 2, 0, 0},
                                {0, 0, 0, 0, 4, 4},
                                {0, 0, 0, 0, 6, 6},
                                {0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0}}, 16),

                // anti-parallel edges test case, single S & T
                Arguments.arguments(new int[]{0}, new int[]{5},
                        new int[][]
                                {{0, 16, 13,  0,  0,  0},
                                {0,  0, 10, 12,  0,  0},
                                {0,  4,  0,  0, 14,  0},
                                {0,  0,  9,  0,  0, 20},
                                {0,  0,  0,  7,  0,  4},
                                {0,  0,  0,  0,  0,  0}}, 23));
    }

    @ParameterizedTest
    @MethodSource("getCases")
    public void testSolution(int[] sources, int[] targets, int[][] capacity, int expected) {
        assertEquals(expected, Solution.solution(sources, targets, capacity));
    }
}