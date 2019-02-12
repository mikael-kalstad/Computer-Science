package dyrehage;

import java.util.Calendar;

public abstract class Individ extends Dyr implements SkandinaviskeRovdyr {
    private final String navn;
    private final int fDato;
    private final boolean hanndyr;
    private final boolean farlig;

    public Individ(String norskNavn, String latNavn, String latFamilie, int ankommetDato,
                   String adresse, String navn, int fDato, boolean hanndyr, boolean farlig) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.navn = navn;
        this.fDato = fDato;
        this.hanndyr = hanndyr;
        this.farlig = farlig;
    }

    public String getNavn() { return navn; }
    public boolean isHanndyr() { return hanndyr; }
    public boolean isFarlig() { return farlig; }

    // Metoder fra interface
    @Override
    public int getFdato() { return fDato; }

    @Override
    public int getAlder() {
        int fodselsAar = Integer.parseInt(Integer.toString(fDato).substring(0, 4));
        return Calendar.getInstance().get(Calendar.YEAR) - fodselsAar;
    }

    @Override
    public String getAdress() { return super.getAdresse(); }

    @Override
    public void flytt(String nyAdresse) { super.setAdresse(nyAdresse); }

    @Override
    public String skrivUtInfo() { return toString(); }

    @Override
    public String toString() {

        return super.toString() +
                "Navn: " + navn + "\nfDato: " + fDato +
                "\nhanndyr: " + super.boolToString(hanndyr) +
                "\nfarlig: " + super.boolToString(farlig);
    }
}
