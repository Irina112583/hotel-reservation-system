package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class Reservation extends JFrame{

	public Reservation() {
	
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1047, 466);
		JPanel pnlRegister = new JPanel();
		pnlRegister.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlRegister.setBackground(Color.WHITE);
		setContentPane(pnlRegister);
		pnlRegister.setLayout(null);
	}
}
