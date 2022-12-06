package be.tabs_spaces.advent.days

import java.security.MessageDigest

class Day04 : Day(4) {

    companion object {
        private val MD5 = MessageDigest.getInstance("MD5")
    }

    override fun partOne() = mineAdventCoin(inputString, leadingZeroes = 5)

    override fun partTwo() = mineAdventCoin(inputString, leadingZeroes = 6)

    fun mineAdventCoin(input: String, leadingZeroes: Int) = generateSequence(0L) { it + 1 }
        .takeWhile { !"$input$it".mined(leadingZeroes) }
        .last() + 1

    private fun String.mined(leadingZeroes: Int) = md5().startsWith("0".repeat(leadingZeroes))

    private fun String.md5(): String = MD5.digest(toByteArray()).toHex()

    private fun ByteArray.toHex() = joinToString("") { String.format("%02x", it) }


}