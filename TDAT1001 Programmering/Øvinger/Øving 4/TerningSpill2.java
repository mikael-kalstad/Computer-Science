/*
Terning spill

Regler: 
- To spillere
- Man vinner ved å få 100 poeng
- Runden byttes ved hvert kast
- En terning skal brukes for å gi en verdi mellom 1 og 6 med java.util.Random
- Rundenummer og poengsummene til hver av spillerne skal skrive ut hver runde

EKSTRA: 
- Spillerne må komme akkurat på 100, hvis det er over trekkes summen på terningen fra totalsummen
*/
import java.util.Random;


class TerningSpill2 {
	String name;
	int sumPoeng = 0;

	public TerningSpill2 (String name) {
		this.name = name;
	}

	int getSumPoeng() {
		return sumPoeng;
	}

	void kastTerningen() {
		java.util.Random terning = new java.util.Random();
		int terningkast = terning.nextInt(6) + 1; // Denne er fra 0-5 derfor legges det til 1

		if ((sumPoeng + terningkast) > 100) {
				sumPoeng -= terningkast;
			} else {
				sumPoeng += terningkast;
			}

		// Printer ut hvilken runde og antall poeng hver runde
		System.out.println(name + ": Runde " + " Total poeng " + getSumPoeng());

		if (sumPoeng == 100) {
			System.out.println(name + " vant spillet!");
		}
	}

	boolean erFerdig() {
		if (sumPoeng < 100) { // Endre total poeng her
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {

		// Lager to spiller objekt med forskjellige navn
		Spiller spiller1 = new Spiller("Ole");
		Spiller spiller2 = new Spiller("Pål");
		
		// Loop som går helt til en av spillerne har nådd 100 poeng
		while (spiller1.erFerdig() && spiller1.erFerdig()) {

			spiller1.kastTerningen();
			spiller2.kastTerningen();
		}
	}
}
