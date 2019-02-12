/*
Klasse for å regne brøk
Skal ha:
- To konstruktører
	- En som tar teller og nevner som argument, hvis nevner er 0 skal IllegalArgumentException "kastes"
	- Andre tar kun teller som argument, og settes lik 1

- get metoder ikke set metoder
- metoder for å + - * / en brøk
	- Ingen return, svaret lagres i this
- testklienten skal være en del av klassen.
*/
class Brok {
	private int teller; 
	private int nevner;
	
	// Konstruktør
	public Brok(int teller, int nevner) {
		this.teller = teller;
		this.nevner = nevner;
		sjekkFor0();
	}

	public Brok(int teller) {
		this.teller = teller;
		this.nevner = 1;
	}

	// Metode som sjekker om nevner er 0
	public void sjekkFor0() {
		if (nevner == 0) {
			throw new IllegalArgumentException("Nevner kan ikke være 0!");
		}
	}

	// Metode for å forkorte broken
	public void forkort() {
		int maxNumber;
		if (teller > nevner) {
			maxNumber = teller;
		} else {
			maxNumber = nevner;
		}

		for (int i = 2; i < maxNumber; i++) {
			if ((teller % i) == 0 && (nevner % i) == 0) {
				this.teller = this.teller / i;
				this.nevner = this.nevner / i;
			}
		}
	}

	public void addisjon(int teller, int nevner) {
		this.teller = (this.teller * nevner) + (this.nevner * teller);
		this.nevner = (this.nevner * nevner);
		sjekkFor0();
	}

	public void minus(int teller, int nevner) {
		this.teller = (this.teller * nevner) - (this.nevner * teller);
		this.nevner = (this.nevner * nevner);
		sjekkFor0();
	}

	public void dividere(int teller, int nevner) {
		this.teller = this.teller * nevner;
		this.nevner = this.nevner * teller;
		sjekkFor0();
	}

	public void multiplisere(int teller, int nevner) {
		this.teller = this.teller * teller;
		this.nevner = this.nevner * nevner;
		sjekkFor0();
	}

	// Standard metode for å skrive ut broken
	public String toString() {
		if (teller == nevner) {return "1";}
		if (teller == 0) {return "0";}
		forkort(); // Forkorter broken før den skrives ut
		return teller + " / " + nevner; 
	}
	

	// Testklient
	public static void main(String[] args) {
		// Addisjon
		Brok myBrok1 = new Brok(1, 0);
		myBrok1.addisjon(1, 4);
		// 6 og 8 siden metoden forkort() ikke er brukt
		if (myBrok1.teller == 6 && myBrok1.nevner == 8) {
			System.out.println("Addisjon ok");
		} else {
			System.out.println("Addisjon feil");
		}

		// Minus
		Brok myBrok2 = new Brok(1, 2);
		myBrok2.minus(1, 4);
		// 2 og 8 siden metoden forkort() ikke er brukt
		if (myBrok2.teller == 2 && myBrok2.nevner == 8) {
			System.out.println("Minus ok");
		} else {
			System.out.println("Minus feil");
		}

		// Divisjon
		Brok myBrok3 = new Brok(1, 2);
		myBrok3.dividere(1, 2);
		if (myBrok3.teller == 2 && myBrok3.nevner == 2) {
			System.out.println("Divisjon ok");
		} else {
			System.out.println("Divisjon feil");
		}

		// Multiplisere
		Brok myBrok4 = new Brok(1, 2);
		myBrok4.multiplisere(1, 2);
		if (myBrok4.teller == 1 && myBrok4.nevner == 4) {
			System.out.println("Multiplisere ok");
		} else {
			System.out.println("Multiplisere feil");
		}

		// Forkort
		Brok myBrok5 = new Brok(5, 10);
		myBrok5.forkort();
		if (myBrok5.teller == 1 && myBrok5.nevner == 2) {
			System.out.println("Forkort ok");
		} else {
			System.out.println("Forkort feil");
		}
	}
}