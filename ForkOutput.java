import java.util.*;

public class ForkOutput {

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

    static void collectForks(Node root, List<Integer> forks) {
        if (root == null) return;
        if (root.left != null && root.right != null) {
            forks.add(root.val);
        }
        collectForks(root.left, forks);
        collectForks(root.right, forks);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;

        while (true) {
            int val = scanner.nextInt();
            if (val == 0) break;
            root = insert(root, val);
        }

        List<Integer> forks = new ArrayList<>();
        collectForks(root, forks);
        Collections.sort(forks);

        for (int fork : forks) {
            System.out.println(fork);
        }
    }
}
