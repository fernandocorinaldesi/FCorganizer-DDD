package ar.com.unpaz.organizerddd.presentation.passpanels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EmptyPanel extends JPanel{

	private static final long serialVersionUID = 1L;
    private JLabel empty;
	
	public EmptyPanel() {
		    setLayout(new FlowLayout());
	        setBackground(Color.WHITE);
	        empty = new JLabel();
	        empty.setFont(new Font("Times New Roman",Font.BOLD,28));
			empty.setForeground(new Color(169,173,177));
			add(empty);
	}
	public void setMsj(String msj) {
	    empty.setText(msj);
	}

}
