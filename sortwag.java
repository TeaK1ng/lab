//Сортировка вагонов lite
import java.util.*;

public class sortwag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] train = new int[n];
        
        for (int i = 0; i < n; i++) {
            train[i] = scanner.nextInt();
        }
        scanner.close();
        
        System.out.println(canBeSorted(n, train) ? "YES" : "NO");
    }

    public static boolean canBeSorted(int n, int[] train) {
        Stack<Integer> stack = new Stack<>();
        int expected = 1;
        
        for (int wagon : train) {
            stack.push(wagon);
            
            while (!stack.isEmpty() && stack.peek() == expected) {
                stack.pop();
                expected++;
            }
        }
        
        return stack.isEmpty();
    }
}