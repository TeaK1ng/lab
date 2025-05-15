import java.util.*;

public class LeafOutput {

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

    static void collectLeaves(Node root, List<Integer> leaves) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        } else {
            collectLeaves(root.left, leaves);
            collectLeaves(root.right, leaves);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;

        while (true) {
            int val = scanner.nextInt();
            if (val == 0) break;
            root = insert(root, val);
        }

        List<Integer> leaves = new ArrayList<>();
        collectLeaves(root, leaves);
        Collections.sort(leaves);

        for (int leaf : leaves) {
            System.out.println(leaf);
        }
    }
}
