import java.util.*;

/**
 * Class for the Dijkstra algorithm for finding the shortest path between to points in a graph
 *
 * @author Mikael Kalstad
 * @version 1.0
 */
public class Dijkstra {
    /**
     * Find the shortest path between two nodes in a graph
     *
     * @param graph - Graph to search in
     * @param start - Node to start from
     * @param end - Target node for the end of the path
     * @return Array of the nodes in the path, in order from start to end
     */
    public static Node[] shortestPath(Graph graph, Node start, Node end) {
        // Get all nodes from graph, convert to arrayList
        ArrayList<Node> unvisited = new ArrayList<>(Arrays.asList(graph.getNodes()));

        // -- ARRAYS FOR SHORTEST DISTANCE TABLE --
        // Node - distance -  previous node
        //  A   -    0     -  null
        //  B   -    6     -  A
        //  C   - INFINITY -  null
        Node[] nodes = graph.getNodes();
        int[] distanceArr = new int[nodes.length];
        Node[] previous_nodes = new Node[nodes.length];

        // The distances from start to all other nodes are unknown, therefore infinity
        Arrays.fill(distanceArr, Integer.MAX_VALUE);

        // Find the index of the start node
        int startIndex = start.getIndex();

        // Distance to start node is always 0
        distanceArr[startIndex] = 0;

        // Temp variables used in for loop
        int weight;
        int index;
        int distance;
        int lowestWeight = Integer.MAX_VALUE;
        Node next = start;

        // Find shortest path until the end node is first in the queue
        while(!next.equals(end)) {
            // Go through all the edges from Node n
            for (Edge e : next.getEdges()) {
                // Set weight and node index
                weight = e.getWeight();
                index = e.getTo().getIndex();

                // Set new distance if it is shorter than current value
                if (weight < distanceArr[index]) {
                    distanceArr[index] = weight;

                    // Update previous node array
                    previous_nodes[index] = next;
                }
            }

            // Remove node from unvisited list
            unvisited.remove(next);

            // Find the unvisited node with the smallest known distance from the start node
            for (Node n : unvisited) {
                distance = distanceArr[n.getIndex()];
                if (distance < lowestWeight) {
                    lowestWeight = distance;
                    next = n;
                }
            }
            // Reset
            lowestWeight = Integer.MAX_VALUE;
        }
        System.out.println("OUT OF WHILE LOOP!");

        ArrayList<Node> path = new ArrayList<>();
        Node curr = end;
        while(!curr.equals(start)) {
            path.add(curr);
            curr = previous_nodes[curr.getIndex()];
        }
        path.add(start);

        // Reverse list to get path from start --> end
        Collections.reverse(path);

        // Convert arrayList to array and return it
        return path.toArray(new Node[0]);
    }
}
