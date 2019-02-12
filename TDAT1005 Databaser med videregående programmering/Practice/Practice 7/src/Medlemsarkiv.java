import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Medlemsarkiv {
    public ArrayList<BonusMedlem> medlemmer = new ArrayList<>();

    public int nyMedlem(Personalia pers, LocalDate innmeldt) {
        int medlNr = finnLedigNr();
        medlemmer.add(new BasicMedlem(medlNr, pers, innmeldt));
        return medlNr;
    }

    public int finnPoeng(int medlrNr, String passord) {
        for (BonusMedlem medlem : medlemmer) {
            if (medlem.getMedlNr() == medlrNr && medlem.okPassord(passord)) {
                return medlem.getPoeng();
            }
        }
        return -1;
    }

    public boolean registrerPoeng(int medlNr, int antPoeng) {
        for (BonusMedlem medlem : medlemmer) {
            if (medlem.getMedlNr() == medlNr) {
                medlem.registrerPoeng(antPoeng);
                return true;
            }
        }
        return false;
    }

    private int finnLedigNr() {
        boolean fortsett = true;
        boolean lik = false;
        Random randomGen = new Random();
        int num = 0;

        while(fortsett) {
            // Kun positive tall
            num = randomGen.nextInt(Integer.MAX_VALUE);
            for (BonusMedlem medlem : medlemmer) {
                if (medlem.getMedlNr() == num) {
                    lik = true;
                    break;
                }
            }
            if (!lik) fortsett = false;
            lik = false;
        }
        return num;
    }

    public void sjekkMedlemmer() {
        for (BonusMedlem medlem : medlemmer) {
            boolean test = medlem instanceof BasicMedlem;
            int test3 = medlem.finnKvalPoeng();
            boolean test2 = medlem.finnKvalPoeng() >= 25000;

            // SØLV-MEDLEMSSKAP
            if (medlem.finnKvalPoeng() >= 25000 && medlem.finnKvalPoeng() < 75000) {
                medlemmer.set(medlemmer.indexOf(medlem), new SoelvMedlem(
                        medlem.getMedlNr(), medlem.getPersonalia(), medlem.getInnmeldt(), medlem.getPoeng()));
            }

            // GULL-MEDLEMSSKAP
            else if (medlem.finnKvalPoeng() >= 75000){
                medlemmer.set(medlemmer.indexOf(medlem), new GullMedlem(
                        medlem.getMedlNr(), medlem.getPersonalia(), medlem.getInnmeldt(), medlem.getPoeng()));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        for (BonusMedlem medlem : medlemmer) {
            msg.append(medlem.toString()).append("\n");
        }
        return msg.toString();
    }

    public static void main(String[] args) {
        Medlemsarkiv arkiv = new Medlemsarkiv();
        LocalDate lokalDato = LocalDate.now();

        Personalia per = new Personalia("Per", "Hansen", "perhansen@gmail.com", "passord123");
        Personalia pål = new Personalia("Pål", "Hansen", "pålhansen@gmail.com", "passord_123");
        Personalia ola = new Personalia("Ola", "Hansen", "olahansen@gmail.com", "passord-123");

        int medlNr_per = arkiv.nyMedlem(per, lokalDato);
        int medlNr_pål = arkiv.nyMedlem(pål, lokalDato);
        int medlNr_ola = arkiv.nyMedlem(ola, lokalDato);

        System.out.println("--Info om medlemmer\n");
        System.out.println(arkiv.toString());

        System.out.println("Legger til poeng til medlemmene");
        System.out.println("Pål: 98000");
        System.out.println("Pål: 12300");
        System.out.println("Ola: 43250\n");
        arkiv.registrerPoeng(medlNr_per, 98000);
        arkiv.registrerPoeng(medlNr_pål, 12300);
        arkiv.registrerPoeng(medlNr_ola, 43250);

        System.out.println("--Info om medlemmer\n");
        System.out.println(arkiv.toString());

        System.out.println("Sjekker om medlemmer er gyldig for oppgradering\n");
        arkiv.sjekkMedlemmer();
        System.out.println("--Info om medlemmer\n");
        System.out.println(arkiv.toString());
    }
}
