import static javax.swing.JOptionPane.*;

class ovingPrimtall {
  public static void main(String[] args) {
    int num = Integer.parseInt(showInputDialog("Sjekk om det er et primtall: "));
    boolean checker = false;

  	for (int i = 2; i < num; i++) {
  		if (num%i == 0) {
  			checker = true;		
  		}
  	}

  	if (checker == true) {
  		System.out.println("Det er ikke et primtall");
  	} else {
  		System.out.println("Det er et primtall!");
  	}









 //    int nummer = Integer.parseInt(showInputDialog("Sjekk om det er et primtall: "));

 //    if ((nummer/nummer) == (int)(nummer/nummer)){
	//   System.out.println("Det er et primtall!");
	// } else {
	//   System.out.println("Det er ikke et primtall");
 //  }
	}
}