public class Staa extends Tribune {
    private int antSolgteBilletter;

    public Staa(String tribunenavn, int kapasitet, int pris) {
        super(tribunenavn, kapasitet, pris);
    }

    @Override
    public int finnAntallSolgteBilletter() {
        return antSolgteBilletter;
    }

    @Override
    public int finnInntekt() {
        return antSolgteBilletter*super.getPris();
    }

    @Override
    public Billett[] kjøpBilletter(int antBilletter) {
        Billett[] arr = new Billett[antBilletter];
        // Hvis det er fullt, får man ikke kjøpt noen billetter
        if (super.getKapasitet()-antSolgteBilletter <= antBilletter) return null;
        antSolgteBilletter += antBilletter;

        for (int i = 0; i < antBilletter; i++) {
            arr[i] = new StaaplassBillett(super.getTribunenavn(), super.getPris());
        }

        return arr;
    }

    @Override
    public Billett[] kjøpBilletter(String[] navn) {
        return kjøpBilletter(navn.length);
    }

    public static void main(String[] args) {
        Staa test = new Staa("test", 6, 120);
        Billett[] bilett1 = test.kjøpBilletter(4);
        Billett[] bilett2 = test.kjøpBilletter(6);

        for (int i = 0; i < bilett1.length; i++) {
            System.out.println("Bilett " + (i+1) + " | "+bilett1[i].toString());
        }

        if (bilett2 != null) {
            for (int i = 0; i < bilett2.length; i++) {
                System.out.println("it is running!");
                System.out.println("Bilett " + (i + 1) + " | " + bilett2[i].toString());
            }
        }
        if (bilett2 == null) {
            System.out.println("Ikke nok plasser");
        }
    }
}
