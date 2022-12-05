package be.tabs_spaces.advent.days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

class Day03Test {

    private val day03 = Day03()

    @ParameterizedTest
    @MethodSource("partOne")
    fun distinctVisits(input: String, expected: Int) {
        assertThat(day03.uniqueVisitsFor(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("partTwo")
    fun distinctVisitsWithSlices(input: String, expected: Int) {
        assertThat(day03.uniqueVisitsFor(input, 2)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun partOne() = listOf(
            ">" to 2,
            "^>v<" to 4,
            "^v^v^v^v^v" to 2
        ).map { (input, expected) -> arguments(input, expected) }.stream()

        @JvmStatic
        fun partTwo() = listOf(
            "^v" to 3,
            "^>v<" to 3,
            "^v^v^v^v^v" to 11
        ).map { (input, expected) -> arguments(input, expected) }.stream()
    }
}