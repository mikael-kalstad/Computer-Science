import java.io.*;
import java.util.Arrays;
import static javax.swing.JOptionPane.*;

class Bokstaveringsalfabet {
	// Oppgave 1a - klassevariabler
	String bokstaveringsNavn;
	String alfabetet;
	String skilletegn;
	String[] alfabetSplittet;

	// Oppgave 1b - konstruktør nr.1
	Bokstaveringsalfabet(String bokstaveringsNavn, String alfabetet, String skilletegn) {
		this.bokstaveringsNavn = bokstaveringsNavn;
		this.alfabetet = alfabetet;
		this.skilletegn = skilletegn;

		// Splitter hvert ord i en tabell
 		alfabetSplittet = alfabetet.split(this.skilletegn);
	}
 	
 	// Oppgave 1c - konstruktør nr.2
 	Bokstaveringsalfabet(String bokstaveringsNavn, String filNavn) {
 		this.bokstaveringsNavn = bokstaveringsNavn;
 		les_BokstaveringsAlfabet_FraFil(filNavn);

 		// Splitter hvert ord i en tabell
 		alfabetSplittet = alfabetet.split(this.skilletegn);
 	}

 	// Oppgave 1d
 	public String toString() {
 		String msg = ""; // Lagrer i en msg
 		for (int i = 0; i < alfabetSplittet.length; i++) {
 			msg += alfabetSplittet[i] + " ";
 		}

 		return this.bokstaveringsNavn + "\n-------------------\n" + msg;
 	}

 	// Oppgave 1f
 	public boolean endreFonetiskBeskrivelse(String ord) {
 		// Går gjennom alle og finner bokstaven som matcher
 		for (int i = 0; i < alfabetSplittet.length; i++) {
 			if (alfabetSplittet[i].charAt(0) == ord.charAt(0)) {
 				alfabetSplittet[i] = ord;
 				tabellTilAlfabet(alfabetSplittet); // Oppdaterer alfabetet 
 				return true;
 			}
 		}
 		return false;
 	}

 	// Oppgave 1g - Sortering
 	public void sorter() {Arrays.sort(alfabetSplittet);}

 	// Oppgave 1h - Konvertere tekst til fonetisk ord
 	public String konvertereOrd(String tekst) {
 		tekst.toLowerCase();
 		String msg = "";

 		for (int i = 0; i < tekst.length(); i++) {
 			for (int j = 0; j < alfabetSplittet.length; j++) {
 				if (tekst.charAt(i) == alfabetSplittet[j].charAt(0)) {
 					msg += alfabetSplittet[j] + " "; 
 					break;
 				}else if (j == alfabetSplittet.length-1) msg += "ukjent ";
 			}
 		}
 		return msg;
 	}

 	// Oppgave 1i - Skriv alfabetet til fil med skilletegn
 	public void skrivAlfabetTilFil(String filNavn) {
 		try {
 			PrintWriter skriver = new PrintWriter(new BufferedWriter(new FileWriter(filNavn)));
	 		skriver.println(this.skilletegn);
	 		skriver.println(this.alfabetet);
	 		skriver.close(); // Lukker strømmen
 		}
 		catch (IOException e) {
 			e.printStackTrace();
 			System.out.println("Angitt fil ikke funnet");
 		}
 	}

 	// Oppgave 1j - leser bokstaveringsalfabetet inn fra fil
 	public boolean les_BokstaveringsAlfabet_FraFil(String filNavn) {
 		try {
 			// Oppretter leser til fil
 			BufferedReader fileReader = new BufferedReader(new FileReader(filNavn));

 			// Finner skilletegn
 			String skilletegn;
 			if ((skilletegn = fileReader.readLine()) != null) {
 				this.skilletegn = skilletegn;
 			} else {
 				System.out.println("Feil formatering i fil ved lesing av skilletegn");
 			}

 			// Finner alfabetet
 			String alfabetet;
 			if ((alfabetet = fileReader.readLine()) != null) {
 				this.alfabetet = alfabetet;
 			} else {
 				System.out.println("Feil formatering i fil ved lesing av alfabetet");
 			}
			
 			fileReader.close();
 		}

 		catch(FileNotFoundException e) {
 			e.printStackTrace();
 			System.out.println("Finner ikke angitt fil");
 			return false;
 		}
 		catch(IOException e) {
 			e.printStackTrace();
 			System.out.println("Ukjent I/O feil");
 			return false;
 		}
 		return true;
 	}

