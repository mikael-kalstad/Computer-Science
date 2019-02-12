import java.awt.*;
import javax.swing.*;

class Vindu extends JFrame {
	Vindu() {
		setTitle("Tittel");
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tegning tegningen = new Tegning();
		add(tegningen);
	}
}

class Tegning extends JPanel {
	public void paintComponent(Graphics tegneflate) {
		super.paintComponent(tegneflate);

		//Hode
		tegneflate.setColor(Color.YELLOW);
		tegneflate.fillOval(50, 50, 400, 400);
		
		//Øyne
		tegneflate.setColor(Color.BLACK);
		tegneflate.fillOval(170, 170, 50, 50);
		tegneflate.fillOval(320, 170, 50, 50);

		//Nese
		tegneflate.fillOval(250, 250, 25, 25);

		//Munn
		tegneflate.fillArc(160, 250, 190, 150, -180, 180);

		tegneflate.drawString("Smiley", 100, 20);
	}
}

class SmileyApp {
	public static void main(String[] args) {
		Vindu vindu = new Vindu();
		vindu.setVisible(true);
	}
}