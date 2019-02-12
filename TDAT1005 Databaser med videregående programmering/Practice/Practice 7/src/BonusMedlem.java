import java.time.LocalDate;
import java.time.Period;

public class BonusMedlem {
    private final int medlNr;
    private final Personalia pers;
    private final LocalDate innmeldtDato;
    private int poeng = 0;

    public BonusMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato) {
        this.medlNr = medlNr;
        this.pers = pers;
        this.innmeldtDato = innmeldtDato;
    }

    public BonusMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato, int poeng) {
        this.medlNr = medlNr;
        this.pers = pers;
        this.innmeldtDato = innmeldtDato;
        this.poeng = poeng;
    }

    // GET - metoder
    public int getMedlNr() { return medlNr; }
    public Personalia getPersonalia() { return pers; }
    public LocalDate getInnmeldt() { return innmeldtDato; }
    public int getPoeng() { return poeng; }

    public int finnKvalPoeng() {
        int dagerMellom = Period.between(innmeldtDato, LocalDate.now()).getDays();
        if (dagerMellom <= 365) return poeng;
        return -1;
    }

    public boolean okPassord(String passord) {
        return passord != null
                && !passord.trim().equals("")
                && pers.okPassord(passord);
    }

    public void registrerPoeng(int antall) {
        if (finnKvalPoeng() != -1) poeng += antall;
    }

    @Override
    public String toString() {
        String type = "";
        if (this instanceof  BasicMedlem) type += "Basic";
        else if (this instanceof SoelvMedlem) type += "Sølv";
        else if (this instanceof  GullMedlem) type += "Gull";

        return "Medlnr: " + getMedlNr() + "\n" +
                "Info: " + pers.toString() + "\n" +
                "Antall Poeng: " + getPoeng() + "\n" +
                "Innmeldt dato: " + getInnmeldt().toString() + "\n" +
                "Medlemstype: " + type + "\n";
    }
}
