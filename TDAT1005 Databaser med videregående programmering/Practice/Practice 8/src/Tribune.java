import java.io.Serializable;

public abstract class Tribune implements Comparable<Tribune>, Serializable {
    private final String tribunenavn;
    private final int kapasitet;
    private final int pris;

    public Tribune(String tribunenavn, int kapasitet, int pris) {
        this.tribunenavn = tribunenavn;
        this.kapasitet = kapasitet;
        this.pris = pris;
    }

    // Get-methods
    public String getTribunenavn() { return tribunenavn; }
    public int getKapasitet() { return kapasitet; }
    public int getPris() { return pris; }

    public abstract int finnAntallSolgteBilletter();
    public abstract int finnInntekt();

    public abstract Billett[] kjøpBilletter(int antBilletter);
    public abstract Billett[] kjøpBilletter(String[] navn);

    public int compareTo(Tribune t) {
        return this.finnInntekt() - t.finnInntekt();
    }

    @Override
    public String toString() {
        return "Tribunenavn: "+tribunenavn+"\n"+
                "Kapasitet: "+kapasitet+"\n"+
                "Antall solgte billetter: " +finnAntallSolgteBilletter()+"\n"+
                "Inntekt: "+finnInntekt()+"\n";
    }
}
