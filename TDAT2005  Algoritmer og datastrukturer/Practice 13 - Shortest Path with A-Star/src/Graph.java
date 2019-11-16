import java.io.*;
import java.util.ArrayList;

public class Graph {
    private int num_of_nodes;
    private int num_of_edges;
    private Node[] nodes;

    public Graph(String filePathNodes, String filePathEdges) {
        readNodesFromFile(filePathNodes);
        readEdgesFromFile(filePathEdges);
    }

    public int getNumOfNodes() { return num_of_nodes; }
    public int getNumOfEdges() { return num_of_edges; }
    public Node[] getNodes() { return nodes; }

    private void readNodesFromFile(String filePath) {
        try {
            // Open buffer reader for file
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            String currLine;

            // Get number of nodes, always first line in file
            if ((currLine = br.readLine()) != null)
                num_of_nodes = Integer.parseInt(currLine.trim());

            // Check if there is any nodes in the file
            if (num_of_nodes == 0) return;

            // Initialize node array
            nodes = new Node[num_of_nodes];

            // Read the rest of the lines in the file
            while((currLine = br.readLine()) != null) {
                // Split current line with spaces
                String[] lineArr = currLine.split("\\s+");

                // Get node index
                int index = Integer.parseInt(lineArr[0]);

                // Check if node index is larger than array length
                if (index > nodes.length) break;

                // Create new node and put in node array
                nodes[index] = new Node(Double.parseDouble(lineArr[1]), Double.parseDouble(lineArr[2]), index);
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("Nodes file not found. Check if path to file is correct. Should be an absolute path, not relative!");
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readEdgesFromFile(String filePath) {
        try {
            // Open buffer reader for file
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            String currLine;

            // Get number of edges, always first line in file
            if ((currLine = br.readLine()) != null)
                num_of_edges = Integer.parseInt(currLine.trim());

            // Read the rest of the lines in the file
            while((currLine = br.readLine()) != null) {
                // Split current line with spaces
                String[] lineArr = currLine.split("\\s+");

                // Get data from line
                int from = Integer.parseInt(lineArr[0]);
                int to = Integer.parseInt(lineArr[1]);
                int weight = Integer.parseInt(lineArr[2]);

                // Create new edge
                Edge e = new Edge(nodes[from], nodes[to], weight);

                // Add edge to node
                nodes[from].addEdge(e);
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("Edges file not found. Check if path to file is correct. Should be an absolute path, not relative!");
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePathNodes = "C:\\Skole\\Computer-Science\\TDAT2005  Algoritmer og datastrukturer\\Practice 13 - Shortest Path with A-Star\\data\\island\\nodes.txt";
        String filePathEdges = "C:\\Skole\\Computer-Science\\TDAT2005  Algoritmer og datastrukturer\\Practice 13 - Shortest Path with A-Star\\data\\island\\edges.txt";

        Graph g = new Graph(filePathNodes, filePathEdges);

        Node[] nodes = g.getNodes();

        for (int i = 0; i < 5; i++) {
            double[] data = nodes[i].getData();
            System.out.println("Index: " + i + ", breddegrad: " + data[0] + ", lengdegrad: " + data[1]);

            ArrayList<Edge> edges = nodes[i].getEdges();
            System.out.println("Edges: ");
            for (Edge e : edges) {
                System.out.println("    From: " + e.getFrom().getIndex() + ", To: " + e.getTo().getIndex());
            }
        }
    }
}
