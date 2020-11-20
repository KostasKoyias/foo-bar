package foo.bar.l4.c2.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    static Stream<Arguments> getCases() {
        return Stream.of(
                // Case 1: Provided
                Arguments.arguments(new int[][]{
                                {0, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1},
                                {1, 1, 0, 1, 1},
                                {1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 0}}, 3, new int[]{0, 1}),

                // Case 2: Provided
                Arguments.arguments(new int[][]{
                                {0, 2, 2, 2, -1},
                                {9, 0, 2, 2, -1},
                                {9, 3, 0, 2, -1},
                                {9, 3, 2, 0, -1},
                                {9, 3, 2, 2, 0}}, 1, new int[]{1, 2}),

                // Case 3: Infinite negative cycle. Time limit: -500
                Arguments.arguments(new int[][]{
                                {0, 2, 2, 2, -1},
                                {9, 0, 2, 2, 0},
                                {9, 3, 0, 2, 0},
                                {9, 3, 2, 0, 0},
                                {-1, 3, 2, 2, 0}}, -500, new int[]{0, 1, 2}),

                // Case 4: Max bunnies. No rescue possible. Time limit: 1
                Arguments.arguments(new int[][]{
                                {1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1}}, 1, new int[]{}),

                // Case 5: One bunny. Time limit: 2
                Arguments.arguments(new int[][]{
                                {1, 1, 1},
                                {1, 1, 1},
                                {1, 1, 1}}, 2, new int[]{0}),

                // Case 6: Multiple revisits. Time limit: 10
                Arguments.arguments(new int[][]{
                                {0, 5, 11, 11, 1},
                                {10, 0, 1, 5, 1},
                                {10, 1, 0, 4, 0},
                                {10, 1, 5, 0, 1},
                                {10, 10, 10, 10, 0}}, 10, new int[]{0, 1}),

                // Case 7: Multiple Revisits 2. Time limit: 5
                Arguments.arguments(new int[][]{
                                {0, 10, 10, 10, 1},
                                {0, 0, 10, 10, 10},
                                {0, 10, 0, 10, 10},
                                {0, 10, 10, 0, 10},
                                {1, 1, 1, 1, 0}}, 5, new int[]{0, 1}),

                // Case 8: Time travel. Time limit: 1
                Arguments.arguments(new int[][]{
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0}}, 1, new int[]{0, 1, 2}),

                // Case 9: No bunnies. Time limit: 1
                Arguments.arguments(new int[][]{
                                {2, 2},
                                {2, 2}}, 1, new int[]{}),

                // Case 10: Backwards bunny path. Time limit: 6
                Arguments.arguments(new int[][]{
                                {0, 10, 10, 1, 10},
                                {10, 0, 10, 10, 1},
                                {10, 1, 0, 10, 10},
                                {10, 10, 1, 0, 10},
                                {1, 10, 10, 10, 0}}, 6, new int[]{0, 1, 2}));
    }

    @ParameterizedTest
    @MethodSource("getCases")
    public void testSolution(int[][] graph, int limit, int[] expected) {
        assertArrayEquals(expected, Solution.solution(graph, limit));
    }
}