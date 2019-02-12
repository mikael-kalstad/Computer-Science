/* Opgave A - oprette tabeller */
CREATE TABLE borretslag(
    navn VARCHAR(100) NOT NULL,
    adresse VARCHAR(100) NOT NULL,
    antallHus int NOT NULL,
    etableringsAar int(4) NOT NULL,

    PRIMARY KEY(navn)
);

CREATE TABLE bygninger(
    borretslag VARCHAR(500) NOT NULL,
    adresse VARCHAR(100) NOT NULL,
    antallEtasjer INT NOT NULL,
    antallLeiligheter INT NOT NULL,

    PRIMARY KEY(adresse),
    FOREIGN KEY (borretslag) REFERENCES borretslag(navn)
);

CREATE TABLE leiligheter(
    bygning VARCHAR(100) NOT NULL,
    eier int,
    antallRom INT NOT NULL,
    størrelse INT NOT NULL,
    etasjeNr INT,
    leilighetsNr INT,

    CONSTRAINT PK_leiligheter PRIMARY KEY (størrelse, leilighetsNr),
    FOREIGN KEY (bygning) REFERENCES bygninger(borretslag),
    FOREIGN KEY (eier) REFERENCES andelseiere(medlemsNr)
);

CREATE TABLE andelseiere(
    borretslag VARCHAR(100) NOT NULL,
    medlemsNr int NOT NULL AUTO_INCREMENT,
    fornavn VARCHAR(100) NOT NULL,
    etternavn VARCHAR(100) NOT NULL,
    eier BIT DEFAULT 0,

    FOREIGN KEY (borretslag) REFERENCES borretslag(name),
    PRIMARY KEY (medlemsNr)
);