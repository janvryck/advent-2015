package be.tabs_spaces.advent.days

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

class Day04Test {
    private val day04 = Day04()

    @ParameterizedTest
    @MethodSource("partOneCases")
    fun partOne(input: String, expected: Long) {
        assertThat(day04.mineAdventCoin(input, 5)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun partOneCases() = listOf(
            "abcdef" to 609043L,
            "pqrstuv" to 1048970L,
        ).map { (input, expected) -> arguments(input, expected) }.stream()
    }
}