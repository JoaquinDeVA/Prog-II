public class BinaryTree {

    private static class Node {
        Node left;
        Node right;
        int data;

        Node(int newData) {
            left = null;
            right = null;
            data = newData;
        }
    }

    private Node root;

    /**
     * Creates an empty binary tree -- a null root pointer.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Returns true if the given target is in the binary tree. Uses a recursive helper.
     */
    public boolean lookup(int data) {
        return lookup(root, data);
    }

    private boolean lookup(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (data == node.data) {
            return true;
        } else if (data < node.data) {
            return lookup(node.left, data);
        } else {
            return lookup(node.right, data);
        }
    }

    /**
     * Inserts the given data into the binary tree. Uses a recursive helper.
     */
    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return size(node.left) + 1 + size(node.right);
        }
    }

    /**
     * Returns the max root-to-leaf depth of the tree.
     */
    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
            return Math.max(lDepth, rDepth) + 1;
        }
    }

    /**
     * Returns the min value in a non-empty binary search tree.
     */
    public int minValue() {
        return minValue(root);
    }

    private int minValue(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    @Override
    public String toString() {
        return aStringBuilder(root).toString();
    }

    private StringBuilder aStringBuilder(Node node) {
        StringBuilder sb = new StringBuilder();
        if (node == null) {
            return sb;
        }
        return aStringBuilder(node.left)
                .append(" ").append(node.data).append(" ")
                .append(aStringBuilder(node.right));
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof BinaryTree)) {
            return false;
        }
        return sameTree(root, ((BinaryTree) other).root);
    }

    private boolean sameTree(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        } else if (a != null && b != null) {
            return a.data == b.data &&
                   sameTree(a.left, b.left) &&
                   sameTree(a.right, b.right);
        } else {
            return false;
        }
    }

    public void printPostorder() {
        printPostorder(root);
        System.out.println();
    }

    private void printPostorder(Node node) {
        if (node == null) return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void mostrarFuncionamientoArbolesBinarios() {
        BinaryTree bt = new BinaryTree();
        bt.insert(2);
        bt.insert(1);
        bt.insert(3);
        bt.insert(8);
        bt.insert(5);
        bt.insert(2);
        System.out.println(bt);
        bt.printPostorder();
    }

    public static void main(String[] args) {
        mostrarFuncionamientoArbolesBinarios();
    }
}
