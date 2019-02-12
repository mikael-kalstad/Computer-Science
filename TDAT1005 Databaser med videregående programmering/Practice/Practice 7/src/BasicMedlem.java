import java.time.LocalDate;

public class BasicMedlem extends BonusMedlem{
    public BasicMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato) {
        super(medlNr, pers, innmeldtDato);
    }

//    @Override
//    public String toString() {
//        return "Medlnr: " + getMedlNr() + "\n" +
////                "Info: " + pers.toString() + "\n" +
//                "Antall Poeng: " + this.poeng + "\n" +
//                "Innmeldt dato: " + getInnmeldt().toString() + "\n" +
//                "Medlemstype: BASIC" + "\n";
//    }
}
