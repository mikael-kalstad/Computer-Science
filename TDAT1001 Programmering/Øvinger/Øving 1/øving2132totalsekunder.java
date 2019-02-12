class øving2132totalsekunder  {
  public static void main(String[] args) {
	String timerLest= showInputDialog("Timer: ");
    int timer = Int.parseInt(timerLest);

    String minutterLest= showInputDialog("Minutter: ");
    int timer = Int.parseInt(minutterLest);

    int totalSekunder = 0;
    totalSekunder += (timer * 3600);
    totalSekunder += (minutter * 60);
    totalSekunder += sekunder;

    System.out.println(totalSekunder);
  }
}