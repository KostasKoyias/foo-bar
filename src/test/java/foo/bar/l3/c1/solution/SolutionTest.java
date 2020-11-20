package foo.bar.l3.c1.solution;

import foo.bar.l3.c1.solution.Solution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    static Stream<Arguments> getCases() {
        return Stream.of(
            Arguments.arguments(
                    new int[][]{{0, 1, 1, 0},
                                {0, 0, 0, 1},
                                {1, 1, 0, 0},
                                {1, 1, 1, 0}}, 7),
            Arguments.arguments(
                new int[][]{{0, 0, 0, 0, 0, 0},
                            {1, 1, 1, 1, 1, 0},
                            {0, 0, 0, 0, 0, 0},
                            {0, 1, 1, 1, 1, 1},
                            {0, 1, 1, 1, 1, 1},
                            {0, 0, 0, 0, 0, 0}}, 11),
            Arguments.arguments(
                new int[][]{{0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                            {0, 1, 0, 1, 0, 0, 0, 1, 0, 0},
                            {0, 0, 0, 1, 0, 0, 1, 0, 1, 0},
                            {1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
                            {0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                            {0, 1, 0, 0, 0, 0, 1, 0, 1, 1},
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                            {0, 0, 0, 1, 1, 1, 0, 1, 1, 0}}, 34)
        );
    }

    @ParameterizedTest
    @MethodSource("getCases")
    public void testSolution(int[][] input, int expected) {
        assertEquals(expected, Solution.solution(input));
    }

}