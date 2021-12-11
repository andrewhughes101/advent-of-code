import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class Day7 {
    public static void main(String[] args) throws IOException {
        String allPositionInput = Files.readAllLines(Paths.get("Day7Input.txt")).get(0);
        ArrayList<Integer> allPositions = new ArrayList<Integer>();
        ArrayList<Integer> distanceSums = new ArrayList<Integer>();
        Stream<String> positionStream = Arrays.stream(allPositionInput.split(","));
        positionStream.mapToInt(pos -> Integer.parseInt(pos)).forEach(pos -> {
            allPositions.add(pos);
        });
        for (int pos = 0; pos <= Collections.max(allPositions); pos++) {
            int sum = 0;
            for (int i = 0; i < allPositions.size(); i++) {
                int n = Math.abs(allPositions.get(i) - pos);
                sum += (n * (n + 1)) / 2;
            }
            distanceSums.add(sum);
        }
        ;
        System.out.println("Optimal position: " + distanceSums.indexOf(Collections.min(distanceSums)));
        System.out.println("Fuel needed: " + Collections.min(distanceSums));
    }
}
