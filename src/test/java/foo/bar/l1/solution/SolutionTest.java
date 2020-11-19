package foo.bar.l1.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> getCases() {
        return Stream.of(
            Arguments.arguments("code", "100100101010100110100010"),
            Arguments.arguments("Braille", "000001110000111010100000010100111000111000100010"),
            Arguments.arguments("The quick brown fox jumps over the lazy dog",
                "000001011110110010100010000000111110101001010100" +
                "100100101000000000110000111010101010010111101110" +
                "0000001101001010101011010000000101101010011011001" +
                "1110001110000000010101011100110001011101000000001" +
                "1110110010100010000000111000100000101011101111000" +
                "000100110101010110110")
        );
    }

    @ParameterizedTest
    @MethodSource("getCases")
    public void testSolution(String input, String expected) {
        assertEquals(expected, Solution.solution(input));
    }
}