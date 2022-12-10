import org.gradle.internal.impldep.org.apache.commons.io.IOUtils
import java.nio.charset.StandardCharsets

class Day3 {
    private fun getInput(): String {
        return IOUtils.toString(Day3::class.java.classLoader.getResourceAsStream("Day3.txt"), StandardCharsets.UTF_8)
    }

    fun getDuplicateItem(): MutableList<Char> {
        val input = getInput()
        val duplicateItems = mutableListOf<Char>()
        val split = input.split("\n")

        split.forEachIndexed rucksackLoop@{ i,rucksack ->
            val firstLine = rucksack.split("\n")[i]
            val secondLine = rucksack.split("\n")[i+1]
            val thirdLine = rucksack.split("\n")[i+2]
            println(firstLine)
            firstLine.forEach { fChar ->
                for (sChar in secondLine) {
                    for(tChar in thirdLine) {
                        if (fChar == sChar && fChar == tChar) {
                            duplicateItems.add(fChar)
                            return@rucksackLoop
                        }
                    }
                }
            }
            if(i+3 == split.size) {
                return duplicateItems

            }
//            frontCompartment.forEach { frontChar ->
//                for (backChar in backCompartment) {
//                    if (backChar == frontChar) {
//                        duplicateItems.add(frontChar)
//                        return@rucksackLoop
//                    }
//                }
//            }
        }
        return duplicateItems
    }

    fun calculatePriorities(): Int {
        val items = getDuplicateItem()
        var prioritySum = 0
        items.forEach { item ->
            val ascii = item.toInt()
            if (item.isUpperCase()) {
                prioritySum += (ascii - 38)
            } else {
                prioritySum += (ascii- 96)
            }
        }
        return prioritySum
    }
}