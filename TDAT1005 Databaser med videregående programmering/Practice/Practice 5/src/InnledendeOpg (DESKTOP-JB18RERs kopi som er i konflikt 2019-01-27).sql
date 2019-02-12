/* Opgave A - oprette tabeller */
CREATE TABLE borretslag(
    navn VARCHAR(100) NOT NULL,
    adresse VARCHAR(100) NOT NULL,
    antallHus int NOT NULL,
    etableringsAar int(4) NOT NULL,

    CONSTRAINT PK_borretslag PRIMARY KEY(navn, adresse)
);

CREATE TABLE bygninger(
    borretslag VARCHAR(100) NOT NULL,
    adresse VARCHAR(100) NOT NULL,
    antallEtasjer INT NOT NULL,
    antallLeiligheter INT NOT NULL,

    CONSTRAINT PK_bygninger PRIMARY KEY(adresse, antallLeiligheter),
    FOREIGN KEY (borretslag) REFERENCES borretslag(navn)
);

CREATE TABLE leiligheter(
  borretslag VARCHAR(100) NOT NULL,
  bygning VARCHAR(100) NOT NULL,
  eier int,
  antallRom INT NOT NULL,
  størrelse INT NOT NULL,
  etasjeNr INT,
  leilighetsNr INT,

  CONSTRAINT PK_leiligheter PRIMARY KEY (bygning, leilighetsNr),
  FOREIGN KEY (borretslag) REFERENCES borretslag(navn)
  FOREIGN KEY (bygning) REFERENCES bygninger(adresse),
  FOREIGN KEY (eier) REFERENCES andelseiere(medlemsNr)
 );

CREATE TABLE andelseiere(
    borretslag VARCHAR(100) NOT NULL,
    medlemsNr int NOT NULL AUTO_INCREMENT,
    fornavn VARCHAR(100) NOT NULL,
    etternavn VARCHAR(100) NOT NULL,
    eier BIT DEFAULT 0,

    FOREIGN KEY (borretslag) REFERENCES borretslag(PK_borretslag),
    PRIMARY KEY (medlemsNr)
);

/* Oppgave e
Primærnøkler kan ikke være null.
Fremmednøkler må peke til en primærnøkkel eller UNIQUE.
Gir derfor ikke mening at fremmednøkkel kan være NULL.
*/

/* Oppgave f
 Sletting av borretslag vil ødelegge for alle
 Sletting av andelseier vil ødelegge for leiligheter
 Sletting av bygning vil ødelegge for leiligheter
 Bruker ingen fremmednøkler fra leiligheter.
 */