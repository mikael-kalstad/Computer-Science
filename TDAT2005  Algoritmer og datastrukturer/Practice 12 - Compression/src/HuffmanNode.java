public class Node {
    private int value;
    private byte data;
    private Node left = null;
    private Node right = null;

    
    public Node(int value, byte data, boolean isLeaf) {
        this.value = value;

        // Only set data if the node is a leaf node
        if (isLeaf) this.data = data;
    }

    public int getValue() {
        return value;
    }

    public byte getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * Merge nodes with each other
     * Value of new node is the combined value of node1 and node2
     * @param n1
     * @param n2
     * @return New node
     */
    public static Node merge(Node n1, Node n2) {
        Node n = new Node(n1.getValue() + n2.getValue(), (byte)0, false);

        /*
          Set children position based on highest value
          Highest value == RIGHT
          Lowest value == LEFT
         */
        if (n1.getValue() < n2.getValue()) {
            n.setRight(n1);
            n.setRight(n2);
        } else {
            n.setRight(n2);
            n.setRight(n1);
        }

        return n;
    }
}