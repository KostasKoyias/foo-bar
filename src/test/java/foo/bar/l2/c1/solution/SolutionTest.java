package foo.bar.l2.c1.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> getCases() {
        return Stream.of(
            Arguments.arguments(3, new int[]{1, 4, 7}, new int[]{3, 6, -1}),
            Arguments.arguments(5, new int[]{19, 14, 28}, new int[]{21, 15, 29}),
            Arguments.arguments(3,new int[]{7, 3, 5, 1}, new int[]{-1, 7, 6, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("getCases")
    public void testSolution(int height, int[] indices, int[] expected) {
        final int[] actual = Solution.solution(height, indices);
        assertArrayEquals(expected, actual);
    }

}