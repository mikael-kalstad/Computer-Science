import javax.swing.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Konferansesenter_klient {

    // Returnerer tidspunktet hvis formatering er rett
    private static Long sjekkTidFormatering(String tid) {
        try {
            if (tid != null) {
                String[] fullDato = tid.split(" ");

                // Sjekker om lengden er korrekt i forhold til formateringskrav gitt.
                if (fullDato[1].length() != 4 || fullDato[0].length() != 10) {
                    JOptionPane.showMessageDialog(null, "Feil formatering på tidspunkt");
                    return 0L;
                }

                long klokkeslett = Long.parseLong(fullDato[1]);

                String[] datoArr = fullDato[0].split("-");
                long dato = Long.parseLong(String.join("", datoArr));
                return dato + klokkeslett;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Feil formatering på tidspunkt");
        }
        return 0L;
    }


    public static void main(String[] args) {
        ArrayList<Rom> arr = new ArrayList<>();

        Rom rom1 = new Rom(1, 12);
        Rom rom2 = new Rom(17, 2);
        Rom rom3 = new Rom(3, 10);

        arr.add(rom1);
        arr.add(rom2);
        arr.add(rom3);

        Konferansesenter thonKonferanse = new Konferansesenter(arr);

        final int RESERVER = 0;
        final int REGNYTTROM = 1;
        final int FINNANTROM = 2;
        final int FINNBESTEMTROM = 3;
        final int AVSLUTT = 4;

        boolean avslutt = true;

        while(avslutt) {
            String menyValg[] = {"Reserver rom", "Registrer nytt rom", "Finn antall rom", "Finn bestemt rom", "Avslutt"};
            int valg = JOptionPane.showOptionDialog(null, "", "Ansatte", JOptionPane.OK_OPTION, -1, null, menyValg, menyValg[menyValg.length-1]);

            switch (valg) {
                case RESERVER:
                    Tidspunkt tidspunktFra = null;
                    Tidspunkt tidspunktTil = null;
                    int antPers = 0;
                    String navn = null;
                    String tlf = null;

                    boolean ok = false;

                    /* TIDSPUNKT */
                    while (!ok) {
                        String tidFra = JOptionPane.showInputDialog(null, "Velg tid fra. \nFormatering: dd-mm-åååå ttmm \nf.eks. 03.januar.2016 kl 12:30 = 03-01-2016 1230");
                        String tidTil = JOptionPane.showInputDialog(null, "Velg tid til. \nFormatering: dd-mm-åååå ttmm \nf.eks. 03.januar.2016 kl 12:30 = 03-01-2016 1230");

                        if (sjekkTidFormatering(tidFra) != 0L && sjekkTidFormatering(tidTil) != 0L) {
                            tidspunktFra = new Tidspunkt(sjekkTidFormatering(tidFra));
                            tidspunktTil = new Tidspunkt(sjekkTidFormatering(tidTil));
                            ok = true;
                        }
                    }

                    /* ANTALL PERSONER */
                    ok = false;
                    while (!ok) {
                        String antPersString = JOptionPane.showInputDialog(null, "Velg antall personer");
                        try {
                            if (antPersString.length() == 0) JOptionPane.showMessageDialog(null, "Felt kan ikke være tomt");
                            Integer.parseInt(antPersString);
                            ok = true;
                        }

                        catch (Exception e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Feltet kan kun inneholde nummer");
                        }
                    }

                    /* NAVN */
                    ok = false;
                    while(!ok) {
                        navn = JOptionPane.showInputDialog(null, "Velg navn \n Fornavn og etternavn");
                        if (navn.length() == 0) JOptionPane.showMessageDialog(null, "Navn kan ikke inneholde tall eller ha lengde 0");
                        ok = true;
                    }

                    /* TLF NUMMER */
                    ok = false;
                    while(!ok) {
                        tlf = JOptionPane.showInputDialog(null, "Velg tlf nummer");
                        try {
                            if (tlf.length() != 8) JOptionPane.showMessageDialog(null, "Feil formatering på tlf nummer");
                            Integer.parseInt(tlf);
                            ok = true;
                        }

                        catch (Exception e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Feil formatering på tlf nummer");
                        }
                    }

                    Kunde kunde = new Kunde(navn, tlf);
                    Reservasjon reservasjon = new Reservasjon(tidspunktFra, tidspunktTil, kunde);
                    if (!thonKonferanse.reserverRom(reservasjon, antPers)) {
                        JOptionPane.showMessageDialog(null, "Ingen ledige rom");
                    }

                    ok = true;
                    break;

                case REGNYTTROM:
                    int romNr = 0;
                    int romStr = 0;
                    boolean okreg = false;

                    while(!okreg) {
                        String romNr_string = JOptionPane.showInputDialog(null, "Velg rom nummber");
                        String romStr_string = JOptionPane.showInputDialog(null, "Velg størrelse på rommet, angis i antall personer");

                        try{
                            romNr = Integer.parseInt(romNr_string);
                            romStr = Integer.parseInt(romStr_string);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Må være et tall");
                        }
                        okreg = true;
                    }

                    Rom nyttRom = new Rom(romNr, romStr);
                    thonKonferanse.regNyttRom(nyttRom);
                    break;

                case FINNANTROM:
                    JOptionPane.showMessageDialog(null, "Antall rom: " + thonKonferanse.finnAntRom());
                    break;

                case FINNBESTEMTROM:
                    String menyValg2[] = {"Med indeks", "Med rom nummer", "Avslutt"};
                    int valg2 = JOptionPane.showOptionDialog(null, "", "Ansatte", JOptionPane.OK_OPTION, -1, null, menyValg2, menyValg2[menyValg2.length-1]);

                    final int INDEKS = 0;
                    final int ROMNR = 1;

                    switch(valg2) {
                        case INDEKS:
                            int indeks_tall = 0;
                            boolean okindeks = false;

                            while(!okindeks) {
                                String indeks = JOptionPane.showInputDialog(null, "Skriv inn index");
                                try{ indeks_tall = Integer.parseInt(indeks); }
                                catch (Exception e) {
                                    e.printStackTrace();
                                    JOptionPane.showMessageDialog(null, "Må være et tall");
                                }
                                okindeks = true;
                            }

                            Rom indeksRom = thonKonferanse.finnRomMedIndeks(indeks_tall);
                            JOptionPane.showMessageDialog(null, "Informasjon om rommet:\n" + indeksRom.toString());
                            break;

                        case ROMNR:
                            int romnr_tall = 0;
                            boolean okromnr = false;

                            while(!okromnr) {
                                String romnr = JOptionPane.showInputDialog(null, "Skriv inn rom nummer");
                                try{ romnr_tall = Integer.parseInt(romnr); }
                                catch (Exception e) {
                                    e.printStackTrace();
                                    JOptionPane.showMessageDialog(null, "Må være et tall");
                                }
                                okromnr = true;
                            }

                            Rom romnrRom = thonKonferanse.finnRomMedRomNr(romnr_tall);
                            JOptionPane.showMessageDialog(null, "Informasjon om rommet:\n" + romnrRom.toString());
                            break;
                    }
                    break;

                case AVSLUTT:
                    avslutt = false;
                    break;
            }
        }
    }
}

