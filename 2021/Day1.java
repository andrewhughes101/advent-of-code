import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day1 {
    private static Integer previousWindow;
    private static Integer increases;

    public static void main(String[] args) throws IOException {
        increases = 0;
        List<String> depthList = Files.readAllLines(Paths.get("Day1Input.txt"));
        List<Integer> summedDepths = new ArrayList<Integer>();
        for (int i = 0; i < (depthList.size() - 2); i++) {
            summedDepths.add(Integer.parseInt(depthList.get(i)) + Integer.parseInt(depthList.get(i + 1))
                    + Integer.parseInt(depthList.get(i + 2)));
        }
        for (Integer currentWindow : summedDepths) {
            if (previousWindow != null) {
                if (currentWindow > previousWindow) {
                    increases++;
                }
            }
            previousWindow = currentWindow;
        }
        System.out.println("Total increases: " + increases);
    }
}

// Part 1
/*
 * import java.io.IOException;
 * import java.nio.file.Files;
 * import java.nio.file.Paths;
 * import java.util.List;
 * import java.util.stream.Stream;
 * 
 * public class Day1 {
 * private static Integer previousDepth;
 * private static Integer increases;
 * 
 * public static void main(String[] args) throws IOException {
 * increases = 0;
 * List<String> depthList = Files.readAllLines(Paths.get("Day1Input.txt"));
 * Stream<String>depthStream = depthList.stream();
 * depthStream.mapToInt(depth -> Integer.parseInt(depth)).forEach(depth -> {
 * if(previousDepth != null) {
 * if(depth > previousDepth) {
 * increases++;
 * }
 * }
 * previousDepth = depth;
 * });
 * System.out.println("Total increases: " + increases);
 * }
 * }
 */
