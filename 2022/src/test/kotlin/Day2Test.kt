import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2Test {

    private val testDay2: Day2 = Day2()

    @Test
    fun test() {
        assertEquals(15702, testDay2.playAllRoundsPartTwo())
    }
}