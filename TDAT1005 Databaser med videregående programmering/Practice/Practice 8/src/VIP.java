public class VIP extends Sitte {
    // tabellstørrelse: antall rader * antall rader pr rad
    private String[][] tilskuere;

    public VIP(String tribunenavn, int kapasitet, int pris, int antRader) {
        super(tribunenavn, kapasitet, pris, antRader);
        tilskuere = new String[antRader][super.getKapasitet()/antRader];
    }

    @Override
    public int finnAntallSolgteBilletter() {
        int counter = 0;
        for (String[] rad : tilskuere) {
            for (String navn : rad) {
                if (navn != null) counter++;
            }
        }
        return counter;
    }

    @Override
    public int finnInntekt() {
        return finnAntallSolgteBilletter()*super.getPris();
    }

    // Ingen skal kunne kjøpe VIP plass uten navn
    @Override
    public Billett[] kjøpBilletter(int antBilletter) {
        return null;
    }

    @Override
    public Billett[] kjøpBilletter(String[] navn) {
        Billett[] arr = new Billett[navn.length];
        int[] ledigPlass = super.finnLedigPlass(navn.length);

        for (int i = 0; i < navn.length; i++) {
            if (navn[i] == null || navn[i].trim().equals("")) {
                System.out.println("Alle billetter må inneholde et navn!");
                return null;
            }
            tilskuere[ledigPlass[0]][ledigPlass[1]+i] = navn[i];
        }

        // Ordner billettene
        for (int i = 0; i < navn.length; i++) {
            arr[i] = new SitteplassBillett(super.getTribunenavn(), super.getPris(), ledigPlass[0]+1, ledigPlass[1]+i+1);
        }
        return arr;
    }
}
