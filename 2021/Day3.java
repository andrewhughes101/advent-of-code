import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Day3 {
    public static void main(String[] args) throws IOException {
        List<String> diagnosticList = Files.readAllLines(Paths.get("Day3Input.txt"));

        List<String> oxygenSet = new ArrayList<String>();
        oxygenSet.addAll(diagnosticList);
        List<String> co2Set = new ArrayList<String>();
        co2Set.addAll(diagnosticList);

        List<String> onesSet = new ArrayList<String>();
        List<String> zerosSet = new ArrayList<String>();

        for (int i = 0; i < diagnosticList.get(0).length(); i++) {
            for (String binaryStr : oxygenSet) {
                if (Character.getNumericValue(binaryStr.charAt(i)) == 1) {
                    onesSet.add(binaryStr);
                } else {
                    zerosSet.add(binaryStr);
                }
            }
            if (oxygenSet.size() > 1) {
                if (onesSet.size() - zerosSet.size() > -1) {
                    // 1s most common
                    oxygenSet.removeAll(new HashSet<String>(zerosSet));
                } else {
                    // 0s most common
                    oxygenSet.removeAll(new HashSet<String>(onesSet));
                }
            }
            onesSet.clear();
            zerosSet.clear();
            for (String binaryStr : co2Set) {
                if (Character.getNumericValue(binaryStr.charAt(i)) == 1) {
                    onesSet.add(binaryStr);
                } else {
                    zerosSet.add(binaryStr);
                }
            }
            if (co2Set.size() > 1) {
                if (onesSet.size() - zerosSet.size() > -1) {
                    // 1s most common
                    co2Set.removeAll(new HashSet<String>(onesSet));
                } else {
                    // 0s most common
                    co2Set.removeAll(new HashSet<String>(zerosSet));
                }
            }
            onesSet.clear();
            zerosSet.clear();
        }

        Integer oxygen = Integer.parseInt(oxygenSet.get(0), 2);
        Integer co2 = Integer.parseInt(co2Set.get(0), 2);
        System.out.println("Life support rating: " + (oxygen * co2));
    }
}

// Part 1
/*
 * import java.io.IOException;
 * import java.nio.file.Files;
 * import java.nio.file.Paths;
 * import java.util.List;
 * 
 * public class Day3 {
 * public static void main(String[] args) throws IOException {
 * List<String> diagnosticList = Files.readAllLines(Paths.get("Day3Input.txt"));
 * //go through each bit, if 0 do -1 from counter, if 1 do +1, total neg more
 * 0s, total pos more 1s
 * String gammaRate = "";
 * Integer counter = 0;
 * for(int i=0; i<diagnosticList.get(0).length(); i++) {
 * for(String binaryStr : diagnosticList) {
 * if(Character.getNumericValue(binaryStr.charAt(i)) == 1) {
 * counter++;
 * } else {
 * counter--;
 * }
 * }
 * if(counter > 0) {
 * gammaRate+=1;
 * } else {
 * gammaRate+=0;
 * }
 * counter = 0;
 * }
 * 
 * String epsilonRate = gammaRate;
 * epsilonRate = epsilonRate.replaceAll("0", "x");
 * epsilonRate = epsilonRate.replaceAll("1", "0");
 * epsilonRate = epsilonRate.replaceAll("x", "1");
 * 
 * Integer gam = Integer.parseInt(gammaRate,2);
 * Integer eps = Integer.parseInt(epsilonRate,2);
 * System.out.println("result: " + (eps*gam));
 * }
 * }
 */
