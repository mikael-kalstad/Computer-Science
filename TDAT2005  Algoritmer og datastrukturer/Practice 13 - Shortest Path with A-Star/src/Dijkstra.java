import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.StreamSupport;

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
    public static Node[] shortestPath(Graph graph, int start, int end) {
        long startTime = System.currentTimeMillis();

        // -- ARRAYS FOR SHORTEST DISTANCE TABLE --
        // Node - distance -  previous node
        //  A   -    0     -  null
        //  B   -    6     -  A
        //  C   - INFINITY -  null
        Node[] nodes = graph.getNodes();
        int[] distanceToStart = new int[nodes.length];
        Node[] previous_nodes = new Node[nodes.length];

        // The distances from start to all other nodes are unknown, therefore infinity
        Arrays.fill(distanceToStart, Integer.MAX_VALUE);

        // Distance to start node is always 0
        distanceToStart[start] = 0;

        // Create comparator for priority queue
        DistanceComparator comparator = new DistanceComparator(distanceToStart);

        // Create priority queue, node with lowest distance to start is always first in queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(graph.getNumOfNodes(), comparator);

        // Add start index to queue
        pq.add(start);

        // Temp variables used in for loop
        int distance;
        int nextIndex;
        int nodes_processed = 0;

        // Find shortest path until the end node is first in the queue
        while(!pq.isEmpty()) {
            // Get first index in priority queue
            int nodeIndex = pq.remove();

            // Go out of loop if we have reached the end target node
            if (nodeIndex == end) break;

            // Get node with current index
            Node n = nodes[nodeIndex];

            // Go through all the edges from Node n
            for (Edge e : n.getEdges()) {
                // Distance is distance from n to start + distance from n to next node
                distance = e.getDistance() + distanceToStart[n.getIndex()];
                nextIndex = e.getTo().getIndex();

                // Set new distance if it is shorter than current value
                if (distance < distanceToStart[nextIndex]) {
                    distanceToStart[nextIndex] = distance;

                    // Update previous node array
                    previous_nodes[nextIndex] = n;

                    pq.add(nextIndex);
                }
            }

            // Increase run amount
            nodes_processed++;
        }

        // Store path from start --> end
        ArrayList<Node> path = new ArrayList<>();

        // Start looking from end target node
        Node curr = nodes[end];

        // Check until start node is found
        while(curr != null) {
            // Add current node to path
            path.add(curr);

            // Update current node to next in array
            curr = previous_nodes[curr.getIndex()];

            //System.out.println("Node: " + curr.getIndex() + ", distance: " + distanceToStart[curr.getIndex()] + ", next node: " + previous_nodes[curr.getIndex()].getIndex());
        }

        // Add start node as last in path
        //path.add(nodes[start]);

        // Total distance from start --> end
        int totalDistance = distanceToStart[end];

        // Reverse list to get path from start --> end
        Collections.reverse(path);

        long totalTime = System.currentTimeMillis() - startTime;
        String drivingTime = String.format("%02d:%02d:%02d",(totalDistance/100/3600), ((totalDistance/100 % 3600)/60), (totalDistance/100 % 60));
        System.out.println("Dijkstras algorithm: " + "\nNodes processed: " + nodes_processed + "\nTotal driving time: " + drivingTime + "\nTime used: " + totalTime/1000.0 + "s");

        // Convert arrayList to array and return it
        return path.toArray(new Node[0]);
    }
}
