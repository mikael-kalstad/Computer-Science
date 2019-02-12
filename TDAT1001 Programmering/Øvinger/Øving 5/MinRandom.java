class MinRandom {

	java.util.Random randomMachine = new java.util.Random();
	
	// Metode heltall
	public int nesteHeltall(int nedre, int ovre) {
		// For å unngå feil byttes rekkefølge hvis nedre eller større enn ovre
		if (nedre > ovre) {
			return randomMachine.nextInt(nedre)+ovre;
		}
		return randomMachine.nextInt(ovre-nedre)+nedre;
	}

	// Metode desimaltall
	public double nesteDesimaltall(double nedre, double ovre) {
		if (nedre > ovre) {
			return randomMachine.nextDouble()*(nedre-ovre)+ovre;
		}
		return randomMachine.nextDouble()*(ovre-nedre)+nedre;
	}

	public static void main(String[] args) {
		MinRandom random = new MinRandom();
		System.out.println(random.nesteDesimaltall(1.01, 1.02));
		System.out.println(random.nesteHeltall(3, 7));
	}	
}