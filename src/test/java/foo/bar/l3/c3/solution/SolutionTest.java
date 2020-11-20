package foo.bar.l3.c3.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> getCases() {
        return Stream.of(
            Arguments.arguments(new int[]{1, 1, 1}, 1),
            Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6}, 3));
    }

    @ParameterizedTest
    @MethodSource("getCases")
    public void testSolution(int[] input, int expected) {
        assertEquals(expected, Solution.solution(input));
    }
}