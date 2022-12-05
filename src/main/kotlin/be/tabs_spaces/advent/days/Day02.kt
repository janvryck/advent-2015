package be.tabs_spaces.advent.days

class Day02 : Day(2) {
    override fun partOne() = inputList
        .map { Gift.from(it) }
        .sumOf { it.packingPaperSize() }

    override fun partTwo() = inputList
    .map { Gift.from(it) }
    .sumOf { it.ribbonLength() }

    data class Gift(
        val length: Int,
        val width: Int,
        val height: Int,
    ) {

        companion object {
            fun from(input: String) = input.split("x")
                .map { it.toInt() }
                .let { Gift(it[0], it[1], it[2]) }
        }

        private fun front() = length * height
        private fun side() = width * height
        private fun top() = length * width

        private fun totalArea() = 2 * (front() + side() + top())
        private fun slack() = listOf(front(), side(), top()).min()

        fun packingPaperSize() = totalArea() + slack()

        private fun smallestCircumference() = listOf(length, width, height)
            .sorted()
            .take(2)
            .sum() * 2
        private fun volume() = length * width * height

        fun ribbonLength() = smallestCircumference() + volume()

    }
}