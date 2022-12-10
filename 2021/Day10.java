import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Comparator;

public class Day10 {
    private static int score = 0;
    private static boolean incomplete;

    public static void main(String[] args) throws IOException {
        List<String> inputList = Files.readAllLines(Paths.get("Day10Input.txt"));
        List<Long> completes = new ArrayList<Long>();
        inputList.forEach(line -> {
            Stack<Character> charStack = new Stack<Character>();
            incomplete = true;
            for (int i = 0; i < line.length(); i++) {
                switch (line.charAt(i)) {
                    case '(', '[', '{', '<' -> {
                        charStack.push(line.charAt(i));
                        break;
                    }
                    case ')' -> {
                        Character open = charStack.pop();
                        if (open != '(') {
                            score += 3;
                            incomplete = false;
                            break;
                        }
                    }
                    case ']' -> {
                        Character open = charStack.pop();
                        if (open != '[') {
                            score += 57;
                            incomplete = false;
                            break;
                        }
                    }
                    case '}' -> {
                        Character open = charStack.pop();
                        if (open != '{') {
                            score += 1197;
                            incomplete = false;
                            break;
                        }
                    }
                    case '>' -> {
                        Character open = charStack.pop();
                        if (open != '<') {
                            score += 25137;
                            incomplete = false;
                            break;
                        }
                    }
                }
            }
            if (incomplete) {
                Long completeScore = 0l;
                while (charStack.size() > 0) {
                    Character c = charStack.pop();
                    completeScore *= 5;
                    switch (c) {
                        case '(' -> {
                            completeScore += 1;
                        }
                        case '[' -> {
                            completeScore += 2;
                        }
                        case '{' -> {
                            completeScore += 3;
                        }
                        case '<' -> {
                            completeScore += 4;
                        }
                    }
                }
                completes.add(completeScore);
            }
        });
        completes.sort(Comparator.naturalOrder());
        System.out.println(score);
        System.out.println(completes.get(completes.size() / 2));
    }
}
