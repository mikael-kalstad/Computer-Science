package dyrehage;

public class Dyregruppe extends Dyr {
    private final String gruppenavn;
    private int antIndivider;

    public Dyregruppe(String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse,
            String gruppenavn, int antIndivider) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.gruppenavn = gruppenavn;
        this.antIndivider = antIndivider;
    }

    public String getGruppenavn() { return gruppenavn; }
    public int getAntIndivider() { return antIndivider; }
    public void setAntIndivider(int antIndivider) { this.antIndivider=antIndivider; }

    // Oppgave 1c
    @Override
    public String getNorskNavn() {
        return "gruppe av " + super.getNorskNavn();
    }

    @Override
    public String toString() {
        return super.toString() + "gruppenavn: " + gruppenavn + "\nantIndivider: " + antIndivider;
    }
}
