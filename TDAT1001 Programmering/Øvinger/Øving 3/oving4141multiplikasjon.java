import java.util.Scanner;

class oving4141multiplikasjon{
	public static void main(String[] args){
		// For � lese inn brukerdata
		Scanner userInput = new Scanner(System.in);

		// F� tall rangen fra brukeren
		System.out.println("Velg f�rste tall i rekken: ");
		int firstNumber = userInput.nextInt();
		System.out.println("Velg siste tall i rekken: ");
		int secondNumber = userInput.nextInt();

		for (int x = firstNumber; x <= secondNumber; x++) {
			for (int i = 1; i <= 10; i++) {
				System.out.println(x + " x " + i + " = " + x*i);
			}
		}
    }
}