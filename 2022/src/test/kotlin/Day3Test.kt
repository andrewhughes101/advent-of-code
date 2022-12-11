import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.gradle.internal.impldep.org.apache.commons.io.IOUtils
import java.nio.charset.StandardCharsets


class Day3Test {

    private val testDay3: Day3 = Day3()

    private var sampleInputFile = "Day3Sample.txt"
    private var inputFile = "Day3Sample.txt";


    private fun getInput(input: String): String {
        return IOUtils.toString(Day3::class.java.classLoader.getResourceAsStream(input), StandardCharsets.UTF_8)
    }

    @Test
    fun test() {
        assertEquals(157,testDay3.calculatePriorities(getInput(inputFile)))
    }

    @Test
    fun testAgainstSample() {
        assertEquals(70, testDay3.calculatePriorities(getInput(sampleInputFile)))
    }
}