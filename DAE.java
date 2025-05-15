import java.util.Scanner;

public class DAE {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static int insertAndPrintDepth(Node root, int val, int depth) {
        if (val < root.val) {
            if (root.left == null) {
                root.left = new Node(val);
                return depth + 1;
            } else {
                return insertAndPrintDepth(root.left, val, depth + 1);
            }
        } else if (val > root.val) {
            if (root.right == null) {
                root.right = new Node(val);
                return depth + 1;
            } else {
                return insertAndPrintDepth(root.right, val, depth + 1);
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;

        while (true) {
            int val = scanner.nextInt();
            if (val == 0) break;

            if (root == null) {
                root = new Node(val);
                System.out.print("1 ");
            } else {
                int depth = insertAndPrintDepth(root, val, 1);
                if (depth != -1) {
                    System.out.print(depth + " ");
                }
            }
        }
    }
}
