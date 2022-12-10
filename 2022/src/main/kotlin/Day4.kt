import org.gradle.internal.impldep.org.apache.commons.io.IOUtils
import java.nio.charset.StandardCharsets

class Day4 {
    private fun getInput(): String {
        return IOUtils.toString(Day4::class.java.classLoader.getResourceAsStream("Day4.txt"), StandardCharsets.UTF_8)
    }
}