//Правильная скобочная последовательность
import java.util.Stack;

public class skoboch {
    public static void main(String[] args) {

        String sequence = new java.util.Scanner(System.in).nextLine().trim();
        
        System.out.println(isBalanced(sequence));
    }

    private static String isBalanced(String sequence) {

        Stack<Character> stack = new Stack<>();
        
        for (char c : sequence.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 

            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return "no";
                }
            }
        }

        return stack.isEmpty() ? "yes" : "no";
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') || 
               (open == '[' && close == ']') || 
               (open == '{' && close == '}');
    }
}
