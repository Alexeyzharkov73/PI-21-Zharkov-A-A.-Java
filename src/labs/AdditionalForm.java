package labs;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;

public class AdditionalForm {

	private JFrame frame;
	private BusCallBack scb;
	private Logger logger;

	/**
	 * Create the application.
	 */
	public AdditionalForm(BusCallBack scb) {
		initialize();
		this.scb = scb;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		logger = Logger.getGlobal();
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 265);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		CreateBusPanel panel = new CreateBusPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(142, 11, 181, 182);
		frame.getContentPane().add(panel);
		
		DraggableLabel lblNewLabel = new DraggableLabel("");
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(333, 11, 46, 26);
		lblNewLabel.setOpaque(true);
		frame.getContentPane().add(lblNewLabel);
		
		DraggableLabel label = new DraggableLabel("");
		label.setBackground(Color.GREEN);
		label.setBounds(389, 11, 46, 26);
		label.setOpaque(true);
		frame.getContentPane().add(label);
		
		DraggableLabel label_1 = new DraggableLabel("");
		label_1.setOpaque(true);
		label_1.setBackground(Color.YELLOW);
		label_1.setBounds(333, 48, 46, 26);
		frame.getContentPane().add(label_1);
		
		DraggableLabel label_2 = new DraggableLabel("");
		label_2.setOpaque(true);
		label_2.setBackground(Color.ORANGE);
		label_2.setBounds(389, 48, 46, 26);
		frame.getContentPane().add(label_2);
		
		DraggableLabel label_3 = new DraggableLabel("");
		label_3.setOpaque(true);
		label_3.setBackground(Color.RED);
		label_3.setBounds(333, 85, 46, 26);
		frame.getContentPane().add(label_3);
		
		DraggableLabel label_4 = new DraggableLabel("");
		label_4.setOpaque(true);
		label_4.setBackground(Color.CYAN);
		label_4.setBounds(389, 85, 46, 26);
		frame.getContentPane().add(label_4);
		
		DraggableLabel label_5 = new DraggableLabel("");
		label_5.setOpaque(true);
		label_5.setBackground(Color.BLACK);
		label_5.setBounds(333, 122, 46, 26);
		frame.getContentPane().add(label_5);
		
		DraggableLabel label_6 = new DraggableLabel("");
		label_6.setOpaque(true);
		label_6.setBackground(Color.WHITE);
		label_6.setBounds(389, 122, 46, 26);
		frame.getContentPane().add(label_6);
		
		DraggableLabel label_7 = new DraggableLabel("BaseBus");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(23, 11, 73, 48);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		label_7.setBorder(border);
		frame.getContentPane().add(label_7);
		
		DraggableLabel lblUltraBus = new DraggableLabel("Bus");
		lblUltraBus.setHorizontalAlignment(SwingConstants.CENTER);
		lblUltraBus.setBounds(23, 70, 73, 48);
		lblUltraBus.setBorder(border);
		frame.getContentPane().add(lblUltraBus);
		
		JButton btnNewButton = new JButton("\u041E\u041A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(scb != null) {
					if(panel.getBus()!=null) {
						scb.takeBus(panel.getBus());
					}
				}				
				logger.info("Создание автобуса завершено");
				frame.dispose();
			}
		});
		btnNewButton.setBounds(23, 136, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u041E\u0442\u043C\u0435\u043D\u0430");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("Создание автобуса отменено");
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(23, 170, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		DraggableLabel draggableLabel = new DraggableLabel("Bus");
		draggableLabel.setText("1");
		draggableLabel.setHorizontalAlignment(SwingConstants.CENTER);
		draggableLabel.setBounds(338, 164, 25, 29);
		draggableLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(draggableLabel);
		
		DraggableLabel draggableLabel_1 = new DraggableLabel("Bus");
		draggableLabel_1.setText("2");
		draggableLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		draggableLabel_1.setBounds(377, 164, 25, 29);
		draggableLabel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(draggableLabel_1);
		
		DraggableLabel draggableLabel_2 = new DraggableLabel("Bus");
		draggableLabel_2.setText("3");
		draggableLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		draggableLabel_2.setBounds(410, 164, 25, 29);
		draggableLabel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(draggableLabel_2);
		frame.setVisible(true);
		
		
	}
}