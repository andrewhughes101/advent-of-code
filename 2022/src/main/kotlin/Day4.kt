import org.gradle.internal.impldep.org.apache.commons.io.IOUtils
import java.nio.charset.StandardCharsets

class Day4 {

    fun getNumberOfOverlaps(input: String): Int {
        val lines = input.split("\n")
        var overlaps = 0
        lines.forEach {
            val pairs = it.split(",")
            val firstX = pairs[0].split("-")[0].toInt()
            val firstY = pairs[0].split("-")[1].toInt()
            val secondX = pairs[1].split("-")[0].toInt()
            val secondY = pairs[1].split("-")[1].toInt()
            val firstRange = firstY - firstX
            val secondRange = secondY - secondX
            if (secondRange >= firstRange && (firstX >= secondX && secondY >= firstY)) {
                overlaps += 1
            } else if (firstRange >= secondRange && (secondX >= firstX && firstY >= secondY)) {
                overlaps += 1
            }
        }
        return overlaps
    }

    private fun constructList(input: String): MutableList<MutableList<Int>> {
        var space = mutableListOf<MutableList<Int>>()
        var nums = mutableListOf<Int>()
        var totalNums = 0
        val lines = input.split("\n")
        lines.forEach {
            val pairs = it.split(",")
            pairs.forEach {
                val num = it.split("-")
                nums.add(num[0].toInt())
                nums.add(num[1].toInt())
                totalNums += 2
            }
        } //collapse below into the above loop
        val max = nums.maxOrNull()!!
        for (i in 0..totalNums) {
            val tmpList = mutableListOf<Int>()
            for (j in 0..max) {
                tmpList.add(j, 0)
            }
            space.add(i, tmpList)
        }
        return space
        // redo to construct with locations, also ranges shouldnt be combining over each one (they should be independent)
    }

    fun getTotalOverlaps(input: String): Int {
        // rewrite to just go over the spaces in turn with each range
        var overlaps = 0

        // make a array and add to it for the range of each pair, then check every item in array between them
        var space = constructList(input)
        println(space)
        val lines = input.split("\n")
        lines.forEach {
            val pairs = it.split(",")
            val firstX = pairs[0].split("-")[0].toInt()
            val firstY = pairs[0].split("-")[1].toInt()
            val secondX = pairs[1].split("-")[0].toInt()
            val secondY = pairs[1].split("-")[1].toInt()

            // loop over each line in array which represents each elfs coverage
            for (i in 0..space.size-1) {
                // Check if for all nums in current range do they ovberlap the nums in the list
            }
        }
        return overlaps
    }
}

// Can tcombine them, write them to different lines