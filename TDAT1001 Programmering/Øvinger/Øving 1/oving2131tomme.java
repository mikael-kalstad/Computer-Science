import static javax.swing.JOptionPane.*;

class oving2131tomme {
  public static void main(String[] args) {
    String tommerLest = showInputDialog("Tommer: ");
    double tommer = Double.parseDouble(tommerLest);
    double centimeter = tommer * 2.54;

    System.out.println("Tommer: " + tommer + "\"");
    System.out.println("Centimeter: " + centimeter + "cm");
  }
}