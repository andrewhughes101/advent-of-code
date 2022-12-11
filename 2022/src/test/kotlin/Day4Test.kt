import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.gradle.internal.impldep.org.apache.commons.io.IOUtils
import java.nio.charset.StandardCharsets


class Day4Test {

    private val testDay4: Day4 = Day4()

    private var sampleInputFile = "Day4Sample.txt"
    private var inputFile = "Day4.txt";


    private fun getInput(input: String): String {
        return IOUtils.toString(Day4::class.java.classLoader.getResourceAsStream(input), StandardCharsets.UTF_8)
    }

    @Test
    fun testAgainstSample() {
        assertEquals(2, testDay4.getNumberOfOverlaps(getInput(sampleInputFile)))
    }

    @Test
    fun testPart2AgainstSample() {
        assertEquals(4, testDay4.getTotalOverlaps(getInput(sampleInputFile)))
    }

    @Test
    fun testAgainstInput() {
        assertEquals(453, testDay4.getNumberOfOverlaps(getInput(inputFile)))
    }
}