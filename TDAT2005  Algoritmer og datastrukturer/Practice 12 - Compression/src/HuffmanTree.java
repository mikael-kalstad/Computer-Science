import java.util.Stack;

public class BinaryTree {
    private Node root = null;

    public void add(int value, Object data) {
        root = addRec(root, value, data);
    }

    private Node addRec(Node curr, int value, Object data) {
        // We have reached a leaf node, insert node in that position
        if (curr == null) return new Node(value, data);

        // New node value is lower than current node's value
        if (value < curr.getValue())
            curr.setLeft(addRec(curr.getLeft(), value, data));
        // New node value is higher than current node's value
        else if (value > curr.getValue())
            curr.setRight(addRec(curr.getRight(), value, data));
        // The value already exists
        else return curr;

        return curr;
    }

    // Merge binary tree with a different tree
    public BinaryTree merge(BinaryTree tree) {
        return new BinaryTree();
    }

    // Print the binary tree in console
    public void printTree() {
        String msg = "";

        // Queue for all nodes that should be printed
        Stack<Node> queue = new Stack();
        queue.add(root);

        // Add root value to msg
        msg += root.getValue() + "\n";

        while (!queue.isEmpty()) {
            // Get first node from queue
            Node n = queue.pop();

            // If node is not defined, go to next in queue
            if (n == null) continue;

            if (n.getLeft() != null) {
                msg += n.getLeft().getValue();
                queue.add(n.getLeft());
            }
            if (n.getRight() != null) {
                msg += n.getRight().getValue();
                queue.add(n.getRight());
            }

            // Add line shift to indicate new level in tree
            msg += "\n";
        }

        System.out.println(msg);
    }

    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        b.add(7, "a");
        b.add(5, "u");
        b.add(4, "c");
        b.add(5, "r");

        b.printTree();

        /*System.out.println("Root: " + b.root);
        System.out.println("Left child 1: " + b.root.left);
        System.out.println("Right child 1: " + b.root.right);
        System.out.println("Left child 2: " + b.root.left.left);
        System.out.println("Right child 2: " + b.root.left.right);
        System.out.println("Left child 2: " + b.root.right.right);
        System.out.println("Right child 2: " + b.root.right.left);*/
    }
}

