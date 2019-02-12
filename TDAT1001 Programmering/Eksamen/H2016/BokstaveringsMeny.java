import static javax.swing.JOptionPane.*;

class BokstaveringsMeny {
	public static void main (String[] args){

		String[] muligheter = {"Nytt alfabet","Legg til ord", "Bokstaver ord", "Skriv alfabet til fil", "Skriv alfabetet på skjerm","Sorter alfabetet", "Avslutt"};
		final int NYTT_ALFABET = 0;
		final int LEGG_TIL_ORD = 1;
		final int BOKSTAVER_ORD = 2;
		final int SKRIV_TIL_FIL = 3;
		final int LIST_ALFATBET = 4;
		final int SORTER = 5;
		final int AVSLUTT = 6;

		int valg = showOptionDialog(null, "Velg", "Eksamen juni 2017", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
			
		Bokstaveringsalfabet ba = null;

		while (valg != AVSLUTT){
			switch (valg){
				case NYTT_ALFABET:
					/* OPPGAVE 2 a) skal inn her */
					String[] muligheterNyttAlfabet = {"Fra fil", "Skrive inn direkte", "Avslutt"};
					int valgNyttAlfabet = showOptionDialog(null, "Velg hvordan du vil oprette nytt alfabet", "Eksamen juni 2017", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheterNyttAlfabet, muligheterNyttAlfabet[0]);
					final int FRA_FIL = 0;
					final int MANUELLT = 1;

					switch (valgNyttAlfabet) {
						case FRA_FIL: 
							String alfabetNavn = showInputDialog(null, "Skriv inn navn på alfabetet");
								if (errorChecking(alfabetNavn)) break;
							String filnavn = showInputDialog(null, "Skriv inn filnavn");
								if (errorChecking(filnavn)) break;
							ba = new Bokstaveringsalfabet(alfabetNavn, filnavn);
						break;

						case MANUELLT:
							String alfabetNavn2 = showInputDialog(null, "Skriv inn navn på alfabetet");
								if (errorChecking(alfabetNavn2)) break;
							String alfabetetManuelt = showInputDialog(null, "Skriv inn alfabetet med mellomrom mellom hvert ord \n F.eks. slik: Alpha Bravo Charlie");
								if (errorChecking(alfabetetManuelt)) break;
							ba = new Bokstaveringsalfabet(alfabetNavn2, " ", alfabetetManuelt);	
							System.out.println(ba);
						break;
					}
				break;

				case LEGG_TIL_ORD:
				break;

				case BOKSTAVER_ORD:
					/* OPPGAVE 2 b) skal inn her*/
					String bokstavering = showInputDialog(null, "Velg hvilke bokstaver du vil bokstavere \n F.eks. ABBA eller SI");
						if (errorChecking(bokstavering)) break;
					showMessageDialog(null, ba.bokstavering(bokstavering));
				break;

				case SKRIV_TIL_FIL: // ikke en del av oppgaven
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

	public static boolean isString(String ord) {
		return ord.matches("[^0-9]+");
	}

	public static boolean errorChecking(String ord) {
		if (ord.length() == 0) {
			showMessageDialog(null, "Skrivefeltet kan ikke være tomt"); 
			return true;
		} 
		// Antar at tall ikke er gyldig som navn på alfabetet eller et navn på en bokstav
		// F.eks. Alpha er gyldig men Alpha2 er ikke gyldig
		else if (!isString(ord)) {
			showMessageDialog(null, "Kan ikke inneholde tall"); 
			return true;
		} 
		return false;
	}
}
