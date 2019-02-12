import static javax.swing.JOptionPane.*;

class oving3123skuddår {
  public static void main(String[] args) {
    String årLest = showInputDialog("årstall: ");
    double år = Double.parseDouble(årLest);
    double årDel = år/4;
    double årHundre = år/100;

    if (årDel == (int)årDel && årHundre != (int)årHundre) {
      System.out.println("Det er skuddår!");
    } else if ((år/400) == (int)(år/400)){
		System.out.println("Det er skuddår!");
	}else {
      System.out.println("Det er ikke skuddår");
    }
  }
}