package labs;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class Labs {

	private JFrame frame;
	private BusPanel panel;
	private JFormattedTextField formattedTextField;
	private JList list;
	private Logger logger;

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
					LogError.log(e.getMessage());
					JOptionPane.showMessageDialog(null,
						    e.getMessage(),
						    e.getMessage(),
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public Labs() throws SecurityException, IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	private void initialize() throws SecurityException, IOException {
		new LogError("G:/errors.txt");
		logger = Logger.getGlobal();
        SimpleFormatter formatter = new SimpleFormatter(); 
		Handler h = new FileHandler("G:/log.txt");
		h.setFormatter(formatter);
		logger.addHandler(h);
		logger.setUseParentHandlers(false);
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
				logger.info("Начато создание автобуса");
				AdditionalForm aForm = new AdditionalForm(new BusCallBack() {

					@Override
					public void takeBus(ITransport bus) {
						try {
							panel.setBus(bus);
							panel.repaint();
						} catch (Exception ex) {
							LogError.log(ex.getMessage());
							logger.info(ex.getMessage());
							JOptionPane.showMessageDialog(null,
								    ex.getMessage(),
								    ex.getMessage(),
								    JOptionPane.ERROR_MESSAGE);
						}
						
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
				try {
					panel_1.addBus(panel.getBus(Integer.parseInt(formattedTextField.getText())-1));
					panel_1.repaint();
					panel.repaint();
				} catch (Exception ex) {
					LogError.log(ex.getMessage());
					JOptionPane.showMessageDialog(null,
						    ex.getMessage(),
						    ex.getMessage(),
						    JOptionPane.ERROR_MESSAGE);
				}
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
			str[i-1] = "Уровеь  " + i;
		}

		list = new JList(str);
		list.setSelectedIndex(0);
		list.setBounds(904, 16, 140, 133);
		frame.getContentPane().add(list);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				logger.info("Изменен уровень парковки. Текущий уровень: " + list.getSelectedIndex());
				BusPanel.currentLevel = list.getSelectedIndex();
				panel.repaint();
				
			}
			
		});
		
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem load = new JMenuItem("Load");
		JMenuItem save_current = new JMenuItem("Save current level");
		JMenuItem load_current = new JMenuItem("Load current level");
		
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();  
				if (fc.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {  
				    try {  
				        panel.saveParking(fc.getSelectedFile().getPath()); 
				    }  
				    catch (Exception ex) {
						LogError.log(ex.getMessage());
						JOptionPane.showMessageDialog(null,
							    ex.getMessage(),
							    ex.getMessage(),
							    JOptionPane.ERROR_MESSAGE);
				    }  
				} 
			}
		});
		
		save_current.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();  
				if (fc.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {  
				    try {  
				        panel.saveCurrentParking(fc.getSelectedFile().getPath()); 
				    }  
				    catch (Exception ex) {
						LogError.log(ex.getMessage());
						JOptionPane.showMessageDialog(null,
							    ex.getMessage(),
							    ex.getMessage(),
							    JOptionPane.ERROR_MESSAGE);
				    }  
				} 
			}
		});

		
		load_current.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();  
				if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {  
					panel.loadCurrentParking(fc.getSelectedFile().getPath());
				}
			}
		});
		
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();  
				if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {  
					panel.loadParking(fc.getSelectedFile().getPath());
				}
			}
		});
		file.add(save);
		file.add(load);
		file.add(save_current);
		file.add(load_current);
		menuBar.add(file);
		frame.setJMenuBar(menuBar);
	}
}
