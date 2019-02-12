package dyrehage;

public class Hunnindivid extends Individ {
    private int antKull = 0;

    public Hunnindivid(String norskNavn,
                       String latNavn,
                       String latFamilie,
                       int ankommetDato,
                       String adresse,
                       String navn,
                       int fDato,
                       boolean farlig) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, navn, fDato, false, farlig);
    }

    public int getAntKull() { return antKull; }

    @Override
    public void leggTilKull(int antall) { antKull += antall; }

    @Override
    public void leggTilNyttKull() { antKull++; }
}
