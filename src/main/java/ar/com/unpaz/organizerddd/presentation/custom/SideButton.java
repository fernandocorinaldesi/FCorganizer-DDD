package ar.com.unpaz.organizerddd.presentation.custom;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class SideButton extends JButton{

	private static final long serialVersionUID = 1L;
	float opacity = 1f;

	public SideButton(String title,String path) {
		super(title);
		addMouseListener(new EventButton());
		if(path!="") {
			setIcon(new ImageIcon(getClass().getResource(path)));
		}
		setFont(new Font("Serif", Font.BOLD,16));
		setForeground(new Color(95,99,104));
		setHorizontalAlignment(SwingConstants.LEFT);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setContentAreaFilled(false);
	}
	// Metodo get de mi variable "opacity"
		public float getOpacity() {
			return opacity;
		}
		
		public void changeIcon(String path) {
		setIcon(new ImageIcon(getClass().getResource(path)));
		
		}
		// Metodo set de mi variable "opacity"
		public void setOpacity(float opacity) {
			this.opacity = opacity;
			// Actualiza el control
			repaint();
		}

		// Sobreescribir el metodo del padre para que aparesca el boton, y pasarle
		// el valor de mi opacidad
		@Override
		public void paintComponent(Graphics g) {
			// Creamos un objeto de tipo Graphics2D y casteamos el valor que pasa
			// por parametro
			Graphics2D g2 = (Graphics2D) g;
			// Pasamos nuestra variable "opacity" al metodo
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
			// Usamos el metodo paintComponent del padre con "super"
			super.paintComponent(g2);
		}

		// Clase anidad
		public class EventButton extends MouseAdapter {
			// EL MOUSE SALE
			@Override
			public void mouseExited(MouseEvent me) {
				
				efectHover(0.5f, 1f, 0.03f, 10, true);
			}

			// EL MOUSE ENTRA
			@Override
			public void mouseEntered(MouseEvent me) {
				efectHover(1f, 0.5f, 0.03f, 10, false);
			}

			// HACES CLICK AL CONTROL
			@Override
			public void mousePressed(MouseEvent me) {
				efectHover(1f, 0.6f, 0.1f, 1, false);
			}

			// PROGRAMANDO EVENTO
			private void efectHover(float index, float range, float cont, int sleep, boolean event) {
				new Thread(() -> {
					for (float i = index; (event) ? i <= range : i >= range; i = (event) ? i + cont : i - cont) {
						setOpacity(i);
						try {
							Thread.sleep(sleep);
						} catch (InterruptedException e) {
						}

					}
				}).start();
			}
		}


}
