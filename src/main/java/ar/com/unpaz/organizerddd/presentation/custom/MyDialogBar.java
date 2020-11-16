package ar.com.unpaz.organizerddd.presentation.custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import javax.swing.JLabel;

public class MyDialogBar extends JLabel{
	private static final long serialVersionUID = 1L;

	private Point p1;
	private Point p2;
	private JLabel close;
	private JDialog mainFrame;

	public MyDialogBar(JDialog mainFrame,String option) {
		this.mainFrame = mainFrame;
	    setText("NUEVA NOTA");
	    setPreferredSize(new Dimension(300,40));
		setHorizontalAlignment(JLabel.CENTER);
		setForeground(Color.WHITE);
		setBackground(new Color(51,103,214));
		setOpaque(true);
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(getLabelClose());
		addMouseListener();
		addMouseMotionListener();
	}

	private void addMouseListener() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				p1 = new Point(e.getX(), e.getY());
			}
		});
	}

	private void addMouseMotionListener() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				p2 = MouseInfo.getPointerInfo().getLocation();
				mainFrame.setLocation(p2.x - p1.x, p2.y - p1.y);
			}
		});
	}

	private JLabel getLabelClose() {
		if (close == null) {
			close = new JLabel();
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image image = toolkit.getImage(getClass().getResource("/images/close.png"));
			ImageIcon icon = new ImageIcon(image);
			close.setIcon(icon);
			close.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					closeFrame();
					//System.exit(0);
				}
			});
		}
		return close;
	}

	public void closeFrame() {
		mainFrame.setVisible(false);
		mainFrame.dispose();
	
	}

	
}
