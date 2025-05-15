import java.util.*;

public class BranchOutput {

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

    static void collectSingleChildNodes(Node root, List<Integer> result) {
        if (root == null) return;
        boolean hasLeft = root.left != null;
        boolean hasRight = root.right != null;

        if ((hasLeft && !hasRight) || (!hasLeft && hasRight)) {
            result.add(root.val);
        }

        collectSingleChildNodes(root.left, result);
        collectSingleChildNodes(root.right, result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;

        while (true) {
            int val = scanner.nextInt();
            if (val == 0) break;
            root = insert(root, val);
        }

        List<Integer> oneChildNodes = new ArrayList<>();
        collectSingleChildNodes(root, oneChildNodes);
        Collections.sort(oneChildNodes);

        for (int val : oneChildNodes) {
            System.out.println(val);
        }
    }
}
