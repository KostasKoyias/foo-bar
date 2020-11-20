package foo.bar.l3.c2.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    static Stream<Arguments> getCases() {
        return Stream.of(
            Arguments.arguments(3, 1),
            Arguments.arguments(4, 1),
            Arguments.arguments(5, 2),
            Arguments.arguments(6, 3),
            Arguments.arguments(7, 4),
            Arguments.arguments(8, 5),
            Arguments.arguments(9, 7),
            Arguments.arguments(10, 9),
            Arguments.arguments(11, 11),
            Arguments.arguments(100, 444792),
            Arguments.arguments(150, 19406015),
            Arguments.arguments(200, 487067745));
    }

    @ParameterizedTest
    @MethodSource("getCases")
    public void testSolution(int input, int expected) {
        assertEquals(expected, Solution.solution(input));
    }
}