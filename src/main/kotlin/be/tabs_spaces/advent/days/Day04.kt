package be.tabs_spaces.advent.days

import java.security.MessageDigest

class Day04: Day(4) {
    override fun partOne() = mineAdventCoin(inputString, leadingZeroes = 5)

    override fun partTwo() = mineAdventCoin(inputString, leadingZeroes = 6)

    fun mineAdventCoin(input: String, leadingZeroes: Int): Any {
        var suffix = 0L
        while(!"$input${suffix}".md5().startsWith("0".repeat(leadingZeroes))) {
            suffix++
        }
        return suffix
    }

    private fun String.md5(): String {
        with(MessageDigest.getInstance("MD5")) {
            return digest(this@md5.toByteArray()).joinToString("") {
                String.format("%02x", it)
            }
        }
    }


}