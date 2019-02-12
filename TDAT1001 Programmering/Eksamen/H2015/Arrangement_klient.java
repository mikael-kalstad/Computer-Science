import java.io.*;
import static javax.swing.JOptionPane.*;

class Ovelse implements java.io.Serializable{
	// Klassevariabler
	String beskrivelse;
	String kjonn;

	// Konstruktør
	Ovelse(String beskrivelse, String kjonn) {
		this.beskrivelse = beskrivelse.trim();
		this.kjonn = kjonn.trim();
	}

	//Tilgangsmetoder
	String getBeskrivelse() {return this.beskrivelse;}
	String getKjonn() {return this.kjonn;}

	// Sammenligningsmetode
	boolean equals(Ovelse obj) {
		if (obj.beskrivelse.equals(this.beskrivelse) && obj.kjonn.equals(this.kjonn)) {
			return true;
		}
		return false;
	}

	public String toString() {return beskrivelse + " " + kjonn;}
}

class Idrettsgren implements java.io.Serializable{
	String navn; 
	Ovelse[] tabellOvelser;

	// Konstruktør med maksøvelser
	Idrettsgren(String navn, int maksOvelser) {
		this.navn = navn;
		this.tabellOvelser = new Ovelse[maksOvelser];
	}

	// Konstruktør med øvelser
	Idrettsgren(String navn, Ovelse[] tabellOvelser) {
		this.navn = navn;
		this.tabellOvelser = new Ovelse[tabellOvelser.length]; // Setter lengden på tabell
		
		// Dyp kopiering
		for (int i = 0; i < tabellOvelser.length; i++) {
			this.tabellOvelser[i] = tabellOvelser[i];
		}
	}

	boolean equals(Idrettsgren obj) {
		if (obj.navn.equals(this.navn)) {
			return true;
		}
		return false;
	}

	boolean nyOvelse(Ovelse obj) {
		// Hvis det er plass (ARRAYLIST??)
		// Hvis ingen øvelse har lik beskrivelse og kjønn
		// Return true hvis det går bra, ellers false

		for (int i = 0; i < this.tabellOvelser.length; i++) {
			if (this.tabellOvelser[i] != null && obj.equals(this.tabellOvelser[i])) {
				return false;
			} 
		}

		for (int i = 0; i < this.tabellOvelser.length; i++) {
			if (this.tabellOvelser[i] == null) {
				this.tabellOvelser[i] = obj;
				break;
			}
		}
		return true;
	}

	public String toString() {
		String msg = "";
		for (int i = 0; i < this.tabellOvelser.length; i++) {
			if (this.tabellOvelser[i] != null) {
				msg += this.tabellOvelser[i].toString() + "\n";
			} 
		}
		return this.navn + "\n" + msg;
	}
}

class Arrangement implements java.io.Serializable{
	String navn;
	Idrettsgren[] tabellIdrettsgren;

	Arrangement(String navn, int maksIdrettsgrener) {
		this.navn = navn;
		tabellIdrettsgren = new Idrettsgren[maksIdrettsgrener];
	}

	boolean equals(Arrangement obj) {
		if (obj.navn.equals(this.navn)) {
			return true;
		}
		return false;
	}

	boolean nyIdrettsgren(Idrettsgren obj) {
		// Hvis det er plass (ARRAYLIST??)
		// Hvis ingen øvelse har lik beskrivelse og kjønn
		// Return true hvis det går bra, ellers false
		for (int i = 0; i < this.tabellIdrettsgren.length; i++) {
			if (this.tabellIdrettsgren[i] != null && obj.equals(this.tabellIdrettsgren[i])) {
				return false;
			} 
		}

		for (int i = 0; i < this.tabellIdrettsgren.length; i++) {
			if (this.tabellIdrettsgren[i] == null) {
				this.tabellIdrettsgren[i] = obj;
				break;
			}
		}
		return true;
	}

	public String toString() {
		String msg = "";
		for (int i = 0; i < this.tabellIdrettsgren.length; i++) {
			if (this.tabellIdrettsgren[i] != null) {
				msg += this.tabellIdrettsgren[i].toString() + "\n";
			} 
		}
		return this.navn + "\n-------------------\n" + msg;
	}
}

