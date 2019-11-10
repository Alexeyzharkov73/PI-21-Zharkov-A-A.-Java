package labs;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Labs {

	private JFrame frame;
	private BusPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Labs window = new Labs();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Labs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 949, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new BusPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(21, 24, 902, 400);
		frame.getContentPane().add(panel);
		
		JButton btnW = new JButton("W");
		btnW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				move(btnW.getText());
			}
		});
		btnW.setBounds(803, 440, 47, 29);
		frame.getContentPane().add(btnW);
		
		JButton btnA = new JButton("A");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				move(btnA.getText());
			}
		});
		btnA.setBounds(741, 493, 47, 29);
		frame.getContentPane().add(btnA);
		
		JButton btnS = new JButton("S");
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				move(btnS.getText());
			}
		});
		btnS.setBounds(803, 493, 47, 29);
		frame.getContentPane().add(btnS);
		
		JButton btnD = new JButton("D");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				move(btnD.getText());
			}
		});
		btnD.setBounds(865, 493, 47, 29);
		frame.getContentPane().add(btnD);
		
		JButton btnNewButton = new JButton("Create Bus");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bus tmp = new Bus(150, 1500, Color.RED, Color.BLACK, true, false, Doors.FIVE);
				tmp.setPosition(0, 0, 820, 330);
				panel.setBus(tmp);
				panel.repaint();
			}
		});
		btnNewButton.setBounds(15, 493, 115, 29);
		frame.getContentPane().add(btnNewButton);
	}
	
	private void move(String direction) {
		switch(direction) {
		case("W"):
			panel.getBus().moveBus(Direction.UP);
			panel.repaint();
			break;
		case("S"):
			panel.getBus().moveBus(Direction.DOWN);
			panel.repaint();
			break;
		case("A"):
			panel.getBus().moveBus(Direction.LEFT);
			panel.repaint();
			break;
		case("D"):
			panel.getBus().moveBus(Direction.RIGHT);
			panel.repaint();
			break;
		}
	}
}
