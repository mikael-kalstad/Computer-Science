import java.util.ArrayList;

public class Node {
    private ArrayList<Edge> edges = new ArrayList<>();
    private double[] data = new double[2];
    private int index;

    public Node(double b, double l, int index) {
        data[0] = b;
        data[1] = l;

        // TODO: remove index, only for testing purposes
        this.index = index;
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public double[] getData() {
        return data;
    }

    public int getIndex() {
        return index;
    }
}
