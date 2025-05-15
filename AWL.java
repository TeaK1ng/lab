import java.util.*;

public class AWL {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) root.left = insert(root.left, val);
        else if (val > root.val) root.right = insert(root.right, val);
        return root;
    }

    static class BalanceInfo {
        boolean balanced;
        int height;

        BalanceInfo(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    static BalanceInfo checkBalance(Node root) {
        if (root == null) return new BalanceInfo(true, 0);

        BalanceInfo left = checkBalance(root.left);
        BalanceInfo right = checkBalance(root.right);

        boolean balanced = left.balanced && right.balanced &&
                           Math.abs(left.height - right.height) <= 1;
        int height = 1 + Math.max(left.height, right.height);

        return new BalanceInfo(balanced, height);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;

        while (true) {
            int val = scanner.nextInt();
            if (val == 0) break;
            root = insert(root, val);
        }

        boolean isBalanced = checkBalance(root).balanced;
        System.out.println(isBalanced ? "YES" : "NO");
    }
}