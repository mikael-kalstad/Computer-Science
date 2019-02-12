import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class TestProgram  {
    public static ArrayList<Tribune> lesFraFil(String filnavn) {
        ArrayList<Tribune> tribuner = new ArrayList<>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filnavn));

            while(true) {
                Object obj = ois.readObject();
                if (obj != null) {
                    tribuner.add((Tribune)obj);
                }
//                else { ois.close(); }
            }
        }
        // Slutten av filen vil kaste en EOFException
        catch (EOFException e) { }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Feil under lesing av fil");
            return null;
        }
        return tribuner;
    }

    public static boolean skrivTilFil(String filnavn, ArrayList<Tribune> tribuner) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filnavn));

            for (Tribune t : tribuner) {
                oos.writeObject(t);
            }

            oos.close();;
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Feil under skriving til fil");
            return false;
        }
    }

    public static void printBilletter(Billett[] billetter) {
        if (billetter != null) {
            for (int i = 0; i < billetter.length; i++) {
                System.out.println("Bilett " + (i + 1) + " | " + billetter[i].toString());
            }
        } else {
            System.out.println("Printer: finner ingen billetter");
        }
    }

    public static void main(String[] args) {
        ArrayList<Tribune> tribuner = new ArrayList<>();

        Tribune staa1 = new Staa("Stå tribune", 10, 200);
        Tribune staa2 = new Staa("Fattigsmanns tribune", 75, 123);
        Tribune sitte = new Sitte("Komfort tribune", 30, 230, 6);
        Tribune VIP = new VIP("Eksklusiv tribune", 100, 450, 5);

        tribuner.add(staa1);
        tribuner.add(staa2);
        tribuner.add(sitte);
        tribuner.add(VIP);

        // Stå tribune
        System.out.println("--- Info om stå tribune ---");
        System.out.println(staa1.toString());

        System.out.println("Kjøper 5 billetter");
        Billett[] mineStaaBilletter = staa1.kjøpBilletter(5);
        printBilletter(mineStaaBilletter);

        System.out.println("\nPrøver å kjøpe flere billetter enn ledige plasser, 6stk");
        Billett[] mineStaaBilletter2 = staa1.kjøpBilletter(6);
        if (mineStaaBilletter2 == null) System.out.println("-Ikke nok plasser\n");


        // Stå tribune (fattigmanns)
        System.out.println("--- Info om fattigmanns tribune ---");
        System.out.println(staa2.toString());

        System.out.println("Kjøper 5 billetter");
        Billett[] mineStaaBilletter3 = staa2.kjøpBilletter(5);
        printBilletter(mineStaaBilletter3);


        // Sitte tribune (komfort)
        System.out.println("\n--- Info om komfort tribune ---");
        System.out.println(sitte.toString());

        System.out.println("Bestiller billetter på Komfort tribune");
        System.out.println("--Rad fordeling før bestilling");
        ((Sitte) sitte).printRadFordeling();

        System.out.println("--Bestiller 3 billetter");
        printBilletter(sitte.kjøpBilletter(3));
        ((Sitte) sitte).printRadFordeling();

        System.out.println("Bestiller 3 billetter");
        printBilletter(sitte.kjøpBilletter(3));
        ((Sitte) sitte).printRadFordeling();

        System.out.println("--Bestiller 1 billett");
        printBilletter(sitte.kjøpBilletter(1));
        ((Sitte) sitte).printRadFordeling();

        System.out.println("--Bestiller 4 billetter");
        printBilletter(sitte.kjøpBilletter(4));
        ((Sitte) sitte).printRadFordeling();


        // Sitte tribune (VIP)
        System.out.println("\n--- Info om VIP tribune ---");
        System.out.println(VIP.toString());

        System.out.println("--Bestiller 3 billetter");
        printBilletter(VIP.kjøpBilletter(new String[]{"Pål", "Per", "Berit"}));

        System.out.println("\n--Prøver å bestille billett uten navn");
        System.out.println("Resultat metode 1: "+VIP.kjøpBilletter(2));
        VIP.kjøpBilletter(new String[]{""});


        // Sammendrag/info om tribuner
        System.out.println();
        System.out.println("--- Info om tribunene ---");
        for (Tribune tribune : tribuner) {
            System.out.println(tribune.toString());
        }


        // Sortering etter inntekt
        System.out.println("\nSorterer tribunene etter inntekt");
        Collections.sort(tribuner);

        System.out.println("--- Info om tribunene ---");
        for (Tribune tribune : tribuner) {
            System.out.println(tribune.toString());
        }


        // Skriv og les fra fil
        System.out.println("\nSkriver til fil..");
        skrivTilFil("tribuner.txt", tribuner);

        System.out.println("Leser fra fil..");
        ArrayList<Tribune> tribunerFraFil = lesFraFil("tribuner.txt");

        System.out.println("\n--Skriver ut tribuner fra fil\n");
        for (Tribune t : tribunerFraFil) {
            System.out.println(t.toString());
        }
    }
}
