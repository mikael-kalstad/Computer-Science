import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Huffman {
    private DataInputStream innFil;
    private DataOutputStream utFil;
    private ArrayList<Object[]> frequency = new ArrayList<>();

    public Huffman(String innFilNavn) {
        // Åpne filer
        try {
            innFil = new DataInputStream(new BufferedInputStream(new FileInputStream(innFilNavn)));
            utFil = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(innFilNavn + "_compressed")));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    Huffman() {}

    // Les data til fil inn i byte array
    private void lesDataFraFil(byte[] data, int pos, int antall) {
        try {
            innFil.readFully(data, pos, antall);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setFrequency(byte[] input) {
        for (int i = 0; i < input.length; i++) {
            byte b = input[i];

            boolean found = false;

            // Check if character is already defined in frequency
            for (int j = 0; j < frequency.size(); j++) {
                Object[] o = frequency.get(j);

                if ((byte)o[0] == b) {
                    // Increase amount with one
                    o[1] = (int) o[1] + 1;
                    found = true;
                    break;
                }
            }

            if (!found) {
                // Add new array to frequency
                Object[] temp = new Object[2];
                temp[0] = b;
                temp[1] = 1;
                frequency.add(temp);
            }
        }

        for (Object[] o : frequency) {
            System.out.print(o[0] + ": " + o[1] + "\n");
        }

        System.out.println("\n" + frequency.size());
    }

    public static void main(String[] args) throws IOException {
        byte[] array = Files.readAllBytes(Paths.get("C:\\Users\\Mikael\\Dropbox\\Computer-Science\\TDAT2005  Algoritmer og datastrukturer\\Practice 12 - Compression\\src\\1.txt"));

        //System.out.println(Arrays.toString(array));
        Huffman h = new Huffman();
        h.setFrequency(array);

        byte b = 42;
        String s = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
        System.out.println(s);

        byte b2 = Byte.parseByte(s, 2);
        System.out.println(b2);
    }
}