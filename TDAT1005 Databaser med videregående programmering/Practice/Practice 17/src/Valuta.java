public class Valuta {
    private String valutanavn;
    private double kurs;

    Valuta(String valutanavn, double kurs, int enhet) {
        this.valutanavn = valutanavn;
        this.kurs = kurs / (double)enhet;
    }

    public double getKurs() { return kurs; }
    public String getValutanavn() { return valutanavn; }

    public static double konverter(Valuta fra, Valuta til, double sum) {
        double norske = sum / til.getKurs();
        return (norske * fra.getKurs());
    }

    public String toString() {
        return valutanavn + " " + kurs;
    }
}
