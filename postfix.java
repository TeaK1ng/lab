//Постфиксная запись
import java.util.*;

public class postfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        scanner.close();

        System.out.println(evaluatePostfix(input));
    }

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split("\s+");

        for (String token : tokens) {
            if (token.matches("-?\\d+")) { // Число
                stack.push(Integer.parseInt(token));
            } else { // Оператор
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    default: throw new IllegalArgumentException("Неверный оператор: " + token);
                }
            }
        }
        return stack.pop();
    }
}