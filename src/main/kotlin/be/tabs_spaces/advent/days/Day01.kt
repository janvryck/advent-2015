package be.tabs_spaces.advent.days

class Day01 : Day(1) {
    override fun partOne() = inputString.toFloor()

    override fun partTwo() = inputString.commandForFloor(-1)
}

fun String.toFloor(): Int {
    return count { it == '(' } - count { it == ')' }
}

fun String.commandForFloor(floor: Int): Int {
    var currentFloor = 0
    return this.takeWhile {
        currentFloor += if (it == '(') 1 else -1
        currentFloor != floor
    }.length + 1
}
