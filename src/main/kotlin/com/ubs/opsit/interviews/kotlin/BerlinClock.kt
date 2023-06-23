package com.ubs.opsit.interviews.kotlin


class BerlinClock : TimeConverter {


    override fun convertTime(aTime: String): String {
        val timeBlocks = aTime.split(":").map { it.toInt() }

        return listOf(
                blinkingYellowLight(timeBlocks[2]),
                //upper hours
                generateLampRow(4, timeBlocks[0] / 5, "R", "O"),
                //lower hours
                generateLampRow(4, timeBlocks[0] % 5, "R", "O"),
                // upper minutes, the map index part handles the red lights for the quarter hours
                generateLampRow(11, timeBlocks[1] / 5, "Y", "O").mapIndexed { index, c -> if ((index + 1) % 3 == 0 && c == 'Y') "R" else c.toString() }.joinToString(""),
                // lower minutes
                generateLampRow(4, timeBlocks[1] % 5, "Y", "O")
        ).joinToString(separator = "\r\n")
    }

    private fun generateLampRow(totalLamps: Int, activeLamps: Int, activeSymbol: String, inactiveSymbol: String): String =
            activeSymbol.repeat(activeLamps) + inactiveSymbol.repeat(totalLamps - activeLamps)

    fun blinkingYellowLight(seconds: Int): String = if (seconds % 2 == 0) "Y" else "O"


}