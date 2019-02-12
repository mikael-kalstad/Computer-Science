


import java.awt.event.*;

class Gui1 extends JFrame {
	public static void main(String[] args) {
		// Creating the frame
		JFrame frame = new JFrame("GUI!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
	
		//Panel top (chat)
		JPanel panelTop = new JPanel();
		JLabel titleLabel = new JLabel("Chat");
		panelTop.add(titleLabel);
		frame.getContentPane().add(BorderLayout.PAGE_START, panelTop);

		//Panel center (chat messages)
		JPanel panelCenter = new JPanel();
		JLabel message = new JLabel("Hello!");
		panelCenter.add(message);
		frame.getContentPane().add(BorderLayout.LINE_START, panelCenter);

		//Panel bottom (input & buttons)
		JPanel panelBottom = new JPanel();
		JLabel textFieldLabel = new JLabel("Type here");
		JTextField textfield = new JTextField(10); 
		panelBottom.add(textFieldLabel);
		panelBottom.add(textfield);
			//Buttons
		JButton sendBtn = new JButton("Send");
		JButton resetBtn = new JButton("Reset");
		panelBottom.add(sendBtn);
		panelBottom.add(resetBtn);
		frame.getContentPane().add(BorderLayout.SOUTH, panelBottom);


		
		

		//Button action
		String msg = "asdad"; // Text displayed in main window
		JPanel panel2 = new JPanel();
		if (sendBtn.getModel().isPressed()) {
			// JLabel label2 = new JLabel();
			// panel2.add(label2);
			frame.setSize(200,200);
		}

		
		

		frame.getContentPane().add(BorderLayout.NORTH, panel2);

		frame.setVisible(true);



	}
}