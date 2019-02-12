import java.lang.reflect.Array;
import java.util.ArrayList;

public class Konferansesenter {
	ArrayList<Rom> romTabell = new ArrayList<>();

    public Konferansesenter(ArrayList<Rom> romTabell) {
        this.romTabell.addAll(romTabell);
    }

    public boolean reserverRom(Reservasjon reservasjon, int antPers) {
        for (Rom obj: this.romTabell) {
            if (obj != null
                    && obj.getRomStr() >= antPers
                    && obj.nyReservasjon(reservasjon)) {
                return true;
            }
        }
        return false;
    }

    public boolean regNyttRom(Rom rom) {
        for (Rom obj: this.romTabell) {
            if (obj != null && obj.getRomNr() == rom.getRomNr()) return false;
        }
        romTabell.add(rom);
        return true;
    }

    public int finnAntRom() {
        return this.romTabell.size();
    }

    public Rom finnRomMedIndeks(int indeks) {
        return romTabell.get(indeks);
    }

    public Rom finnRomMedRomNr(int romNr) {
        for (Rom obj: this.romTabell) {
            if (obj != null && obj.getRomNr() == romNr) return obj;
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Rom> arr = new ArrayList<>();
        Rom rom1 = new Rom(1, 12);
        Rom rom2 = new Rom(17, 2);
        Rom rom3 = new Rom(3, 10);

        arr.add(rom1);
        arr.add(rom2);
        arr.add(rom3);

        Konferansesenter o = new Konferansesenter(arr);

        /* --- TEST 1 ---*/
        if (o.finnAntRom() == 3) System.out.print("OK ");
        else System.out.println("Feil ");
        System.out.print("Test 1 - finnAntRom\n");

        /* --- TEST 2 ---*/
        if (o.finnRomMedIndeks(2) == rom3) System.out.print("OK ");
        else System.out.println("Feil ");
        System.out.print("Test 2 - finnRomMedIndeks\n");

        /* --- TEST 3 ---*/
        if (o.finnRomMedRomNr(17) == rom2) System.out.print("OK ");
        else System.out.println("Feil ");
        System.out.print("Test 3 - finnRomMedRomNr\n");

        /* --- TEST 4 ---*/
        Tidspunkt fra = new Tidspunkt(160120191007L); // 16.jan.2019 10:07
        Tidspunkt til = new Tidspunkt(160120191207L); // 16.jan.2019 12:07
        Kunde per = new Kunde("Per Hansen", "12345678");
        Reservasjon reservasjon = new Reservasjon(fra, til, per);

        if (o.reserverRom(reservasjon, 9)) System.out.print("OK ");
        else System.out.print("Feil ");
        System.out.print("Test 4 - reserverRom\n");

        /* --- TEST 5 ---*/
        Rom nyttRom = new Rom(15, 4);

        if (o.regNyttRom(nyttRom) && !o.regNyttRom(nyttRom)) {
            System.out.print("OK ");
        }
        else System.out.println("Feil ");
        System.out.print("Test 5 - regNyttRom\n");
    }
}