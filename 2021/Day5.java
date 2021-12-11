import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day5 {
    private static int counter = 0;

    public static void main(String[] args) throws IOException {
        List<String> lineCoords = new ArrayList<String>();
        Set<String> coordsSet = new HashSet<String>();
        List<String> coordInput = Files.readAllLines(Paths.get("Day5Input.txt"));
        coordInput.forEach(line -> {
            int x1, x2, y1, y2;
            String start = line.split(" -> ")[0];
            String end = line.split(" -> ")[1];
            x1 = Integer.parseInt(start.split(",")[0]);
            x2 = Integer.parseInt(end.split(",")[0]);
            y1 = Integer.parseInt(start.split(",")[1]);
            y2 = Integer.parseInt(end.split(",")[1]);
            boolean diagonalLine = Math.abs(x1 - x2) == Math.abs(y1 - y2);
            if (x1 == x2 || y1 == y2 || diagonalLine) {
                if (diagonalLine) {
                    if ((x2 > x1 && y2 > y1) || (x1 > x2 && y1 > y2)) { // L lean diag 0,0 -> 3,3
                        if (x2 > x1 && y2 > y1) {
                            for (int i = 0; i <= (x2 - x1); i++) {
                                lineCoords.add((x1 + i) + "," + (y1 + i));
                                coordsSet.add((x1 + i) + "," + (y1 + i));
                            }
                        } else {
                            for (int i = 0; i <= (x1 - x2); i++) {
                                lineCoords.add((x1 - i) + "," + (y1 - i));
                                coordsSet.add((x1 - i) + "," + (y1 - i));
                            }
                        }
                    } else { // R lean diag 3,0 -> 0,3
                        if (x1 > x2) {
                            for (int i = 0; i <= (y2 - y1); i++) { // xdown, y up
                                lineCoords.add((x1 - i) + "," + (y1 + i));
                                coordsSet.add((x1 - i) + "," + (y1 + i));
                            }
                        } else {
                            for (int i = 0; i <= (x2 - x1); i++) { // xup y down
                                lineCoords.add((x1 + i) + "," + (y1 - i));
                                coordsSet.add((x1 + i) + "," + (y1 - i));
                            }
                        }
                    }
                } else { // horizontal and vertical lines
                    if (x1 > x2) {
                        int temp = x1;
                        x1 = x2;
                        x2 = temp;
                    }
                    if (y1 > y2) {
                        int temp = y1;
                        y1 = y2;
                        y2 = temp;
                    }
                    for (int i = x1; i <= x2; i++) {
                        for (int j = y1; j <= y2; j++) {
                            lineCoords.add(i + "," + j);
                            coordsSet.add(i + "," + j);
                        }
                    }
                }
            }
        });
        coordsSet.forEach(point -> {
            if (Collections.frequency(lineCoords, point) > 1) {
                counter++;
            }
        });
        System.out.println(counter);
    }
}
