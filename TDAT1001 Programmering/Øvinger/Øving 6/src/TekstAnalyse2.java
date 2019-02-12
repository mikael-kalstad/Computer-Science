class TekstAnalyse2 {
	private String tekst;
	private int[] antallTegn = new int[30];

	// Konstruktør
	TekstAnalyse2(String tekst) {
		// Gjør om alle bokstavene til store bokstaver
		String nyTekst = tekst.toUpperCase();

		this.tekst = nyTekst; // Hovedkonstruktøren

		// Legger inn antall ganger alle bokstavene forekommer i antallTegn arrayet
		for (int i = 0; i < tekst.length(); i++) {
			int index = finnIndex(nyTekst.charAt(i));
			antallTegn[index]++;
		}
	}

	// Finn index til bokstaven, altså hvor den skal ligge i antallTeng
	int finnIndex(char bokstav) {
		int index = 29; // Antar at indexen er 29 hvis det ikke er bokstav
		int bokstavVerdi = (int) bokstav;

		for (int x = 0; x < 29; x++) {
			if (bokstavVerdi >= 65 && bokstavVerdi <= 90) {
				index = (bokstavVerdi - 65);
				break; // For å unngå at programmet kjører videre når vi har funnet index
			}
			if (bokstavVerdi == 198) {index = 26;} // Æ
			if (bokstavVerdi == 216) {index = 27;} // Ø
			if (bokstavVerdi == 197) {index = 28;} // Å
		}
		return index;
	}


	int totalAntall () {return tekst.length();}

	String forskjelligeBokstaver() {
		int antall = 0; 
		for (int i = 0; i < antallTegn.length-1; i++) {
			if (antallTegn[i] > 0) {
				antall++;
			}
		}
		return "Det er " + antall + " forskjellige bokstaver";
	}

	String ikkeBokstav() {
		int tegn = antallTegn[29]; // Finner antall tegn som ikke er bokstaver
		double prosent = ((double)tegn / (double)totalAntall()*100);
		java.text.DecimalFormat df = new java.text.DecimalFormat("##.#"); // Spesifiserer antall desimaler
		return df.format(prosent) + "% av teksten er ikke bokstav";
	}

	String antallAvBokstav(char bokstav) {
		int index = finnIndex(bokstav);
		return "Antall av " + bokstav + " : " + antallTegn[index];
	}


	String flestGanger() {
		int storst = antallTegn[0]; // Man kan anta at det første er størst først og fremst
		int index = 0; // For å holde stor på hvilken index er storst
		String bokstaver = "";

		for (int i = 1; i < antallTegn.length-1; i++) { // .length-1 for å unngå de andre symbolene
			if (antallTegn[i] > storst) {
				storst = antallTegn[i];
				index = i;
			}
		}

		// Loop for å finne eventuelle bokstaver som er samme antall ganger
		for (int i = 0; i < antallTegn.length-1; i++) { 
			if (antallTegn[i] == storst && i != index) {
				if (i == 26) {bokstaver += 198;} // Æ
				if (i == 27) {bokstaver +=216;} // Ø
				if (i == 28) {bokstaver += 197;} // Å
				else {bokstaver += (char)(i+65);}
			}
		}

		bokstaver += (char)(index+65); // Den bokstaven som kom flest ganger før siste for loop legges til 
		bokstaver = sorter(bokstaver); // Sorterer bokstavene alfabetisk
		return "Bokstaven(e) som forekommer flest ganger: " + bokstaver;
	}

	String sorter(String tekst) {
		char[] bokstaver = tekst.toCharArray(); // String til array av datatypen char
		java.util.Arrays.sort(bokstaver); // Bruker Arrays classens funskjon sort
		String sortert = new String(bokstaver); // Konverterer fra array til String
		return sortert;
	}


	// TEST HER
	public static void main(String[] args) {
		TekstAnalyse2 test = new TekstAnalyse2("KKSSAANNMMJJ");
		System.out.println("Det er totalt " + test.totalAntall() + " tegn");
		System.out.println(test.forskjelligeBokstaver());
		System.out.println(test.ikkeBokstav());
		System.out.println(test.antallAvBokstav('B'));
		System.out.println(test.flestGanger());
	}
}
