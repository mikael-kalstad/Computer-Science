import static javax.swing.JOptionPane.*;

class primtall {
  public static void main(String[] args) {
  	int num = Integer.parseInt(showInputDialog("Nummer: "));
  	int arrayBefore10[] = {1, 3, 5, 7, 9}; //Primtallene før 10
  	int arrayAfter10[] = {1, 3, 7, 9}; //Siste tall i primtallene etter 10
  	int total = 0; //Variabel for å unngå å printe ut flere ganger i loopene

  	//Loop for å sjekke om nummer er et tall i arrayBefore10
    for (int i = 0; i < arrayBefore10.length; i++) {
    	if (num == arrayBefore10[i]) {  total++;  }
    }

    //Loop for å sjekke om siste tall i nummer er et tall i arrayAfter10
    for (int i = 0; i < arrayAfter10.length; i++) {
		  if ((num%10) == arrayAfter10[i]) { 
           total++;  
      }
    }

    //Sjekker om total er større enn 0, for da er det et primtall!
    if (total > 0) {
    	System.out.println("Det er et primtall!");
    } else {
    	System.out.println("Det er ikke et primtall!");
    }
  }
}