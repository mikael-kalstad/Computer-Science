/* Opgave A - oprette tabeller */
CREATE TABLE borretslag(
    navn VARCHAR(100) NOT NULL,
    adresse VARCHAR(100) NOT NULL,
    antallHus int NOT NULL,
    etableringsAar int(4) NOT NULL,
    CONSTRAINT PK_borretslag PRIMARY KEY(navn, adresse)
)

CREATE TABLE bygninger(
    adresse VARCHAR(100) NOT NULL,
    antallEtasjer INT NOT NULL,
    antallLeiligheter INT NOT NULL,
    CONSTRAINT PK_bygninger PRIMARY KEY(adresse, antallLeiligheter)
)

CREATE TABLE andelseiere(
    medlemsNr int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fornavn VARCHAR(100) NOT NULL,
    etternavn VARCHAR(100) NOT NULL,
    eier BIT DEFAULT 0
)

CREATE TABLE leiligheter(
    eier int,
    antallRom INT NOT NULL,
    størrelse INT NOT NULL,
    etasjeNr INT NOT NULL,
    leilighetsNr INT NOT NULL,
    FOREIGN KEY (eier) REFERENCES andelseiere(medlemsNr)
)

/* Oppgave B finne primærnøkkel */
/*
ansatt: primærnøkkel = ansatt_nr
    - Unik for alle ansatte


*/