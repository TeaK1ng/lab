import java.util.Scanner;

public class SecondLargestInBST {

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
        else root.right = insert(root.right, val);
        return root;
    }

    static int findSecondLargest(Node root) {
        Node parent = null;
        Node current = root;

        while (current.right != null) {
            parent = current;
            current = current.right;
        }

        if (current.left != null) {
            current = current.left;
            while (current.right != null) {
                current = current.right;
            }
            return current.val;
        }

        return parent.val;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;

        while (true) {
            int val = scanner.nextInt();
            if (val == 0) break;
            root = insert(root, val);
        }

        System.out.println(findSecondLargest(root));
    }
}