import org.gradle.internal.impldep.org.apache.commons.io.IOUtils
import java.nio.charset.StandardCharsets

class Day1 {
    private fun getInput(): String {
        return IOUtils.toString(Day1::class.java.classLoader.getResourceAsStream("Day1.txt"), StandardCharsets.UTF_8)
    }

    private fun collapseIntoTotals(): MutableList<Int> {
        val input = getInput()
        val elfCalories = input.split("\n\n")
        val elfTotal = mutableListOf<Int>()
        elfCalories.forEach { elf ->
            val listCalories = elf.split("\n")
            elfTotal.add(listCalories
                .asSequence()
                .filter { it.split("\n")[0].toIntOrNull() != null }
                .sumOf { it.split("\n")[0].toInt() })
        }
        return elfTotal
    }

    fun getMostCalories(): Int? {
        return collapseIntoTotals().maxOrNull()
    }

    fun getTopThreeCombinedCalories(): Int {
        val calories = collapseIntoTotals()
        val sorted = calories.sorted()
        return (sorted[sorted.size - 1] + sorted[sorted.size - 2] + sorted[sorted.size - 3])
    }
}