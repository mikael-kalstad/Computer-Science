package dyrehage;

import dyrehage.Dyregruppe;

public class Fiskestim extends Dyregruppe {
    private final String gjennomsnittligLengde;
    private final boolean kanDeleAkvarium;

    public Fiskestim(String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse,
                     String gruppenavn, int antIndivider, String gjennomsnittligLengde, boolean kanDeleAkvarium) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, gruppenavn, antIndivider);
        this.gjennomsnittligLengde = gjennomsnittligLengde;
        this.kanDeleAkvarium = kanDeleAkvarium;
    }

    public String getGjennomsnittligLengde() { return gjennomsnittligLengde; }
    public boolean getKanDeleAkvarium() { return kanDeleAkvarium; }

    @Override
    public String toString() {
        super.toString();
        return "gjennomsnittligLengde: " + gjennomsnittligLengde +
                "\nkanDeleAkvarium: " + super.boolToString(kanDeleAkvarium);
    }
}
