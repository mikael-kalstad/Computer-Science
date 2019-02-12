import java.time.LocalDate;

public class SoelvMedlem extends BonusMedlem{
    public SoelvMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato, int poeng) {
        super(medlNr, pers, innmeldtDato, poeng);
    }

    @Override
    public void registrerPoeng(int antall) {
        super.registrerPoeng((int) Math.round(antall*1.2));
    }
}
