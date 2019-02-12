class RandomAmount {
	public static void main(String[] args) {
		int zero, one, two, three, four, five, six, seven, eight, nine;
		zero = one = two = three = four = five = six = seven = eight = nine= 0;

		// Endre på i < n for n antall ganger det skal kjøres
		for (int i = 1; i < 1000; i++) {
			java.util.Random random = new java.util.Random();
			int randomTall = random.nextInt(10);
			
			if (randomTall == 0) { zero++; }

			if (randomTall == 1) { one++; }

			if (randomTall == 2) { two++; }

			if (randomTall == 3) { three++; }

			if (randomTall == 4) { four++; }

			if (randomTall == 5) { five++; }

			if (randomTall == 6) { six++; }

			if (randomTall == 7) { seven++; }

			if (randomTall == 8) { eight++; }

			if (randomTall == 9) { nine++; }
		}

		// Runder opp og legger til en stjerne for hver 10.gang
		int oneRounded = (int) (Math.ceil(one/10.0)*10.0);
		String oneStar = "";
		for (int i = 0; i < oneRounded/10; i++) {
			oneStar += "*";
		}

		int twoRounded = (int) (Math.ceil(two/10.0)*10.0);
		String twoStar = "";
		for (int i = 0; i < twoRounded/10; i++) {
			twoStar += "*";
		}  

		int threeRounded = (int) (Math.ceil(three/10.0)*10.0);
		String threeStar = "";
		for (int i = 0; i < threeRounded/10; i++) {
			threeStar += "*";
		}

		int fourRounded = (int) (Math.ceil(four/10.0)*10.0);
		String fourStar = "";
		for (int i = 0; i < fourRounded/10; i++) {
			fourStar += "*";
		}

		int fiveRounded = (int) (Math.ceil(five/10.0)*10.0);
		String fiveStar = "";
		for (int i = 0; i < fiveRounded/10; i++) {
			fiveStar += "*";
		}

		int sixRounded = (int) (Math.ceil(six/10.0)*10.0);
		String sixStar = "";
		for (int i = 0; i < sixRounded/10; i++) {
			sixStar += "*";
		}

		int sevenRounded = (int) (Math.ceil(seven/10.0)*10.0);
		String sevenStar = "";
		for (int i = 0; i < sevenRounded/10; i++) {
			sevenStar += "*";
		}

		int eightRounded = (int) (Math.ceil(eight/10.0)*10.0);
		String eightStar = "";
		for (int i = 0; i < eightRounded/10; i++) {
			eightStar += "*";
		}

		int nineRounded = (int) (Math.ceil(nine/10.0)*10.0);
		String nineStar = "";
		for (int i = 0; i < nineRounded/10; i++) {
			nineStar += "*";
		}

		System.out.println("1 " + one + " " + oneStar);
		System.out.println("2 " + two + " " + twoStar);
		System.out.println("3 " + three + " " + threeStar);
		System.out.println("4 " + four + " " + fourStar);
		System.out.println("5 " + five + " " + fiveStar);
		System.out.println("6 " + six + " " + sixStar);
		System.out.println("7 " + seven + " " + sevenStar);
		System.out.println("8 " + eight + " " + eightStar);
		System.out.println("9 " + nine + " " + nineStar);
	}	
}