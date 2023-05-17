class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insertNode(current.left, value);
        } else if (value > current.value) {
            current.right = insertNode(current.right, value);
        }

        return current;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Constructing the binary search tree based on the provided diagram
        bst.insert(45);
        bst.insert(27);
        bst.insert(66);
        bst.insert(13);
        bst.insert(39);
        bst.insert(25);
        bst.insert(18);
        bst.insert(30);
        bst.insert(42);
        bst.insert(28);
        bst.insert(33);
        bst.insert(41);
        bst.insert(82);
        bst.insert(80);

        // Perform any desired operations on the binary search tree
        // ...
    }
}
