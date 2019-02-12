class Ord {
	// Oppgave 2a - klassevariabler
	private String ord;
	private String[] def;

	// Oppgave 2b - konstruktør
	public Ord(String ord, String[] def) {
		this.ord = ord;
		this.def = def;
	}

	// Oppgave 2c - tilgangsmetoder
	// Merk: antar at setmetoder ikke er nødvendig siden kun tilgangsmetoder ble spesifisert
	public String getOrd() {return this.ord;}
	public String[] getDef() {return this.def;}

	// Oppgave 2d - equals metode
	public boolean equals(Object o) {
		// Sjekk om det er et objekt av klassen Ord
		if (!(o instanceOf Ord)) {return false;}

		// Sjekk om objektet er likt dette
		else if(o == this) {return true;}

		// Cast objektet til et ord
		Ord temp = (Ord) o;

		//Sjekk om ordene er like
		return this.ord.equals(temp.getOrd());
	}

	// Oppgave 2e - toString metode
	public String toString() {
		// Lager en "message" og legger til hver definisjon før den retuneres
		String msg = this.ord + ":\n";

		for (int i = 0; i < def.length; i++) {
			msg += (i+1) + ". " + def[i] + "\n";
		}
		return msg;
	} 


	// Oppgave 2f - hjelpemetode for å utvide tabell (privat)
	private void utvidTabell() {
		// Lager en midlertidig tabell med lengden av def + 1
		String temp[] = new String[def.length++];

		// Dyp kopering av def tabell
		for (int i = 0; i < def.length; i++) {
			temp[i] = def[i];
		}

		// Lager ny tabell med en ekstra i lengde
		def = new String[temp.length];

		// Dyp kopering av temp tabell
		for (int i = 0; i < temp.length; i++) {
			def[i] = temp[i];
		}
	}

	// Oppgave 2e - metode for å legge til flere definisjoner
	public boolean leggTilDefinisjon(String nyDefinisjon) {
		for (int i = 0; i < def.length; i++) {
			// Sjekker om definisjonen finnes fra før
			if (def[i].equals(nyDefinisjon)) {return false;}
		}

		// Utvider tabell for å gjøre plass til ny def
		utvidTabell();

		// Legger til ny def på siste plassen i tabell
		def[def.length--] = nyDefinisjon;
		return true; // Returnerer ny def er lagt til uten likheter
	}
}