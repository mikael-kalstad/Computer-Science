import static javax.swing.JOptionPane.*;

class oving3123skudd�r {
  public static void main(String[] args) {
    String �rLest = showInputDialog("�rstall: ");
    double �r = Double.parseDouble(�rLest);
    double �rDel = �r/4;
    double �rHundre = �r/100;

    if (�rDel == (int)�rDel && �rHundre != (int)�rHundre) {
      System.out.println("Det er skudd�r!");
    } else if ((�r/400) == (int)(�r/400)){
		System.out.println("Det er skudd�r!");
	}else {
      System.out.println("Det er ikke skudd�r");
    }
  }
}