class Ordbok implements java.io.Serializeable {
	private String ordbokNavn;
	private Ord[] ordbok;
	private int antallReg;
	private final int MAKS_ANTALL_ORD = 10;
	private String filnavn = "ordliste.ser";

	// Oppgave 2a - konstruktør
	public Ordbok(String ordbokNavn) {
		// Bruker hjelpemetode for å sjekke om det finnes relevant data på fil "ordliste.ser"
		if (!(lesOrdBokFraFil(this.filnavn))) {
			this.antallReg = 0;
			this.ordbok = new Ord[MAKS_ANTALL_ORD];
		}
		this.ordbokNavn = ordbokNavn;
	}

	// Oppgave 2b - registering av nytt ord
	public boolean regNyttOrd(Ord ord) {
		// Antar i denne metoden at Ord objekter lagres sekvensielt i tabell
		// Altså de legges oppå hverandre fra start og hvis det er ledige plaser vil disse ha verdien null

		// Sjekker om ord finnes fra før
		for (int i = 0; i < this.ordbok.length; i++) {
			// Bruker equals metode lagd i oppg.2 til å sjekke for samme ord
			if (this.ordbok[i].equals(ord)) {return false};

			// Hvis det ikke er flere objekter, kan jeg legge inn nytt ord på denne plassen
			else if (this.ordbok[i] == null) {
				this.ordbok[i] = ord;
				return true;
			}
		}
	}

	// Oppgave 2c - legge til ny definisjon
	public boolean leggTilDefinisjon(String ord, String definisjon) {
		// Finner ord objektet i tabell
		for (int i = 0; i < this.ordbok.length; i++) {
			// Sjekker om ordene er like
			if (this.ordbok[i].getOrd().equals(ord)) {
				this.ordbok[i].leggTilDefinisjon(definisjon);
				return true;
			}
		}
		return false; // Om ikke annet returner false
	}

	// Oppgave 2d - sorteringsmetode
	public Ord[] sorter() {
		// Sorterings algoritme her....
	}

	// Oppgave 2e - metode for å sjekke om ord finnes i tabell
	public Ord getOrd(String sokeStreng) {
		for (int i = 0; i < this.ordbok.length; i++) {
			if (this.ordbok[i].equals(sokeStreng)) {return this.ordbok[i];}
		}
		return null;
	}

	// Oppgave 2f - metode for å lese fra fil
	public boolean lesOrdBokFraFil(String filnavn) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filnavn)); // Oppretter filstrøm som kan lese objekter fra fil
			Ordbok tempOrdbokTabell[] = (Ordbok) ois.readObject(); // Leser objekt hvis det finnes

			this.ordbok = new Ord[tempOrdbokTabell.length]; // Angir lengde på this.ordbok
			
			// Dyp kopering av tabell fra fil
			for (int i = 0; i < tempOrdbokTabell.length) {
				this.ordbok[i] = tempOrdbokTabell[i];
			}

			close(); // Lukker filstrømmen, dette er viktig!
		}

		// "Catcher" ulike unntak som kan kastes og printer hele feilmeldingen
		catch(StreamCorruptedException e) {e.printStackTrace(); return false;}
		catch(SecurityException e) {e.printStackTrace(); return false;}
		catch(NullPointerException e) {e.printStackTrace(); return false;}
		catch(FileNotFoundException e) {e.printStackTrace(); return false;}
		catch(OptionalDataException e) {e.printStackTrace(); return false;}
		catch(ClassNotFoundException e) {e.printStackTrace(); return false;}
		catch(IOException e) {e.printStackTrace(); return false;}

		return true; // Hvis ingenting "catcher" returnerer true
	}
}