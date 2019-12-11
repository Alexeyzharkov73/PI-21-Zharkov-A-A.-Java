package labs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.util.logging.Logger;

public class CreateBusPanel extends JPanel implements DropTargetListener {

	private ITransport bus;
	private Logger logger;
	
	public CreateBusPanel() {
		super();
		logger = Logger.getGlobal();
		new DropTarget(this, this);
		this.setLayout(null);
		DraggableLabel lblNewLabel = new DraggableLabel(
				"\u041E\u0441\u043D\u043E\u0432\u043D\u043E\u0439 \u0446\u0432\u0435\u0442", true, new ColorCallBack() {
					@Override
					public void setColor(Color c) {
						if (bus != null) {
							logger.info("Основной цвет автобуса изменен");
							bus.setBodyColor(c);
						}
						repaint();
					}
				});
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 120, 161, 26);
		lblNewLabel.setBorder(border);
		DraggableLabel label_9 = new DraggableLabel(
				"\u0414\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u044B\u0439 \u0446\u0432\u0435\u0442",
				true, new ColorCallBack() {
					@Override
					public void setColor(Color c) {
						if (bus != null) {
							if (bus instanceof Bus) {
								logger.info("Дополнительный цвет автобуса изменен");
								((Bus) bus).setDopColor(c);
							}
						}
						repaint();
					}
				});
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(10, 150, 161, 26);
		label_9.setBorder(border);
		this.add(lblNewLabel);
		this.add(label_9);
	}

	public ITransport getBus() {
		return bus;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (bus != null) {
			bus.setPosition(40, 25,140, 221);
			bus.drawBus(g, new DoorsDraw());
		}
	}

	@Override
	public void dragEnter(DropTargetDragEvent dtde) {

	}

	@Override
	public void dragExit(DropTargetEvent dte) {

	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {

	}

	@Override
	public void drop(DropTargetDropEvent dtde) {
		try {
			Transferable transferable = dtde.getTransferable();
			if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				String dragContents = (String) transferable.getTransferData(DataFlavor.stringFlavor);
				if (dragContents.equals("BaseBus")) {
					logger.info("Выбран автобус: BaseBus");
					bus = new BaseBus(50,5,Color.black);
					repaint();
				} else if (dragContents.equals("Bus")) {
					logger.info("Выбран автобус: Bus");
					bus = new Bus(50,5,Color.black,Color.black, true, Doors.FIVE);
					repaint();
				} else if (dragContents.equals("1")) {
					if(bus != null) {
						bus.setDoorsForm(0);
						repaint();
					}
				} else if (dragContents.equals("2")) {
					if(bus != null) {
						bus.setDoorsForm(1);
						repaint();
					}
					
				} else if (dragContents.equals("3")) {
					if(bus != null) {
						bus.setDoorsForm(2);
						repaint();
					}
					
				} else {
					dtde.rejectDrop();
				}
			} else {
				dtde.rejectDrop();
			}
		} catch (IOException e) {
			dtde.rejectDrop();
		} catch (UnsupportedFlavorException e) {
			dtde.rejectDrop();
		}
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {

	}

}