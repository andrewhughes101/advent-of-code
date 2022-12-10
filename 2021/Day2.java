import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day2 {
    public static void main(String[] args) throws IOException {
        List<String> commandList = Files.readAllLines(Paths.get("Day2Input.txt"));
        int x = 0;
        int y = 0;
        int aim = 0;
        for (String command : commandList) {
            int amount = Character.getNumericValue(command.charAt((command.length() - 1)));
            if (command.charAt(0) == 'f') {
                x += amount;
                y += (aim * amount);
            } else if (command.charAt(0) == 'd') {
                aim += amount;
            } else if (command.charAt(0) == 'u') {
                aim -= amount;
            }
        }
        System.out.println("X mulitplied by Y: " + (x * y));
    }
}

// forward -> adds to x (also y increased by aim*)
// down -> adds to aim
// up -> removes from aim

// Part 1
/*
 * import java.io.IOException;
 * import java.nio.file.Files;
 * import java.nio.file.Paths;
 * import java.util.List;
 * 
 * public class Day2 {
 * public static void main(String[] args) throws IOException {
 * List<String> commandList = Files.readAllLines(Paths.get("Day2Input.txt"));
 * Integer x = 0; //horizontal
 * Integer y = 0; //vertical/depth
 * for(String command : commandList) {
 * Integer amount =
 * Character.getNumericValue(command.charAt((command.length()-1)));
 * if(command.charAt(0) == 'f') {
 * x+=amount;
 * } else if(command.charAt(0) == 'd') {
 * y+=amount;
 * } else if(command.charAt(0) == 'u') {
 * y-=amount;
 * }
 * }
 * System.out.println("X mulitplied by Y: " + (x*y));
 * }
 * }
 * 
 * //forward -> adds to x
 * //down -> adds to y
 * //up -> removes from y
 * 
 */
