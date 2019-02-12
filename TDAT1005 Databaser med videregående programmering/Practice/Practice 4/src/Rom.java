import java.util.ArrayList;

public class Rom {
    private ArrayList<Reservasjon> reservasjoner = new ArrayList<>();
    private int romNr;
    private int romStr;

    public Rom(int romNr, int romStr) {
        this.romNr = romNr;
        this.romStr = romStr;
    }

    public boolean nyReservasjon(Reservasjon reservasjon) {
        for (Reservasjon obj: this.reservasjoner) {
            if (obj != null && obj.overlapp(reservasjon.getFraTid(), reservasjon.getTilTid())) {
                return false;
            }
        }
        reservasjoner.add(reservasjon);
        return true;
    }

    public int getRomNr() { return this.romNr; }
    public int getRomStr() { return this.romStr; }

    @Override
    public String toString() {
        return "Rom nummer: " + this.romNr + "\nRom størrelse: " + this.romStr;
    }

    public static void main(String[] args) {
        Rom o = new Rom(2, 12);

        /* --- TEST 1 ---*/
        System.out.print("Test 1 - RomNr: ");
        if (o.getRomNr() == 2) System.out.print("Ok\n");
        else System.out.println("Feil\n");

        /* --- TEST 2 --- */
        System.out.print("Test 2 - RomStr: ");
        if (o.getRomStr() == 12) System.out.print("Ok\n");
        else System.out.print("Feil\n");

        /* --- TEST 3* ---*/
        System.out.print("Test 3 - NyReservasjon (ledig): ");

        // Formatering tidspunkt dd-mm-åååå kl ttmm
        Tidspunkt fra = new Tidspunkt(160120191007L); // 16.jan.2019 10:07
        Tidspunkt til = new Tidspunkt(160120191207L); // 16.jan.2019 12:07
        Kunde per = new Kunde("Per Hansen", "12345678");
        Reservasjon reservasjon = new Reservasjon(fra, til, per);

        if (o.nyReservasjon(reservasjon)) System.out.print("Ok\n");
        else System.out.print("Feil\n");

        /* --- TEST 4 ---*/
        System.out.print("Test 4 - NyReservasjon (opptatt): ");

        // Formatering tidspunkt dd-mm-åååå kl ttmm
        Tidspunkt fra2 = new Tidspunkt(160120191007L); // 16.jan.2019 10:07
        Tidspunkt til2 = new Tidspunkt(160120191207L); // 16.jan.2019 12:07
        Kunde ole = new Kunde("Ole Hansen", "12345678");
        Reservasjon reservasjon2 = new Reservasjon(fra2, til2, ole);

        // Skal returnere false siden rommet er allerede booket
        if (!o.nyReservasjon(reservasjon2)) System.out.print("Ok\n");
        else System.out.print("Feil\n");
    }
    }
