public class Sitte extends Tribune {
    private int[][] antOpptatt;

    public Sitte(String tribunenavn, int kapasitet, int pris, int antRader) {
        super(tribunenavn, kapasitet, pris);
        this.antOpptatt = new int[antRader][super.getKapasitet()/antRader];
    }

    @Override
    public int finnAntallSolgteBilletter() {
        int counter = 0;
        for (int[] rad : antOpptatt) {
            for (int sete : rad) {
                if (rad[sete] == 1) counter++;
            }
        }
        return counter;
    }

    @Override
    public int finnInntekt() {
        return finnAntallSolgteBilletter()*super.getPris();
    }

    @Override
    public Billett[] kjøpBilletter(int antBilletter) {
        Billett[] arr = new Billett[antBilletter];
        // Hvis det er fullt, får man ikke kjøpt noen billetter
        int[] ledigPlass = finnLedigPlass(antBilletter);
        if (ledigPlass == null) return null;

        // Endrer tabell slik at setene som bestilles er opptatt
        for (int ant = 0; ant < antBilletter; ant++) {
            antOpptatt[ledigPlass[0]][ledigPlass[1]+ant] = 1;
        }

        // Ordner billettene
        for (int i = 0; i < antBilletter; i++) {
            arr[i] = new SitteplassBillett(super.getTribunenavn(), super.getPris(), ledigPlass[0]+1, ledigPlass[1]+i+1);
        }
        return arr;
    }

    @Override
    public Billett[] kjøpBilletter(String[] navn) {
        return kjøpBilletter(navn.length);
    }

    protected int[] finnLedigPlass(int antBilletter) {
        int counter = 0;
        int radLedig = 0;
        int seteLedig = 0;

        for (int rad = 0; rad < antOpptatt.length; rad++) {
            for (int sete = 0; sete < antOpptatt[rad].length; sete++) {
                if (counter == 0) {
                    radLedig = rad;
                    seteLedig = sete;
                }
                if (antOpptatt[rad][sete] != 1) counter++;
                else counter = 0;

                if (counter >= antBilletter) {
                    return new int[]{radLedig, seteLedig};
                }
            }
            counter = 0;
        }
        return null;
    }

    public void printRadFordeling() {
        System.out.println("0 = ledig, 1 = opptatt");
        for (int rad = 0; rad < antOpptatt.length; rad++) {
            System.out.print("Rad: "+rad+" | ");
            for (int sete = 0; sete < antOpptatt[rad].length; sete++) {
                System.out.print(antOpptatt[rad][sete] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Sitte test = new Sitte("hei", 10, 100, 5);
        System.out.println("antall solgte: "+test.finnAntallSolgteBilletter());
        test.kjøpBilletter(2);
        System.out.println("antall solgte: "+test.finnAntallSolgteBilletter());
    }
}
