package dyrehage;

public interface SkandinaviskeRovdyr {
    String getNavn();
    int getFdato();
    int getAlder();
    String getAdress();
    void flytt(String nyAdresse);
    String skrivUtInfo();
    int getAntKull();
    void leggTilKull(int antall);
    void leggTilNyttKull();
}
