import java.io.*;

public class Bokstaveringsalfabet {
	// Oppgave 2a - klassevariabler
	private String navn;
	private String skilletegn;
	private String[] alfabetet;

	// Oppgave 2b - Konstruktør 1
	public Bokstaveringsalfabet(String navn, String skilletegn, String alfabetet) {
		this.navn = navn;
		this.skilletegn = skilletegn;
		this.alfabetet = alfabetet.split(skilletegn);
	}

	// Oppgave 2c - Konstruktør 2
	public Bokstaveringsalfabet(String navn, String filnavn) {
		this.navn = navn;
		this.alfabetet = lesAlfabetFraFil(filnavn);
	}	

	// Oppgave 2d - toString metode
	public String toString() {
		StringBuilder msg = new StringBuilder();
		for (int i = 0; i < alfabetet.length; i++) {
			msg.append(alfabetet[i] + " ");
		}
		return msg.toString();
	}

	// Oppgave 2e - registrer nytt ord
	/*
	Denne metoden skal registrere et nytt ord i alfabetet hvis det ikke allerede finnes i alfabetet. 
	F.eks. regNyttOrd("Alfa") og Alpha finnes i alfabetet, vil det ikke registreres
	Hvis alt går bra vil true returneres, false hvis det er allerede registrert.
	*/
	public boolean regNyttOrd(String ord) {
		if (ord.length() < 1) return false;

		char ordBokstav = ord.toLowerCase().charAt(0); // Henter første bokstav
		char alfabetetBokstav; 
		for (int i = 0; i < alfabetet.length; i++) {
			alfabetetBokstav = alfabetet[i].toLowerCase().charAt(0); // Henter første bokstav
		
			// Sjekker om bokstavene er like
			if (ordBokstav == alfabetetBokstav) return false;
		}
		utvidTabell(); // Egen hjelpemetode for å utvide tabell
		alfabetet[alfabetet.length-1] = ord;
		sorter();
		return true;
	}


	// Oppgave 2f - endre fonetisk beskrivelse
	/*
	Denne metoden skal endre den fonetiske beskrivelsen i alfabetet
	Man trenger kun å skrive inn den nye beskrivelsen så tar metoden av seg resten
	Vil returnere true hvis alt gikk bra og beskrivelsen bytter, false ellers.
	*/
	public boolean endreBeskrivelse(String ord) {
		if (ord.length() < 1) return false; // Lengde mindre enn 1

		char ordBokstav = ord.toLowerCase().charAt(0); // Henter første bokstav
		char alfabetetBokstav; 
		for (int i = 0; i < alfabetet.length; i++) {
			alfabetetBokstav = alfabetet[i].toLowerCase().charAt(0); // Henter første bokstav
			
			// Sjekker om bokstavene er like og at ordene ikke er like
			if (ordBokstav == alfabetetBokstav) { 
				if (ord.equals(alfabetet[i])) return false;
				alfabetet[i] = ord; // Erstatter ordet
				break; // "Hopper" ut av loopen
			}
		}
		return true;
	}

	// Oppgave 2g - alfabetisk sortering
	public void sorter() {
		// Avslutt metode hvis det finnes bare ett eller mindre ord i alfabetet
		if (alfabetet.length <= 1) return; 

		for (int i = 0; i < alfabetet.length; i++) {
			int index = i; // For å vite hvilken index som skal eventuelt byttes
			for (int j = i+1; j < alfabetet.length; j++) {
				if (alfabetet[index].compareTo(alfabetet[j]) > 0) index = j;
			}

			// Bytter plass
			String temp = alfabetet[i];
			alfabetet[i] = alfabetet[index];
			alfabetet[index] = temp;
		}
		// Man kan også bruke Array.sort() metoden som gjør det enklere
	}

	// Oppgave 2h - bokstavering av ord
	public String bokstavering(String ord) {
		String msg = "";
	
		for (int i = 0; i < ord.length(); i++) {
			boolean checker = false;
			for (int j = 0; j < alfabetet.length; j++) {
				// Tar ikke hensyn til stor og liten bokstav
				if (ord.toLowerCase().charAt(i) == alfabetet[j].toLowerCase().charAt(0)) {
					checker = true;
					msg += alfabetet[j] + " ";
					break;
				}
			}
			if (checker == false) msg += "Ukjent ";
		}
		return msg;
	}

	// Oppgave 2i - Skriv til fil 
	public boolean skrivTilFil(String filnavn) {
		try {
			// False for å overskrive innhold i fil hvis den finnes
			FileWriter skriver = new FileWriter(filnavn, false);
			PrintWriter printSkriver = new PrintWriter(new BufferedWriter(skriver));

			String msg = "";
			for (int i = 0; i < alfabetet.length; i++) {
				if (i == alfabetet.length -1) msg += alfabetet[i];
				else msg += alfabetet[i] + skilletegn;
			}

			printSkriver.print(skilletegn + "\n" + msg);
			printSkriver.close(); // Lukker datastrømmen
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Noe gikk galt under skriving til fil");
			return false;
		}
		return true;
	}

	// Oppgave 2j - Les fra fil
	/*
	Denne metoden vil prøve å lese fra en fil og returnere alfabetet 
	NB! Alfabetet som returneres er uten skilletegn.
	*/
	public String[] lesAlfabetFraFil(String filnavn) {
		String skilletegn = null;
		String alfabetet = null;
		boolean checker = true;
		final String[] EMPTY_ARR = {}; // Returneres hvis det skjer noe feil under lesing fra fil

		try {
			// Åpner datastrøm med buffer
			BufferedReader bufferLeser = new BufferedReader(new FileReader(filnavn)); 

			// Leser fra fil og sjekker at linjen ikke er tom
			if ((skilletegn = bufferLeser.readLine()) == null || skilletegn.length() > 1) {
				System.out.println("Feil formatering på fil"); 
				checker = false;
			}

			if ((alfabetet = bufferLeser.readLine()) == null) {
				System.out.println("Feil formatering på fil"); 
				checker = false;
			}

			bufferLeser.close(); // Lukker datastrømmen
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("--------- Fil ikke funnet ------------");
		}

		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Uventet IO feil");
		}

		if (skilletegn == null || alfabetet == null || checker == false) return EMPTY_ARR;
		this.skilletegn = skilletegn;
		return alfabetet.split(skilletegn);
	}

	/*
	----------------
	 Hjelpemetoder
	----------------
	*/

	// Egen hjelpemetode for å utvide tabell
	private void utvidTabell() {
		String[] temp = new String[alfabetet.length]; // Mellom lagring
		for (int i = 0; i < alfabetet.length; i++) temp[i] = alfabetet[i]; // Dyp kopering

		alfabetet = new String[alfabetet.length+1]; // Utvider tabell
		for (int i = 0; i < temp.length; i++) alfabetet[i] = temp[i]; // Kopierer tilbake
	}

	public static void main(String[] args) {
		Bokstaveringsalfabet test = new Bokstaveringsalfabet("NATO", "alfabetet.txt");
		test.sorter();
		System.out.println(test);

		test.endreBeskrivelse("Berlin");
		System.out.println(test);

		System.out.println(test.bokstavering("ABBA"));

		test.skrivTilFil("test.txt");
	}
}