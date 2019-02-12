import javax.swing.*;
import java.util.ArrayList;

class Person {
	private final String fornavn;
	private final String etternavn;
	private final int fodselsår;


	Person (String fornavn, String etternavn, int fodselsår) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fodselsår = fodselsår;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public int getFodselsår() {
		return fodselsår;
	}

	public String toString() {
		return "Navn: " + fornavn + " " + etternavn + "\n" +
		"Fødselsår: " + fodselsår;
	}
}

class ArbTaker {
	int arbtakernr;
	int ansettelseår;
	int månedslonn;
	int skatteprosent;
	Person personalia;

	// Årstall
	java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
	int år = kalender.get(java.util.Calendar.YEAR);

	ArbTaker(Person personalia, int arbtakernr, int ansettelseår, int månedslonn, int skatteprosent) {
		this.personalia = personalia;
		this.arbtakernr = arbtakernr;
		this.ansettelseår = ansettelseår;
		this.månedslonn = månedslonn;
		this.skatteprosent = skatteprosent;
	}

	// Set metoder
	void setArbtakernr(int arbtakernr) {
		this.arbtakernr = arbtakernr;
	}

	void setAnsattelseår(int ansettelseår) {
		this.ansettelseår = ansettelseår;
	} 

	void setMånedslonn(int månedslonn) {
		this.månedslonn = månedslonn;
	}

	void setSkatteprosent(int skatteprosent) {
		this.skatteprosent = skatteprosent;
	}


	// Get metoder
	String getNavn() {
		return personalia.getFornavn() + " " + personalia.getEtternavn();
	}

	int getAlder() {
		return år - personalia.getFodselsår();
	}

	int getArbtakernr() {
		return arbtakernr;
	}

	int getAnsettelsear() {
		return ansettelseår;
	}

	int getMånedslonn() {
		return månedslonn;
	}

	int getSkatteprosent() {
		return skatteprosent;
	}

	// Andre metoder
	double skattPerMåned() {
		double skatt = Math.round((double)månedslonn * ((double)skatteprosent/100)*10);
		return (skatt/10);
	}

	double skattPerAr() {
		double skattDesember = Math.round(skattPerMåned() / 2 *10)/10;
		return skattPerMåned() * 10 + skattDesember;
	}

	double bruttolonn() {
		return (double)månedslonn*12 - skattPerAr();
	}

	
	int antallAr() {
		return år - ansettelseår;
	}

	boolean ansattAr(int år) {
		int faktiskAr = antallAr();
		if (år == faktiskAr) {
			return true;
		}
		return false;
	}

	public String toString() {
		return 
		"Navn: " + getNavn() + "\n" +
		"Alder: " + getAlder() + "\n" + 
		"Arbtakernr: " + getArbtakernr() + "\n" +
		"Ansattelseaar: " + getAnsettelsear() + "\n" + 
		"Maanedslonn: " + getMånedslonn() + "\n" + 
		"skatteprosent: " + getSkatteprosent() + "\n" +

		"---------------------------------------------\n" +

		"Skatt per maaned: " + skattPerMåned() + "\n" +
		"Skatt per aar: " + skattPerAr() + "\n" + 
		"bruttolonn: " + bruttolonn() + "\n" +
		"Antall aar i bedriften: " + antallAr() + "\n";
	}
}

