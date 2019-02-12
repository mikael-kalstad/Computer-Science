import java.util.Scanner;

class Valuta {
	public double enhet;
	public double kurs;
	public String navn;

	public Valuta (double enhet, double kurs, String navn) {
		this.enhet = enhet;
		this.kurs = kurs/enhet;
		this.navn = navn;
	}
		public double regnTil(double amount) {
			return amount * kurs;
		}

		public double regnFra(double amount) {
			return amount / kurs;
		}
}

class valutaTest {
	public static void main(String[] args) {
		// Scanner for å motta input fra bruker
		System.out.println("Velg valuta:\n 1: dollar\n 2: euro\n 3: svenske kroner\n 4: avslutt");

		// Scanner for å motta input fra bruker
		Scanner userInput = new Scanner(System.in);
		int number = userInput.nextInt();

		String valutaArray[] = {"dollar", "euro", "svenske kroner", "avslutt"};
		Valuta[] valutaer = {new Valuta(1, 8.4, "dollar"), new Valuta(1, 9.7, "euro"), new Valuta(1, 92.3, "svenske kroner")};
		Valuta currentValuta = null;

		// Loop som angir rett valuta til spesifikt nummer fra brukerinput
		for (int i = 0; i < valutaArray.length; i++) {
			if ((number - 1) == i) {
				currentValuta = valutaer[i];
				System.out.println("Du valgte " + valutaArray[i]);
			}

			if (number == 4) {
				//userInput.close();
				System.exit(0); // Avslutter programmet
			}
		}

		// Bruker velger beløp og konvereter til nok eller valgt valuta
		System.out.println("Du kan naa konvertere fra valgt valuta til nok eller fra nok til valgt valuta\n Velg 1 for aa konvertere fra nok til valgt valuta\n Velg 2 for aa konvertere fra valg valuta til nok ");
		int konverteringValg = userInput.nextInt();

		// Konverteringsvalg og henter metoden i valuta
		if (konverteringValg == 1) {
			System.out.println("Du har valgt aa konvertere fra nok til valgt valuta\n Velg antall: ");
			double konverteringValg1 = userInput.nextDouble();
			System.out.println(currentValuta.regnFra(konverteringValg1));
		} else {
			System.out.println("Du har valgt aa konvertere fra valgt valuta til nok\n Velg antall: ");
			double konverteringValg2 = userInput.nextDouble();
			System.out.println(currentValuta.regnTil(konverteringValg2));
		}
	}
}
