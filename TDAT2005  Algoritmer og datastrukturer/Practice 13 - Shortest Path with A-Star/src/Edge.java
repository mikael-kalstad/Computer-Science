public class Edge {
    private Node from;
    private Node to;
    private int distance;

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.distance = weight;
    }

    public Node getFrom() { return from; }
    public Node getTo() { return to; }
    public int getDistance() { return distance; }
}
