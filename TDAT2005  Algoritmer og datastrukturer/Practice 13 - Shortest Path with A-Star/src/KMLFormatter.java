import java.io.*;

public class KMLFormatter {
    public static void writeToFile(Node[] path, String filePath) {

        try {
            //File file = new File(filePath + "\\path.kml");
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write("<Placemark>\n" +
                    "  <name>Untitled Path</name>\n" +
                    "  <LineString>\n" +
                    "    <tessellate>1</tessellate>\n" +
                    "    <altitudeMode>relativeToGround</altitudeMode>\n" +
                    "    <coordinates>");
            StringBuilder values = new StringBuilder();
            for (Node n : path) {
               values.append(n.getData()[1]).append(", ");
               values.append(n.getData()[0]).append("\n");
            }
            writer.write(values.toString());
            writer.write(" </coordinates>\n" +
                    "  </LineString>\n" +
                    "</Placemark>");
            writer.close();
        }


        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
