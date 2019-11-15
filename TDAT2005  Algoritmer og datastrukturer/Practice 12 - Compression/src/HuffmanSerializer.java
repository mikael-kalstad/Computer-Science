import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class for converting byte and bit strings
 */
public class BitString {
    private String value;
    private byte b;

    public BitString(byte b) {
        this.b = b;
        value = byteToBitString(b);
    }

    public String getValue() {
        return value;
    }

    public byte getByte() {
        return b;
    }

    /**
     * Convert byte to a bit string
     * @param b - Byte input
     * @return Bit string
     */
    public static String byteToBitString(byte b) {
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }


    /**
     * Convert a bit string to a byte
     * @param s - Bit string input
     * @return byte
     */
    public static byte bitStringToByte(String s) {
        return Byte.parseByte(s, 2);
    }

    public static void main(String[] args) throws IOException {
        byte[] array = Files.readAllBytes(Paths.get("C:\\Users\\Mikael\\Dropbox\\Computer-Science\\TDAT2005  Algoritmer og datastrukturer\\Practice 12 - Compression\\src\\1.txt"));

        byte b = 42;
        String s = BitString.byteToBitString(b);
        System.out.println(s);

        byte b2 = Byte.parseByte(s, 2);
        System.out.println(BitString.bitStringToByte(s));
    }
}
