import dyrehage.*;

public class testklient {
    public static void main(String[] args) {
        RovDyrfabrikk fabrikk = new RovDyrfabrikk();

        SkandinaviskeRovdyr birgit = fabrikk.nyBinne(20191202, "Hule 1", "Birgit", 20170202);
        SkandinaviskeRovdyr tore = fabrikk.nyHannbjorn(20161202, "Hule 2", "Tore", 20150302);
        SkandinaviskeRovdyr pernille = fabrikk.nyUlvetispe(20131202, "Skog 1", "Pernille", 20110202);
        SkandinaviskeRovdyr ulf = fabrikk.nyUlvehann(20121202, "Skog 1", "Ulf", 20100202);

        // Test 1 - Navn og adresse
        if (birgit.getNavn().equals("Birgit") && birgit.getAdress().equals("Hule 1")) {
            System.out.println("Test 1 - OK");
        } else System.out.println("Test 1 - FEIL");

        // Test 2 - klassetype og alder
        if (tore instanceof Hannindivid && tore.getAlder() == 4) {
            System.out.println("Test 2 - OK");
        } else System.out.println("Test 2 - FEIL");

        // Test 3 - flytt og skrivutinfo
        String pernileInfo = "Norsk navn: Ulv\nLatinsk navn og familie: Canis lupus, Canidae\nAdresse: Skog 2\n" +
                             "Navn: Pernille\nfDato: 20110202\nhanndyr: Nei\nfarlig: Ja";
        pernille.flytt("Skog 2");
        if (pernille.getAdress().equals("Skog 2") && pernille.skrivUtInfo().equals(pernileInfo)) {
            System.out.println("Test 3 - OK");
        } else System.out.println("Test 3 - FEIL");

        // Test 4 - kull metoder
        pernille.leggTilKull(3);
        pernille.leggTilNyttKull();
        if (ulf.getAntKull() == 0 && pernille.getAntKull() == 4) {
            System.out.println("Test 4 - OK");
        } else System.out.println("Test 4 - FEIL");
    }
}

