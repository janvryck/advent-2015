package be.tabs_spaces.advent.days

import be.tabs_spaces.advent.days.Day03.Direction.*
import be.tabs_spaces.advent.days.Day03.Direction.Companion.toDirection

class Day03 : Day(3) {

    override fun partOne() = uniqueVisitsFor(inputString)

    override fun partTwo() = uniqueVisitsFor(inputString, 2)

    fun uniqueVisitsFor(
        rawDirections: String,
        slices: Int = 1
    ) = (0 until slices)
        .flatMap { slice ->
            rawDirections.map { it.toDirection() }
            .slice(slice until rawDirections.length step slices)
            .fold(mutableListOf(Position(0, 0))) { positions, direction ->
                positions.apply { add(positions.last().move(direction)) }
            }
    }
        .distinct()
        .size

    data class Position(val x: Int, val y: Int) {
        fun move(direction: Direction) = when (direction) {
            NORTH -> Position(x + 1, y)
            EAST -> Position(x, y + 1)
            SOUTH -> Position(x - 1, y)
            WEST -> Position(x, y - 1)
        }
    }

    enum class Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
        ;

        companion object {
            fun Char.toDirection() = when (this) {
                '^' -> NORTH
                '>' -> EAST
                'v' -> SOUTH
                '<' -> WEST
                else -> throw IllegalArgumentException("Unknown direction '$this'")
            }
        }
    }
}