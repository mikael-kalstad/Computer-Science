package dyrehage;

public class Hannindivid extends Individ {
    public Hannindivid(String norskNavn,
                       String latNavn,
                       String latFamilie,
                       int ankommetDato,
                       String adresse,
                       String navn,
                       int fDato,
                       boolean farlig) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, navn, fDato, false, farlig);
    }

    @Override
    public int getAntKull() { return 0; }


    // Antall kull skal ikke implementeres i hannindivider
    @Override
    public void leggTilKull(int antall) { }

    @Override
    public void leggTilNyttKull() { }
}
