package be.tabs_spaces.advent.days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

class Day01Test {

    @ParameterizedTest
    @MethodSource("partOne")
    fun toFloor(input: String, expected: Int) {
        assertThat(input.toFloor()).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("partTwo")
    fun commandForFloor(input: String, expected: Int) {
        assertThat(input.commandForFloor(-1)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun partOne() = listOf(
            "(())" to 0,
            "()()" to 0,
            "(((" to 3,
            "(()(()(" to 3,
            "))(((((" to 3,
            "())" to -1,
            "))(" to -1,
            ")))" to -3,
            ")())())" to -3,
        ).map { (input, expected) ->
            arguments(input, expected)
        }.stream()

        @JvmStatic
        fun partTwo() = listOf(
            ")" to 1,
            "()())" to 5,
        ).map { (input, expected) ->
            arguments(input, expected)
        }.stream()
    }

}