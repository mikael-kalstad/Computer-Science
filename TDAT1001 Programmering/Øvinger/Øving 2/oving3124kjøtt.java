class oving3124kjøtt {
  public static void main(String[] args) {
    double aVekt = 450;
    double aPris = 35.90;
    double A = aVekt / aPris;

    double bVekt = 500;
    double bPris = 39.50;
    double B = bVekt / bPris;

    if (A > B) {
      System.out.println("A er billigst");
    } else {
      System.out.println("B er billigst");
    }

  }
}