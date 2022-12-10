import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Test {

    private val testDay1: Day1 = Day1()

    @Test
    fun testGetMostCalories() {
        val expected = 72240
        assertEquals(expected, testDay1.getMostCalories())
    }

    @Test
    fun testGetTopThree() {
        val expected = 210957
        assertEquals(expected, testDay1.getTopThreeCombinedCalories())
    }
}