import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Day6 {
    public static void main(String[] args) throws IOException {
        String fishInput = Files.readAllLines(Paths.get("Day6Input.txt")).get(0);
        Stream<String> fishStream = Arrays.stream(fishInput.split(","));
        ArrayList<Long> schoolSixes = new ArrayList<Long>();
        ArrayList<Long> schoolEights = new ArrayList<Long>();
        for (int i = 0; i < 10; i++) {
            if (i < 8) {
                schoolSixes.add((long) 0);
            }
            schoolEights.add((long) 0);
        }
        fishStream.mapToInt(fish -> Integer.parseInt(fish)).forEach(fish -> {
            schoolSixes.set(fish, schoolSixes.get(fish) + 1);
        });
        for (int day = 0; day < 256; day++) {
            schoolEights.set(9, (schoolEights.get(9) + schoolSixes.get(0) + schoolEights.get(0)));
            schoolSixes.set(7, (schoolSixes.get(7) + schoolSixes.get(0) + schoolEights.get(0)));
            for (int i = 0; i < 9; i++) {
                schoolEights.set(i, schoolEights.get(i + 1));
            }
            schoolEights.set(9, (long) 0); // Clear extra index after everythings been shifted
            for (int i = 0; i < 7; i++) {
                schoolSixes.set(i, schoolSixes.get(i + 1));
            }
            schoolSixes.set(7, (long) 0); // Clear extra index after everythings been shifted
        }
        long totalfish = schoolSixes.stream().mapToLong(Long::longValue).sum()
                + schoolEights.stream().mapToLong(Long::longValue).sum();
        System.out.println("Total fish: " + totalfish);
    }
}
