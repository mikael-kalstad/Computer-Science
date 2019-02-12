package dyrehage;

import dyrehage.Dyregruppe;

public class Fugleflokk extends Dyregruppe {
    private final int gjennomsnittligVekt;
    private final boolean svommer;

    public Fugleflokk(String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse,
                      String gruppenavn, int antIndivider, int gjennomsnittligVekt, boolean svommer) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, gruppenavn, antIndivider);
        this.gjennomsnittligVekt = gjennomsnittligVekt;
        this.svommer = svommer;
    }

    public int getGjennomsnittligVekt() { return gjennomsnittligVekt; }
    public boolean isSvommer() { return svommer; }

    @Override
    public String toString() {
        super.toString();
        return "gjennomsnittligVekt: " + gjennomsnittligVekt +
                "\nsvommer: " + super.boolToString(svommer);
    }
}
