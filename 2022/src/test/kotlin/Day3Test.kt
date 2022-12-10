import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {

    private val testDay3: Day3 = Day3()

    @Test
    fun test() {
        assertEquals(157,testDay3.calculatePriorities())
    }
}