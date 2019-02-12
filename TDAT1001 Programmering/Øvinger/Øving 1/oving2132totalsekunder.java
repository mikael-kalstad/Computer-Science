import static javax.swing.JOptionPane.*;

class oving2132totalsekunder  {
  public static void main(String[] args) {
	String timerLest= showInputDialog("Timer: ");
    int timer = Integer.parseInt(timerLest);

    String minutterLest= showInputDialog("Minutter: ");
    int minutter = Integer.parseInt(minutterLest);

    String sekunderLest= showInputDialog("Sekunder: ");
    int sekunder = Integer.parseInt(sekunderLest);

    int totalSekunder = 0;
    totalSekunder += (timer * 3600);
    totalSekunder += (minutter * 60);
    totalSekunder += sekunder;

    System.out.println(totalSekunder);
  }
}