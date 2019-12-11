package labs;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JFormattedTextField;
import javax.swing.JList;


public class Labs {

	private JFrame frame;
	private BusPanel panel;
	private JFormattedTextField formattedTextField;
	private JList list;
	
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
		frame.setBounds(100, 100, 1081, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new BusPanel();
		panel.setParking(new MultiLevelParking(5, 1081, 621));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(21, 24, 845, 447);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton_1 = new JButton("create bus");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdditionalForm aForm = new AdditionalForm(new BusCallBack() {

					@Override
					public void takeBus(ITransport bus) {
						panel.setBus(bus);
						panel.repaint();
						
					}
					
				});
			}
		});
		btnNewButton_1.setBounds(904, 181, 140, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		SmallBusPanel panel_1 = new SmallBusPanel();
		panel_1.setBorder(new TitledBorder(null, "\u041A\u043E\u0440\u0430\u0431\u043B\u044C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(895, 250, 140, 221);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 93, 120, 117);
		panel_1.add(panel_2);
		
		JButton btnNewButton_2 = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.addBus(panel.getBus(Integer.parseInt(formattedTextField.getText())-1));
				panel_1.repaint();
				panel.repaint();
			}
		});
		btnNewButton_2.setBounds(10, 60, 120, 23);
		panel_1.add(btnNewButton_2);
		
		JLabel label = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		label.setBounds(10, 35, 56, 14);
		panel_1.add(label);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(84, 29, 46, 20);
		panel_1.add(formattedTextField);
		String[] str = new String[5];
		for(int i = 1;i<6;i++) {
			str[i-1] = "׃נמגוü  " + i;
		}

		list = new JList(str);
		list.setSelectedIndex(0);
		list.setBounds(904, 16, 140, 133);
		frame.getContentPane().add(list);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				BusPanel.currentLevel = list.getSelectedIndex();
				panel.repaint();
				
			}
			
		});
	}
}
