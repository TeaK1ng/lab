import java.util.Scanner;

class BST {
    static class Node {
        int value;
        Node left, right;
        
        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }
    
    private Node root;
    
    public void insert(int value) {
        root = insertRec(root, value);
    }
    
    private Node insertRec(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }
    
    public void inOrderTraversal() {
        inOrderRec(root);
    }
    
    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.value);
            inOrderRec(root.right);
        }
    }
}

public class bypass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST tree = new BST();
        
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num == 0) break;
            tree.insert(num);
        }
        
        tree.inOrderTraversal();
        scanner.close();
    }
}
