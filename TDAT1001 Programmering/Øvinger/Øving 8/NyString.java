class NyString {
    private final String TEXT; // To make class immutable!

    // Constructor
    NyString(String text) {
        this.TEXT = text;
    }

    String shortTheWord () {
        String shortWord = "";
        String[] words = TEXT.split(" ");

        for (int i = 0; i < words.length; i++) {
            shortWord += words[i].charAt(0);
        }
        return shortWord;
    }

    String removeLetter(String letter) {
        letter = Character.toString(letter.charAt(0)); // Getting the first letter in string
        return TEXT.replace(letter, ""); // Use String.replace method
    }


    public static void main(String[] args) {
        // Test
        NyString text = new NyString("Han kjører en blå bil");
        System.out.println(text.shortTheWord());
        System.out.println(text.removeLetter("r"));
    }
}






// Old removeLetter method

/*String[] words = TEXT.split(" ");
        String letterRemoved = "";

        for (int i = 0; i < words.length; i++) {
            for (int x = 0; x < words[i].length(); x++) {
                if (words[i].charAt(x) != letter) {
                    letterRemoved += words[i].charAt(x);
                }

                // Create a space after each word
                if (x == words[i].length()-1) {
                    letterRemoved += " ";
                }
            }
        }
        return letterRemoved;*/