class JobbMeny{
	public static void main(String[] args) {
		Person mikael = new Person("Mikael", "Kalstad", 1999);
		ArbTaker mikaelAnsatt = new ArbTaker(mikael, 12345, 2016, 12340, 23);
		
		Person ola = new Person("Ola", "Nordmann", 1956);
		ArbTaker olaAnsatt = new ArbTaker(ola, 12346, 1957, 9050, 67);

		boolean fortsett = true;
		while(fortsett) {
			String menyValg[] = {"Ansatte", "Avslutt"};

			int valg = JOptionPane.showOptionDialog(null, "", "Ansatte", JOptionPane.OK_OPTION, -1, null, menyValg, menyValg[menyValg.length-1]);

			if (valg == 0) {
				String ansatte[] = {"Mikael", "Ola", "Tilbake"};
				int ansattValg = JOptionPane.showOptionDialog(null, "Ansatte i bedrift AS", "Ansatte", JOptionPane.OK_OPTION, -1, null, ansatte, ansatte[ansatte.length-1]);

				// Tabell for ansatte menyen
				String ansattInfoValg[] = {"Info", "Endre", "Tilbake"};
				String ansattEndreValg[] = {"Endre maanedslonn", "Endre skatt", "Endre arbtakernr", "Tilbake"};

				// Ansatt nr.1
				if (ansattValg == 0) {
					// Meny for valgene til ansatt1
					int ansatt1Valg = JOptionPane.showOptionDialog(null, mikaelAnsatt.getNavn(), "Ansatte i bedrift AS", JOptionPane.OK_OPTION, -1, null, ansattInfoValg, ansattInfoValg[ansattInfoValg.length-1]);

					if (ansatt1Valg == 0) {
						// Vis info til ansatt1
						JOptionPane.showMessageDialog(null, mikaelAnsatt);
					}

					if (ansatt1Valg == 1) {
						// Meny for endre valgene
						int ansatt1EndreValg = JOptionPane.showOptionDialog(null, mikaelAnsatt.getNavn(), "Ansatte i bedrift AS", JOptionPane.OK_OPTION, -1, null, ansattEndreValg, ansattEndreValg[ansattEndreValg.length-1]);

						if (ansatt1EndreValg == 0) {
							String lonn = JOptionPane.showInputDialog(null, "Oppgi ny maanedslonn");
							int lonnVerdi = Integer.parseInt(lonn);
							mikaelAnsatt.setMånedslonn(lonnVerdi);
						}

						if (ansatt1EndreValg == 1) {
							String skatteprosent = JOptionPane.showInputDialog(null, "Oppgi ny skatteprosent");
							int skatteprosentVerdi = Integer.parseInt(skatteprosent);
							mikaelAnsatt.setSkatteprosent(skatteprosentVerdi);
						}

						if (ansatt1EndreValg == 2) {
							String arbtakernr = JOptionPane.showInputDialog(null, "Oppgi ny arbtakernr");
							int arbtakernrVerdi = Integer.parseInt(arbtakernr);
							mikaelAnsatt.setArbtakernr(arbtakernrVerdi);
						}
					}
				}

				// Ansatt nr.2
				if (ansattValg == 1) {
					// Meny for valgene til ansatt1
					int ansatt2Valg = JOptionPane.showOptionDialog(null, olaAnsatt.getNavn(), "Ansatte i bedrift AS", JOptionPane.OK_OPTION, -1, null, ansattInfoValg, ansattInfoValg[ansattInfoValg.length-1]);

					if (ansatt2Valg == 0) {
						// Vis info til ansatt1
						JOptionPane.showMessageDialog(null, olaAnsatt);
					}

					if (ansatt2Valg == 1) {
						// Meny for endre valgene
						int ansatt2EndreValg = JOptionPane.showOptionDialog(null, olaAnsatt.getNavn(), "Ansatte i bedrift AS", JOptionPane.OK_OPTION, -1, null, ansattEndreValg, ansattEndreValg[ansattEndreValg.length-1]);

						if (ansatt2EndreValg == 0) {
							String lonn = JOptionPane.showInputDialog(null, "Oppgi ny maanedslonn");
							int lonnVerdi = Integer.parseInt(lonn);
							olaAnsatt.setMånedslonn(lonnVerdi);
						}

						if (ansatt2EndreValg == 1) {
							String skatteprosent = JOptionPane.showInputDialog(null, "Oppgi ny skatteprosent");
							int skatteprosentVerdi = Integer.parseInt(skatteprosent);
							olaAnsatt.setSkatteprosent(skatteprosentVerdi);
						}

						if (ansatt2EndreValg == 2) {
							String arbtakernr = JOptionPane.showInputDialog(null, "Oppgi ny arbtakernr");
							int arbtakernrVerdi = Integer.parseInt(arbtakernr);
							olaAnsatt.setArbtakernr(arbtakernrVerdi);
						}
					}
				}

			}
			// Avslutt 
			if (valg == 1) {
				fortsett = false;
			}
		}

	}
}



						//JTextField fornavnTextField = new JTextField();
						// JTextField etternavnTextField = new JTextField();
						// JTextField årTextField = new JTextField();

						// JTextField arbtakernrTextField = new JTextField();
						// JTextField månedslonnTextField = new JTextField();
						

						// Object[] msg = {
						// 	"Fornavn:  ", fornavnTextField,
						// 	"Etternavn: ", etternavnTextField,
						// 	"Fødselsår: ", årTextField,

						// 	"Arbtakernr: ", arbtakernrTextField,
						// 	"Månedslønn: ", månedslonnTextField,
						// 	"skatteprosent: "
						// };

						// String skatteprosentInput = JOptionPane.showInputDialog(null, msg, "Registrer ny ansatt", JOptionPane.DEFAULT_OPTION);
						
						// int fodselsår = Integer.parseInt(årTextField.getText());
						// String fornavn = fornavnTextField.getText();
						// String etternavn = etternavnTextField.getText();

						// int arbtakernr = Integer.parseInt(arbtakernrTextField.getText());
						// int månedslonn = Integer.parseInt(månedslonnTextField.getText());
						// int skatteprosent = Integer.parseInt(skatteprosentInput);

						// // Årstall
						// java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
						// int årstall = kalender.get(java.util.Calendar.YEAR);	