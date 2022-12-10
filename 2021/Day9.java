import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day9 {
    public static void main(String[] args) throws IOException {
        List<String> inputList = Files.readAllLines(Paths.get("Day9Input.txt"));
        List<ArrayList<Integer>> heightMap = new ArrayList<ArrayList<Integer>>();
        for(int j=0; j<inputList.size(); j++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            String[] nums = inputList.get(j).split("");
            for(int i=0; i<nums.length; i++) {
                row.add(Integer.parseInt(nums[i]));
            }
            heightMap.add(row); 
        }
        int totalRiskLevel = 0;
        for(int i = 0; i < heightMap.size(); i++) {
            for(int j=0; j<heightMap.get(0).size(); j++) {
                // Is it a low point?
                List<Integer> adjacent = new ArrayList<Integer>();
                if((i-1) >=0) { // above
                    adjacent.add(heightMap.get(i-1).get(j));
                }
                if((i+1) < heightMap.size()) { // below
                    adjacent.add(heightMap.get(i+1).get(j));
                }
                if((j-1) >=0) { // left
                    adjacent.add(heightMap.get(i).get(j-1));
                }
                if((j+1) < heightMap.get(0).size()) { // right
                    adjacent.add(heightMap.get(i).get(j+1));
                }
                int current = heightMap.get(i).get(j);
                int[] adj = adjacent.stream().mapToInt(Integer::intValue).toArray();
                if(Arrays.stream(adj).allMatch(x -> x > current)) {
                    totalRiskLevel += (current+1);
                }
            }
        }
        System.out.println(totalRiskLevel);
    }
}

// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// public class Day9 {
//     public static void main(String[] args) throws IOException {
//         List<String> inputList = Files.readAllLines(Paths.get("Day9Input.txt"));
//         List<ArrayList<Integer>> heightMap = new ArrayList<ArrayList<Integer>>();
//         for(int j=0; j<inputList.size(); j++) {
//             ArrayList<Integer> row = new ArrayList<Integer>();
//             String[] nums = inputList.get(j).split("");
//             for(int i=0; i<nums.length; i++) {
//                 row.add(Integer.parseInt(nums[i]));
//             }
//             heightMap.add(row); 
//         }
//         int totalRiskLevel = 0;
//         for(int i = 0; i < heightMap.size(); i++) {
//             for(int j=0; j<heightMap.get(0).size(); j++) {
//                 // Is it a low point?
//                 List<Integer> adjacent = new ArrayList<Integer>();
//                 if((i-1) >=0) { // above
//                     adjacent.add(heightMap.get(i-1).get(j));
//                 }
//                 if((i+1) < heightMap.size()) { // below
//                     adjacent.add(heightMap.get(i+1).get(j));
//                 }
//                 if((j-1) >=0) { // left
//                     adjacent.add(heightMap.get(i).get(j-1));
//                 }
//                 if((j+1) < heightMap.get(0).size()) { // right
//                     adjacent.add(heightMap.get(i).get(j+1));
//                 }
//                 int current = heightMap.get(i).get(j);
//                 int[] adj = adjacent.stream().mapToInt(Integer::intValue).toArray();
//                 if(Arrays.stream(adj).allMatch(x -> x > current)) {
//                     totalRiskLevel += (current+1);
//                 }
//             }
//         }
//         System.out.println(totalRiskLevel);
//     }
// }
