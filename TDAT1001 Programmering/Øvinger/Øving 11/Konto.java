import java.io.*;
import javax.swing.*;

class Konto {
	double saldoMengde;
	double transaksjonMengde;

	String saldoFil = "saldo.txt";
	String transaksjonFil = "transaksjon.txt";

	void setSaldo() {
		double saldoMengde = 0.0;

		try {
			// Finner saldo summen
			BufferedReader saldoLeser = new BufferedReader(new FileReader(this.saldoFil));
			String saldoLine;

			if ((saldoLine = saldoLeser.readLine()) != null) {
				saldoMengde = Double.parseDouble(saldoLine);
			}
		}

		catch (IOException e){
			e.printStackTrace();
		}
		this.saldoMengde = saldoMengde;
	}

	void setTransaksjonSum() {
		// Finner total sum i transaksjons-fil
		double total = 0.0;
		String thisLine;

		try {
			// Leser transaksjons fil
			BufferedReader transaksjonLeser = new BufferedReader(new FileReader(transaksjonFil));

			while ((thisLine = transaksjonLeser.readLine()) != null) {
				String[] split = thisLine.split(" "); //Splitter uttak/inntak og transaksjonsverdi
				double transaksjonMengde;

				// Sjekker om det er rett format
				try {
					transaksjonMengde = Double.parseDouble(split[1]);

					//Sjekker om det er inntak eller uttak
					if (split[0].equals("I")) {
						total += transaksjonMengde;
					} else if (split[0].equals("U")) {
						total -= transaksjonMengde;
					}
				}

				catch (Exception e) {
					System.out.println("Feil i transaksjonsfil, ikke gyldig format");
				}
			}
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}

		this.transaksjonMengde = total;
	}

	void transaksjon() {
		setSaldo(); // Finner saldoen
		setTransaksjonSum(); // Finner total transaksjons-sum

		// Netto sum kan ikke være negativ
		if (this.saldoMengde + this.transaksjonMengde > 0) {
			try {
				FileWriter skriver = new FileWriter(saldoFil, false); 
				PrintWriter printSkriver = new PrintWriter(new BufferedWriter(skriver));

				String nySaldo = Double.toString(saldoMengde + transaksjonMengde);
				printSkriver.println(nySaldo);
				printSkriver.close();
			}
			
			catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Transaksjon ikke mulig, ikke nok midler");
		} 
	}

	// Metode for å enklere skrive til en fil
	void skrivTilFil(String filNavn, boolean overskriv, String msg, boolean linjeskift) {
		try {
			FileWriter skriver = new FileWriter(filNavn, overskriv); 
			PrintWriter printSkriver = new PrintWriter(new BufferedWriter(skriver));

			// Hvis det skal være linjeskift eller ikke
			if (linjeskift) {
				printSkriver.println(msg);
			} else {
				printSkriver.print(msg);
			}

			printSkriver.close(); // Tømmer bufferet
			
		}

		catch (IOException e) {
			e.printStackTrace();
		}	
	}

	// Nummer sjekk
	boolean isNumber(String tekst) {
		try {
			double nummer = Double.parseDouble(tekst);
		}
		// Vil kaste unntak hvis konverteringen ikke går bra, altså ikke tall
		catch (Exception e) {
			return false;
		}
		return true;
	}



	public static void main(String[] args) {
		Konto minKonto = new Konto();

		// Meny for transaksjon
		String transaksjonFil = "transaksjon.txt";

		boolean fortsett = true;
		while (fortsett) {
			minKonto.setSaldo(); // Oppdaterer saldoen
			String menyValg[] = {"Inn", "Ut", "Utfor", "Avslutt"};
			int valg = JOptionPane.showOptionDialog(null, "Saldo: " + minKonto.saldoMengde, "Konto", JOptionPane.OK_OPTION, -1, null, menyValg, menyValg[menyValg.length-1]);

			// Penger inn
			if (valg == 0) {
				String innValg = JOptionPane.showInputDialog(null, "Legg inn verdi");
				if (minKonto.isNumber(innValg)) { // Hvis det er et nummer
					minKonto.skrivTilFil(transaksjonFil, true, "I " + innValg, true);
				}
			}

			// Penger ut
			if (valg == 1) {
				String utValg = JOptionPane.showInputDialog(null, "Legg inn verdi");
				if (minKonto.isNumber(utValg)) { // Hvis det er et nummer
					minKonto.skrivTilFil(transaksjonFil, true, "U " + utValg, true);
				}
			}

			// Utfør transaksjon
			if (valg == 2) {
				minKonto.transaksjon(); 
				// minKonto.skrivTilFil(transaksjonFil, false, "", false); // Tømmer transaksjonsfil
				fortsett = false; // Avslutter loop
			}

			// Avslutt
			if (valg == 3) {
				fortsett = false; // Avslutter loop
			}
		}
	}
}
