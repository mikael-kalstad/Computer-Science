import java.util.Arrays;

class wordProcessing {
    private final String TEXT;

    wordProcessing(String text) {
        this.TEXT = text;
    }

    String filterText() {
        // Method to filter the text
        String filterText = TEXT.replaceAll("[.!:?]", " "); // Remove symbols
        filterText = filterText.replaceAll("\\s+", " "); // Remove unnecessary spaces
        return filterText;
    }

    int wordAmount() {
        return filterText().split(" ").length;
    }

    double averageWordLength() {
        int totalLetters = 0;
        String textArray[] = filterText().split(" ");
        // System.out.println(Arrays.toString(textArray));

        for (int i = 0; i < textArray.length; i++) {
            totalLetters += textArray[i].length();
        }

        double averageLetters = (double) totalLetters / (double) wordAmount(); // Finds average
        averageLetters = Math.round(averageLetters*10.0)/10.0; // Rounds to 1 decimal
        return averageLetters;
    }

    double averageWordsPeriod() {
        String textArray[] = TEXT.split("[.!:?]");
        System.out.println(Arrays.toString(textArray));
        double average = (double) wordAmount() / (double) textArray.length;
         return Math.round(average*10.0)/10.0;
    }

    String replaceWord (String A, String B) {
        // Word B replaces word A
       return TEXT.replace(A, B);
    }

    String getText() {
        return TEXT;
    }

    public String textUpperCase() {
        // Fungerer ikke med ÆØÅ??
        return TEXT.toUpperCase();
    }

    public String toString() {
        return 
        "wordAmount: " + wordAmount() + "\n" + 
        "averageWordLength: " + averageWordLength() + "\n" + 
        "averageWordsPeriod: " + averageWordsPeriod() + "\n" + 
        "replaceWord: " + replaceWord("hei", "nei1") + "\n" +
        "getText: " + getText() + "\n" + 
        "textUpperCase: " + textUpperCase() + "\n" +
        "Filter text: " + filterText() + "\n"; 
    }



    public static void main(String[] args) {
        // Test klient
        // wordProcessing text = new wordProcessing("det er.fint?. æøå i dag");
        wordProcessing text = new wordProcessing("Hei du. Nå tester vi tekstbehandleren som er laget i Java.");
        System.out.println(text);
        // wordAmount method
        // if (text.wordAmount() == 6) { System.out.println("wordAmount OK"); }
        // else { System.out.println("wordAmount ERROR"); }

        // // averageWordLength method
        // if (text.averageWordLength() == 2.7) { System.out.println("averageLetterLength OK"); }
        // else { System.out.println("averageLetterLength ERROR"); }

        // // averageWordsPeriod method
        // if (text.averageWordsPeriod() == 3) { System.out.println("averageWordsPeriod OK"); }
        // else { System.out.println("averageWordsPeriod ERROR"); }

        // // replaceWord method
        // if (text.replaceWord("fint", "stygt").equals("det er stygt vær. i dag")) { System.out.println("replaceWord OK"); }
        // else { System.out.println("replaceWord ERROR"); }

        // // getText method
        // if (text.getText().equals("det er fint vær. i dag")) { System.out.println("getText OK"); }
        // else { System.out.println("getText ERROR"); }

        // // getTextUpperCae method
        // if (text.getTextUpperCase().equals("DET ER FINT VÆR. I DAG")) { System.out.println("getTextUpperCase OK"); }
        // else { System.out.println("getTextUpperCase ERROR"); }
        // System.out.println(text.getTextUpperCase());
    }
}
