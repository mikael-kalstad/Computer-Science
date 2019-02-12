import java.util.Scanner;

class valuta {
	public double (double enhet, double kurs, String navn) {
		this.enhet = enhet;
		this.kurs = kurs;
		this.navn = navn; 

		regnTil(doble amount) {
			return amount * kurs;
		}

		regnFra(double amount) {
			return amount / kurs;
		}
	}
}

class valutaTest {
	public static void main(String[] args) {
		valuta dollar = new valuta(1, 8, "dollar");
		system.out.println(dollar);
	}
}
	
	// public double getValuta (int optionNumber, String valutaName) {
	// 	// Scanner for å motta input fra bruker
	// 	System.out.println("Choose amount\n 1: 1 "+valutaName+"\n 2: 10 "+valutaName+"\n 3: 10.000 "+valutaName+"\n");
	// 	double amount[] = {1.0, 10.0, 10000.0};
	// 	int number = userInput.nextInt();
	// 	double kurs = 6.7;
	// 	double total = 0;
		
	// 	System.out.println("kurs: " + kurs);
	// 	System.out.print("1 dollar = ");
	
	// 	return kurs*amount[optionNumber-1];
	// }
}


// class valuta {

// 	public static void main(String[] args) {
// 		// Meny for valuta
// 		System.out.println("Velg valuta:\n 1: dollar\n 2: euro\n 3: svenske kroner\n 4: avslutt");

// 		String valutaArray[] = {"dollar", "euro", "svenske kroner", "avslutt"};

// 		// Scanner for å motta input fra bruker
// 		Scanner userInput = new Scanner(System.in);
// 		int number = userInput.nextInt();

// 		// Loop som angir rett valuta til spesifikt nummer fra brukerinput
// 		for (int i = 0; i < valutaArray.length; i++) {
// 			if ((number - 1) == i) {
// 				System.out.println("Du valgte " + valutaArray[i]);
// 				valutaKonvertering totalValuta = new valutaKonvertering();
// 				totalValuta.getValuta(i, valutaArray[i]);
// 			}

// 			if (number == 4) {
// 				//userInput.close();
// 				System.exit(0); // Avslutter programmet
// 			}
// 		}

// 		//int number1 = userInput.nextInt();
// 		// Programmet skal starte på nytt hvis 4 velges?
// 	}
// }
