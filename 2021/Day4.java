import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Day4 {
    private static int lastCalled;
    private static int winningBoard;
    private static int boardSum = 0;
    private static boolean winner = false;
    private static ArrayList<Integer> winners = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        List<String> bingoInput = Files.readAllLines(Paths.get("Day4Input.txt"));
        List<ArrayList<ArrayList<String>>> bingoBoards = new ArrayList<ArrayList<ArrayList<String>>>();
        String calledNumbers = bingoInput.get(0);

        // Arrange Bingo Boards
        for (int i = 1; i < bingoInput.size(); i++) {
            if (i % 6 == 0) {
                ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>();
                for (int j = 4; j >= 0; j--) {
                    Stream<String> rowStream = Arrays
                            .stream(bingoInput.get(i - j).trim().replaceAll("  ", ",").replaceAll(" ", ",").split(","));
                    ArrayList<String> currentBoard = new ArrayList<String>();
                    rowStream.forEach(num -> {
                        currentBoard.add(num);
                    });
                    board.add(currentBoard);
                }
                bingoBoards.add(board);
            }
        }

        // Go through each and replace number with something

        Stream<String> calledStream = Arrays.stream(calledNumbers.split(","));
        calledStream.forEach(num -> {
            // if(!winner) {
            callNumber: for (int k = 0; k < bingoBoards.size(); k++) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (num.equals(bingoBoards.get(k).get(i).get(j))) {
                            if (!winners.contains(k)) {
                                lastCalled = Integer.parseInt(bingoBoards.get(k).get(i).get(j));
                                bingoBoards.get(k).get(i).set(j, "X");
                                // check winner
                                // column would be all i 1-5 j static
                                // row would be j 1-5 i static
                                if ("X".equals(bingoBoards.get(k).get(i).get(0))
                                        && "X".equals(bingoBoards.get(k).get(i).get(1))
                                        && "X".equals(bingoBoards.get(k).get(i).get(2))
                                        && "X".equals(bingoBoards.get(k).get(i).get(3))
                                        && "X".equals(bingoBoards.get(k).get(i).get(4))) {
                                    System.out.println("Winner Board: " + (k + 1));
                                    System.out.println(bingoBoards.get(k));
                                    winningBoard = k;
                                    winner = true;
                                    winners.add(k);
                                    // break callNumber;
                                }
                                if ("X".equals(bingoBoards.get(k).get(0).get(j))
                                        && "X".equals(bingoBoards.get(k).get(1).get(j))
                                        && "X".equals(bingoBoards.get(k).get(2).get(j))
                                        && "X".equals(bingoBoards.get(k).get(3).get(j))
                                        && "X".equals(bingoBoards.get(k).get(4).get(j))) {
                                    System.out.println("Winner Board: " + (k + 1));
                                    System.out.println(bingoBoards.get(k));
                                    winningBoard = k;
                                    winner = true;
                                    winners.add(k);
                                    // break callNumber;
                                }
                            }
                        }
                    }
                }
            }
            // }
        });
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!bingoBoards.get(winningBoard).get(i).get(j).equals("X")) {
                    boardSum += Integer.parseInt(bingoBoards.get(winningBoard).get(i).get(j));
                }
            }
        }
        System.out.println(lastCalled);
        System.out.println("Score is: " + boardSum * lastCalled);
    }
}
