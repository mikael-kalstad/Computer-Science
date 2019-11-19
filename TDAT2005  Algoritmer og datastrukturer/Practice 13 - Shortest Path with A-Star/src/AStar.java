import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class AStar {
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
        Node[] nodes = graph.getNodes();
        int[] distanceToStart = new int[nodes.length];
        int[] actualDistance = new int[nodes.length];
        Node[] previous_nodes = new Node[nodes.length];

        // The distances from start to all other nodes are unknown, therefore infinity
        Arrays.fill(distanceToStart, Integer.MAX_VALUE);

        // Fill array with actual distance using the haversine formula
        /*long startTime2 = System.currentTimeMillis();
        double[] dataEnd = nodes[end].getData();
        for (int i = 0; i < actualDistance.length; i++) {
            double[] data = nodes[i].getData();
            actualDistance[i] = haversine(data[0], data[1], dataEnd[0], dataEnd[1]);
        }
        long totalTime2 = System.currentTimeMillis() - startTime2;*/

        // Distance to start node is always 0
        distanceToStart[start] = 0;

        // Create comparator for priority queue
        DistanceAStarComparator comparator = new DistanceAStarComparator(distanceToStart, actualDistance);

        // Create priority queue, node with lowest distance to start is always first in queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(graph.getNumOfNodes(), comparator);

        // Add start index to queue
        pq.add(start);

        // Temp variables used in for loop
        int distance;
        int nextIndex;
        int nodes_processed = 0;
        double[] dataEnd = nodes[end].getData();

        // Find shortest path until the end node is first in the queue
        while (!pq.isEmpty()) {
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

                    // Find actual distance using haversine
                    double[] data = nodes[nextIndex].getData();
                    actualDistance[nextIndex] = haversine(data[0], data[1], dataEnd[0], dataEnd[1]);

                    // Add to queue
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
        while (curr != null) {
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
        System.out.println("\nA* algorithm: " + "\nNodes processed: " + nodes_processed + "\nTotal driving time: " + totalDistance + "\nTime used: " + totalTime / 1000.0 + "s");
        //System.out.println("Time used finding actual distance: " + totalTime2/1000.0 + "s");

        // Convert arrayList to array and return it
        return path.toArray(new Node[0]);
    }

    private static int haversine(double b1, double l1, double b2, double l2) {
        final int EARTH_RADIUS = 6371;

        b1 = toRad(b1);
        b2 = toRad(b2);
        l1 = toRad(l1);
        l2 = toRad(l2);

        return (int) (2*EARTH_RADIUS*Math.asin(
                    Math.sqrt(
                        Math.pow(Math.sin((b1-b2)/2), 2) +
                        Math.cos(b1)*Math.cos(b2)*
                        Math.pow(Math.sin((l1-l2)/2), 2)
                    )
                ));
    }

    private static double toRad(double deg) {
        return deg*(Math.PI/180);
    }
}
