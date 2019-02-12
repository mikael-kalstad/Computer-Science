class Eksamen_H2017{
  public static void main(String[] args){
	String[] muligheter = {"Legg til ord", "Legg til definisjon", "Avslutt"};
	final int LEGG_TIL_ORD = 0;
	final int LEGG_TIL_DEFINISJON = 1;
	final int AVSLUTT = 2;

	int valg = showOptionDialog(null, "Velg", "Eksamen des 2017",  YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
	
	String navn = "Ordboka";
	Ordbok ordbok = new Ordbok(navn, 10);

	while (valg != AVSLUTT){
		switch (valg){
			case LEGG_TIL_ORD:
			/* OPPGAVE 4a) skal inn her */
			String nyttOrd = showInputDialog("Skriv inn ord");
			if (!(ordbok.regNyttord(nyttOrd.trim()))) showMessageDialog(null, "Ord allerede registrert");
			break;

			case LEGG_TIL_DEFINISJON:
			/* OPPGAVE 4b) skal inn her */
			String nyttOrd = showInputDialog("Skriv inn ord");
			String nyDefinisjon = showInputDialog("Skriv inn ny definisjon");
			if(!(ordbok.nyDefinisjon(nyttOrd.trim(), nyDefinisjon.trim()))) showMessageDialog(null, "Ord finnes ikke, eller definisjonen er allerede registrert");
			break;

			default: break;
		}
		valg = showOptionDialog(null, "Velg", "Eksamen des 2017", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
	}
  }
}
