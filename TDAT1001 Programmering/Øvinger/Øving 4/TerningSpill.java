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


class Spiller {
	String name;
	int sumPoeng = 0;

	public Spiller (String name) {
		this.name = name;
	}

	int getSumPoeng() {
		return sumPoeng;
	}

	int kastTerningen() {
		java.util.Random terning = new java.util.Random();
		int terningkast = terning.nextInt(6) + 1; // Denne er fra 0-5 derfor legges det til 1
		return terningkast; // 1-6
	}

	String erFerdig() {
		return name + " vant spillet!";
	}
}



class TerningSpill {
	public static void main(String[] args) {

		// Lager to spiller objekt med forskjellige navn
		Spiller ole = new Spiller("Ole");
		Spiller pål = new Spiller("Pål");
		
		// Loop som går helt til en av spillerne har nådd 100 poeng
		for (int i = 0; (ole.sumPoeng < 100)||(pål.sumPoeng < 100); i++) {

			int oleTerning = ole.kastTerningen();
			int pålTerning = pål.kastTerningen();
			

			if ((ole.sumPoeng + oleTerning) > 100) {
				ole.sumPoeng -= oleTerning;
			} else {
				ole.sumPoeng += oleTerning;
			}

			if ((pål.sumPoeng + pålTerning) > 100) {
				pål.sumPoeng -= pålTerning;
			} else {
				pål.sumPoeng += pålTerning;
			}

			// Printer ut hvilken runde og antall poeng hver runde
			System.out.println("Ole: Runde " + i + " Total poeng " + ole.getSumPoeng());
			System.out.println("Pål: Runde " + i + " Total poeng " + pål.getSumPoeng());


			// Hvis poengsummen er 100  vinner spilleren
			if (ole.sumPoeng == 100 && pål.sumPoeng < 100) {
				System.out.println(ole.erFerdig());
				break; // Hvis mer enn eller lik 100 poeng skal loopen stoppe
			}
			
			if (pål.sumPoeng == 100 && ole.sumPoeng < 100){
				System.out.println(pål.erFerdig());
				break;
			} 
			
			// Hvis begge har fått 100 poeng i samme runde er det uavgjort
			if (ole.sumPoeng == 100 && pål.sumPoeng == 100){
				System.out.println("Uavgjort!");
				break;
			}
		}
	}
}