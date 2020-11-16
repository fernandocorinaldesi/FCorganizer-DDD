package ar.com.unpaz.organizerddd.presentation.custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyTitleBar extends JLabel {

	private static final long serialVersionUID = 1L;

	private Point p1;
	private Point p2;
	private JLabel mini;
	private JLabel close;
	private JLabel max;
	private JFrame mainFrame;

	public MyTitleBar(JFrame mainFrame, String s) {
		this.mainFrame = mainFrame;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		if (s.contentEquals("login")) {
			setHorizontalAlignment(JLabel.CENTER);
			Image image = toolkit.getImage(getClass().getResource("/images/organizer.png"));
			setIcon(new ImageIcon(image));
			setPreferredSize(new Dimension(900, 200));
			setBackground(new Color(47, 62, 80));
			setText("FC Organizer");
			setFont(new Font("Serif", Font.BOLD,32));
			
		}

		if (s.contentEquals("admin")) {
			setHorizontalAlignment(JLabel.LEFT);
			setFont(new Font("Serif", Font.BOLD,24));
			setText("FC Organizer");
			setPreferredSize(new Dimension(900, 40));
			setBackground(new Color(51,103,214));
			
			
		}
		setForeground(Color.WHITE);
		setOpaque(true);
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(getLabelMini());
		add(getLabelMax());
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
					System.exit(0);
				}
			});
		}
		return close;
	}

	public void closeFrame() {
		mainFrame.setVisible(false);
		mainFrame.dispose();
	}

	private JLabel getLabelMini() {
		if (mini == null) {
			mini = new JLabel();
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image image = toolkit.getImage(getClass().getResource("/images/mini.png"));
			ImageIcon icon = new ImageIcon(image);
			mini.setIcon(icon);
			mini.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					iconifiedFrame();
				}
			});
		}
		return mini;
	}
	private JLabel getLabelMax() {
		if (max == null) {
			max = new JLabel();
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image image = toolkit.getImage(getClass().getResource("/images/max.png"));
			ImageIcon icon = new ImageIcon(image);
			max.setIcon(icon);
			max.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					maximizedFrame();
				}
			});
		}
		return max;
	}

	public void iconifiedFrame() {
		mainFrame.setState(JFrame.ICONIFIED);
	}

	public void maximizedFrame() {
		if(mainFrame.getExtendedState()==JFrame.MAXIMIZED_BOTH) {
			mainFrame.setExtendedState(JFrame.NORMAL);
		}
		else {
			mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}

	}

}