class Arrangement_klient implements java.io.Serializable{
	public static boolean erNummer(String tekst) {
		try {	
			int nummer = Integer.parseInt(tekst);
		} 
		// Vil kaste unntak hvis konverteringen ikke går bra, altså ikke tall
		catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void skrivTilFil(String filNavn, Object obj) {
		try {
			ObjectOutputStream ut = new ObjectOutputStream(new FileOutputStream(filNavn));
			ut.writeObject(obj);
			ut.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Arrangement lesFraFil(String filNavn) {
		try {
			ObjectInputStream inn = new ObjectInputStream(new FileInputStream(filNavn));
			Arrangement etArrrangement = (Arrangement) inn.readObject();
			inn.close();
			return etArrrangement;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new Arrangement("", 2);
	}
	
	public static void main(String[] args) {
		// Tabell for muligheter ved menyvalg
		String[] muligheter = {"Nytt arrangement", "Arrangementer", "Avslutt"};
		final int NYTT_ARRANGEMENT = 0;
		final int ARRANGEMENTER = 1;
		final int AVSLUTT = 2;


		boolean fortsett = true;
		while(fortsett) {
			int valg = showOptionDialog(null, "Arrangement", "Velg", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);

			switch(valg) {
				case NYTT_ARRANGEMENT:
					// Opprette nytt arrangement
					String arrangementNavn_input = showInputDialog("Velg navn paa arrangementet");
					String maksIdrettsgrener_input = showInputDialog("Angi maks antall idrettsgrener i arrangementet");

					if (erNummer(maksIdrettsgrener_input)) {
					} else {showMessageDialog(null, "Feil ved innskriving, maa vere et nummer");}

					// Lager nytt arrangement objekt
					int maksIdrettsgrener_input_integer = Integer.parseInt(maksIdrettsgrener_input);
					Arrangement etArrrangement = new Arrangement(arrangementNavn_input, maksIdrettsgrener_input_integer);

					// Nytt arrangement meny
					String nytt_arrangement_meny[] = {"Ny idrett", "Lag nytt arrangment", "Avslutt"};
					String arrangment_msg = "Navn: " + arrangementNavn_input + "\nMaks idrettsgrener: " + maksIdrettsgrener_input;

					// variabler for meny-valg
					final int NY_IDRETT = 0;
					final int LAG_NYTT_ARRANGEMENT = 1;
					final int AVSLUTT_ARRANGEMENT = 2;

					boolean lag_nytt_arrangment = true;

					while (lag_nytt_arrangment) {
						int nytt_arrangement_valg = showOptionDialog(null, "Nytt arangement\n" + arrangment_msg, "Velg", YES_NO_OPTION, -1, null, nytt_arrangement_meny, nytt_arrangement_meny[0]);
						
						switch (nytt_arrangement_valg) {
							case NY_IDRETT:
								// Opprette nye idrettsgren
								String idrettNavn_input = showInputDialog("Velg navn på idretten");
								String maksOvelser_input = showInputDialog("Velg maks antall ovelser");

								if (erNummer(maksOvelser_input)) {
								} else {showMessageDialog(null, "Feil ved innskriving, maa vere et nummer");}

								// Lager idrett objekt
								int maksOvelser_input_integer = Integer.parseInt(maksOvelser_input);
								Idrettsgren enIdrett = new Idrettsgren(idrettNavn_input, maksOvelser_input_integer);

								// Legge til så mange øvelser som ønsket
								boolean flere_ovelser = true;
								while (flere_ovelser) {
									// Opprette nye ovelser
									String beskrivelse_input = showInputDialog("Velg navn på ovelsen");
									String kjonn_input = showInputDialog("Velg kjonn for ovelsen");

									// Hvis et kjønn er skrevet inn av bruker
									if (kjonn_input.toLowerCase().trim().matches("gutt|mann|kvinne|jente")) {
										// Lager øvelse objekt og legger til idrett
										enIdrett.nyOvelse(new Ovelse(beskrivelse_input, kjonn_input));
									} else {showMessageDialog(null, "Feil ved innskriving, maa vere et kjonn");}

									int flereOvelser = showConfirmDialog(null, "Flere ovelser?", "Nytt arrangement", YES_NO_OPTION);
									// JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
									if (flereOvelser == NO_OPTION) {
										flere_ovelser = false;
										etArrrangement.nyIdrettsgren(enIdrett);
									}
								}

							break;

							case LAG_NYTT_ARRANGEMENT:
								lag_nytt_arrangment = false;
								// LAGRE OBJEKT TIL FIL!
								skrivTilFil("arrangementer.ser", etArrrangement);
							break;

							case AVSLUTT_ARRANGEMENT:
								lag_nytt_arrangment = false;
							break;

							
					}
				}
				break;

				case ARRANGEMENTER:
					// Les fra fil og vis info
					showMessageDialog(null, lesFraFil("arrangementer.ser").toString());
				break;

				// Avslutt hovedmeny
				case AVSLUTT:
					fortsett = false;
				break;
			}
		}
	}
}