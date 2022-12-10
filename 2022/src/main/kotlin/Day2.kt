import org.gradle.internal.impldep.org.apache.commons.io.IOUtils
import java.nio.charset.StandardCharsets

class Day2 {
    private fun getInput(): String {
        return IOUtils.toString(Day2::class.java.classLoader.getResourceAsStream("Day2.txt"), StandardCharsets.UTF_8)
    }

    fun playAllRoundsPartOne(): Int {
        var input = getInput()
        var scoreTotal = 0
        scoreTotal += input.count { it == 'X' }
        scoreTotal += (input.count { it == 'Y' }) * 2
        scoreTotal += (input.count { it == 'Z' }) * 3
        // Replace so all rocks are X etc
        input = input.replace('A', 'X')
        input = input.replace('B', 'Y')
        input = input.replace('C', 'Z')
        val roundList = input.split("\n")
        for (round in roundList) {
            val chars = round.toCharArray()
            val elf = chars[0]
            val me = chars[2]
            if((elf == 'X' && me == 'Y') || (elf == 'Y' && me == 'Z') || (elf == 'Z' && me == 'X')) {
                scoreTotal += 6
            } else if(elf == me) {
                scoreTotal += 3
            }
        }
        return scoreTotal
    }

    fun playAllRoundsPartTwo(): Int {
        val input = getInput()
        var scoreTotal = 0
        scoreTotal += (input.count { it == 'Y' }) * 3
        scoreTotal += (input.count { it == 'Z' }) * 6
        val roundList = input.split("\n")
        for (round in roundList) {
            val chars = round.toCharArray()
            val elf = chars[0]
            val me = chars[2]
            if ((me == 'X' && elf == 'A') || (me == 'Y' && elf == 'C') || (me == 'Z' && elf == 'B')) {
                scoreTotal += 3
            } else if((me == 'X' && elf == 'C') || (me == 'Y' && elf == 'B') || (me == 'Z' && elf == 'A')) {
                scoreTotal += 2
            } else {
                scoreTotal += 1
            }
        }
        return scoreTotal
    }
}