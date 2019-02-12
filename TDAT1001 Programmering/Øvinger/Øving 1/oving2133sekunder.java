import static javax.swing.JOptionPane.*;

class oving2133sekunder {
  public static void main(String[] args) {
    int sekunder = Integer.parseInt(showInputDialog("Sekunder: "));
    int totalTimer = 0;
    int totalMinutter = 0;
    int totalSekunder = 0;

    while (sekunder > 0) {
      if (sekunder >= 3600) {
        totalTimer += 1;
        sekunder -= 3600;
      } else if (sekunder >= 60) {
        totalMinutter += 1;
        sekunder -= 60;
      } else {
        totalSekunder += 1;
        sekunder -= 1;
      }
    }

    System.out.println("Timer: " + totalTimer);
    System.out.println("Minutter: " + totalMinutter);
    System.out.println("Sekunder: " + totalSekunder);
  }
}