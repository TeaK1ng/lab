//Гоблины и шаманы
import java.util.*;

public class goblandsham {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Integer> queue = new LinkedList<>();
        
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String command = scanner.next();
            if (command.equals("+")) {
                int goblin = scanner.nextInt();
                queue.addLast(goblin);
            } else if (command.equals("*")) {
                int goblin = scanner.nextInt();
                queue.add(queue.size() / 2, goblin);
            } else if (command.equals("-")) {
                output.append(queue.pollFirst()).append("\n");
            }
        }
        scanner.close();
        
        System.out.print(output);
    }
}
