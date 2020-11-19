package foo.bar.l2.c2.solution;

import foo.bar.l2.c2.solution.Solution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    static Stream<Arguments> getCases() {
        return Stream.of(
            Arguments.arguments(new int[]{4, 17, 50}, new int[]{-1, -1}),
            Arguments.arguments(new int[]{4, 30, 50}, new int[]{12, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("getCases")
    public void testSolution(int[] input, int[] expected) {
        assertArrayEquals(expected, Solution.solution(input));
    }
}