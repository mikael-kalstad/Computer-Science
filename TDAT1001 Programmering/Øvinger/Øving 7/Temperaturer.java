import javax.swing.*;

class Temperaturer {
	int tabell[][];
	double dagMiddel[];

	//Konstruktør
	Temperaturer (int tabell[][]) {
		//Angir størrelsen på dagMiddel tabellen
		int antallDager = tabell.length;
		dagMiddel = new double[antallDager];

		//Angir størrelsen på tabell
		// this.tabell = new int[tabell.length][tabell[0].length];

		this.tabell = tabell;
		// Dyp kopiering for å unngå endringer!
		// for (int i = 0; i < tabell.length; i++) {
		// 	for (int x = 0; x < tabell[i].length; x++)
		// 		this.tabell[i][x] = tabell[i][x];
		// }
	}


	String temperaturPerTime() {
		String msg = "";

		for (int i = 0; i < tabell.length; i++) {
			msg += "Temperatur Dag " + (i+1);
			for (int x = 0; x < tabell[i].length; x++) {
				msg += " | Time " + (x+1) + ", grader: " + tabell[i][x];
			}
			msg += "\n";
		}
		return msg;
	}


	String dagMiddel() {
		for (int i = 0; i < tabell.length; i++) {
		int total = 0;

			for (int x = 0; x < tabell[i].length; x++) {
				total += tabell[i][x];
			}

			double middelVerdi = Math.ceil( (double) total / (double) tabell[i].length * 10) / 10;
			dagMiddel[i] = middelVerdi;
		}

		//Middel temperatur hver dag
		String msg = "";
		for (int i = 0; i < dagMiddel.length; i++) {
			msg += "Middel temperatur Dag " + (i+1) + " " + dagMiddel[i] + "\n";
		}
		return msg;
	}


	double månedMiddel() {
		int total = 0;
		int i;
		for (i = 0; i < tabell.length; i++) {
			for (int x = 0; x < tabell[i].length; x++) {
				total += tabell[i][x];
			}
		}
		double middelVerdi = (double) total / ((double) tabell[i-1].length * tabell.length);
		return middelVerdi;
	}

	String antallDogn() {
		String msg = "Antall dager med temperaturer: \n";
		int overti = 0;
		int femtilti = 0;
		int nulltilfem = 0;
		int minusfemtilti = 0;
		int midreminusfem = 0;

		for (int i = 0; i < dagMiddel.length; i++) {
			if (dagMiddel[i] > 10) {
				overti++;
			} else if (dagMiddel[i] <= 10 && dagMiddel[i] >= 5) {
				femtilti++;
			} else if (dagMiddel[i] <= 5 && dagMiddel[i] >= 0) {
				nulltilfem++;
			} else if (dagMiddel[i] <= -5 && dagMiddel[i] >= 0) {
				minusfemtilti++;
			} else if (dagMiddel[i] < -5) {
				midreminusfem++;
			}
		}

		msg += "Over 10: " + overti + "\n";
		msg += "Mellom 5 og 10: " + femtilti + "\n";
		msg += "Mellom 0 og 5: " + nulltilfem + "\n";
		msg += "Mellom -5 og 0: " + minusfemtilti + "\n";
		msg += "Mindre enn -5: " + midreminusfem + "\n";

		return msg;
	}
	

	public static void main(String[] args) {
		int TemperaturVerdier[][] = {{10, 15, 20}, {20, 25, -2}, {10, 12, 1}};

		Temperaturer test = new Temperaturer(TemperaturVerdier);
		System.out.println("Middel temperatur Måned " + test.månedMiddel() + "\n");
		System.out.println(test.dagMiddel());
		System.out.println(test.temperaturPerTime());
		System.out.println(test.antallDogn());
		test.tabell[0][0] = 200;
		System.out.println(test.tabell[0][0]);

		// Meny valgene 
		Object valg[] = {"Registrer temperatur", "Temp hver time", "Middeltemp for hver dag", "Middeltemp for måneden", "Temp sortert", "Avslutt"};
		
		//Tabell som holder tempverdier
		int tempTabell[][] = {{10, 15, 20}, {20, 25, -2}, {10, 12, 1}}; 
		Temperaturer tempObj = new Temperaturer(tempTabell);

		boolean fortsett = true;
		while (fortsett) {
			// Hovedmeny for valg
			int menyValg = JOptionPane.showOptionDialog(null, "Meny for temperaturmåling", "Meny", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, valg, valg[5]);

			if (menyValg == 0) {
				//Oppretter textfield for input til antall dager og timer
				JTextField dagVerdiTextField = new JTextField();
				JTextField timeVerdiTextField = new JTextField();
				JTextField tempVerdiTextField = new JTextField();

				Object[] messageAntall = {
					"Velg dag: ", dagVerdiTextField,
					"Velg time: ", timeVerdiTextField,
					"Angi temperatur: ", tempVerdiTextField,
				};

				int storrelseValg = JOptionPane.showConfirmDialog(null, messageAntall, "Registrer temperatur", JOptionPane.DEFAULT_OPTION);
				
				int dagVerdi = Integer.parseInt(dagVerdiTextField.getText());
				int timeVerdi = Integer.parseInt(timeVerdiTextField.getText());
				int tempVerdi = Integer.parseInt(tempVerdiTextField.getText());

				tempObj.tabell[dagVerdi][timeVerdi] = tempVerdi;
			}
			

			if (menyValg == 1) {
				JOptionPane.showMessageDialog(null, tempObj.temperaturPerTime());
			}

			if (menyValg == 2) {
				JOptionPane.showMessageDialog(null, tempObj.dagMiddel());
			}

			if (menyValg == 3) {
				JOptionPane.showMessageDialog(null, tempObj.månedMiddel());
			}

			if (menyValg == 4) {
				JOptionPane.showMessageDialog(null, tempObj.antallDogn());
			}

			if (menyValg == 5) {
				fortsett = false;
			}
		}
	}
}