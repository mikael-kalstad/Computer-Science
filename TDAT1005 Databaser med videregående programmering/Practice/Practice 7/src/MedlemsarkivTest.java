import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MedlemsarkivTest {
    Medlemsarkiv arkiv = new Medlemsarkiv();
    LocalDate lokalDato = LocalDate.now();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Personalia per = new Personalia("Per", "Hansen", "perhansen@gmail.com", "passord123");
        Personalia pål = new Personalia("Pål", "Hansen", "pålhansen@gmail.com", "passord_123");
        Personalia ola = new Personalia("Ola", "Hansen", "olahansen@gmail.com", "passord-123");

        arkiv.nyMedlem(per, lokalDato);
        arkiv.nyMedlem(pål, lokalDato);
        arkiv.nyMedlem(ola, lokalDato);
    }

    @org.junit.jupiter.api.AfterAll
    void tearDown() {
        arkiv = null;
    }

    @org.junit.jupiter.api.Test
    void nyMedlem() {
        Personalia pernille = new Personalia("Pernille", "Hansen", "pernillehansen@gmail.com", "katt");
        int medlNr = arkiv.nyMedlem(pernille, lokalDato);

        int antallPoeng_result = arkiv.finnPoeng(medlNr, "katt");
        assertEquals(0, antallPoeng_result);
    }

    @org.junit.jupiter.api.Test
    void finnPoeng() {
        System.out.println(arkiv.medlemmer.toString());
    }

    @org.junit.jupiter.api.Test
    void registrerPoeng() {
        System.out.println(arkiv.medlemmer.toString());
    }
}