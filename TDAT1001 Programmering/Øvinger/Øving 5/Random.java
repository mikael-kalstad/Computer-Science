class Random {
	int nedre;
	int ovre;

	public Random(int nedre, int ovre) {
		this.nedre = nedre;
		this.ovre = ovre;
	}

	public int nesteHeltall() {
		java.util.Random helTall = new java.util.Random();
		int nummer = helTall.nextInt(ovre)+nedre;
		return nummer;
	}

	public double nesteDesimalTall(double nedre, double ovre) {
		java.util.Random desimalTall = new java.util.Random();
		double nummer = desimalTall.nextDouble(ovre)+nedre;
		return nummer;
	}

	public int get() {
		return nedre + ovre;
	}

	public static void main(String[] args) {
		Random randomTall = new Random(2, 4);
		
		System.out.println(randomTall.get());
		System.out.println(randomTall.nesteHeltall());
	}	
}