 	// Ekstra metoder
 	// Metode som tar inn en tabell og oppdaterer verdien til alfabetet
 	public void tabellTilAlfabet(String[] tabell) {
 		String msg = "";
 		for (int i = 0; i < tabell.length; i++) {
 			msg += alfabetSplittet[i] + this.skilletegn;
 		}
 		this.alfabetet = msg;
 	}

 	// Sjekker om filen finnes uten å gjøre noe annet, merk STATIC kan brukes i gui
 	public static boolean finnesFil(String filNavn) {
 		try {BufferedReader leser = new BufferedReader(new FileReader(filNavn));}
 		catch (FileNotFoundException e) {return false;}

 		return true;
 	}

 	public static void main(String[] args) {
 		String[] muligheter = {"Nytt alfabet", "Legg til ord", "Bokstaver ord", "skriv alfabeet til fil", "skriv alfabetet på skjerm", "sorter alfabetet", "Avslutt"};
 		final int NYTT_ALFABET = 0;
 		final int LEGG_TIL_ORD = 1;
		final int BOKSTAVER_ORD = 2;
		final int SKRIV_TIL_FIL = 3;
		final int LIST_ALFATBET = 4;
		final int SORTER = 5;
		final int AVSLUTT = 6;

		int valg = showOptionDialog(null, "Velg", "Eksempelfil.txt", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);

		Bokstaveringsalfabet ba = null;

		while (valg != AVSLUTT) {
			switch (valg) {
				case NYTT_ALFABET:
					// Oppgave 2a
					String[] nytt_alfabet_muligheter = {"Fra fil", "Manuelt"};

					int nytt_alfabet_valg = showOptionDialog(null, "Velg metode", "Eksamen juni 2017", YES_NO_OPTION, INFORMATION_MESSAGE, null, nytt_alfabet_muligheter, nytt_alfabet_muligheter[0]);

					final int NYTT_ALFABET_FIL = 0;
					final int NYTT_ALFABET_MANUELT = 1;

					switch (nytt_alfabet_valg) {
						case NYTT_ALFABET_FIL:
							String nytt_alfabet_filNavn = showInputDialog(null, "Filnavn", "fil.txt");
							if (finnesFil(nytt_alfabet_filNavn)) {
								String nytt_alfabet_bokstaveringsnavn = showInputDialog(null, "Bokstaveringsnavn", "NATO");
								// Oppretter objekt
								Bokstaveringsalfabet etAlfabet = new Bokstaveringsalfabet(nytt_alfabet_bokstaveringsnavn, nytt_alfabet_filNavn);
							} else showMessageDialog(null, "Angitt fil finnes ikke");
							
						break;

						case NYTT_ALFABET_MANUELT:
							String nytt_alfabet_alfabetet = showInputDialog(null, "Skriv inn det fonetiske alfabetet (med mellomrom)", "Alpha Bravo Charlie");
							String nytt_alfabet_skilletegn = showInputDialog(null, "Skriv inn skilletegn", "-,.+*");
							String nytt_alfabet_bokstaveringsnavn = showInputDialog(null, "Bokstaveringsnavn", "NATO");

							Bokstaveringsalfabet etAlfabet2 = new Bokstaveringsalfabet(nytt_alfabet_bokstaveringsnavn, nytt_alfabet_alfabetet, nytt_alfabet_skilletegn);
						break;
					}
				break;

				case BOKSTAVER_ORD:
					// Oppgave 2b
					String bokstaver_ord_input = showInputDialog(null, "Skriv inn ord du vil bokstavere", "ABBA");
					// showMessageDialog(null, konvertereOrd(bokstaver_ord_input));
				break;

				case SKRIV_TIL_FIL:
				break;

				case LIST_ALFATBET:
				break;

				case SORTER:

				break;

				default: break;
			}

			valg = showOptionDialog(null, "Velg", "Eksamen juni 2017", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
		}
 	}
}