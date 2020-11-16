package ar.com.unpaz.organizerddd.presentation.mainview;

import static javax.swing.BorderFactory.createTitledBorder;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.border.TitledBorder.TOP;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class AboutView extends JPanel {

	private static final String FER_LINKEDIN_URL = "https://ar.linkedin.com/in/fernando-corinaldesi-2a839b175";
	private static final String FER_GITHUB_URL = "https://github.com/fernandocorinaldesi";
	private static final String FER_FACEBOOK_URL = "https://www.facebook.com/fernando.corinaldesi";
	private static final long serialVersionUID = 1L;
	private Font f = new Font("Serif", Font.BOLD,14);

	public AboutView() {
    	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		add(createNorthPane());
		add(createInfo());
		add(createContact());
	}

	private JPanel createNorthPane() {
		JPanel panel = new JPanel();
		JLabel labelTitle = new JLabel("FC Organizer");
		labelTitle.setFont(new Font("Times New Roman",Font.BOLD,28));
		labelTitle.setForeground(new Color(169,173,177));
		panel.setBackground(Color.WHITE);
		panel.add(labelTitle);
		return panel;
	}

	private JPanel createInfo() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(createTitledBorder(null, "INFO", TitledBorder.CENTER, TOP));
		panel.setFont(f);
		panel.setBackground(Color.WHITE);
		panel.add(name());
		panel.add(version());
		panel.add(lenguaje());
		panel.add(db());
		return panel;
	}

	private JPanel createContact() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(createTitledBorder(null, "CONTACTO", TitledBorder.CENTER, TOP));
		panel.setFont(f);
		panel.setBackground(Color.WHITE);
		panel.add(whatsapp());
		panel.add(linkedin());
		panel.add(github());
		panel.add(facebook());
		return panel;
	}

	private JPanel whatsapp() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Whatsapp : 11-2829-6699");
		panel.add(label);
		panel.setBackground(Color.WHITE);
		return panel;
	}

	private JPanel name() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Desarrollador : Fernando Corinaldesi");
		panel.add(label);
		panel.setBackground(Color.WHITE);
		return panel;
	}

	private JPanel version() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Version del software : 0.0.1");
		panel.add(label);
		panel.setBackground(Color.WHITE);
		return panel;
	}

	private JPanel lenguaje() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Lenguaje : JavaSE8");
		panel.add(label);
		panel.setBackground(Color.WHITE);
		return panel;
	}

	private JPanel db() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Base de datos : HYPER-SQL");
		panel.add(label);
		panel.setBackground(Color.WHITE);
		return panel;
	}

	private JPanel linkedin() {
		JPanel panel = new JPanel();
		JLabel labelContactLink = new JLabel("Linkedin : ");
		JLabel ferLinkedin = new JLabel(new ImageIcon(getClass().getResource("/images/linkedin.png")));
		ferLinkedin.setToolTipText(FER_LINKEDIN_URL);
		ferLinkedin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				openURI(ferLinkedin.getToolTipText());
			}
		});
		panel.add(labelContactLink);
		panel.add(ferLinkedin);
		panel.setBackground(Color.WHITE);
		return panel;

	}

	private JPanel github() {
		JPanel panel = new JPanel();
		JLabel labelContactGit = new JLabel("GitHub : ");
		JLabel ferGithub = new JLabel(new ImageIcon(getClass().getResource("/images/github.png")));
		ferGithub.setToolTipText(FER_GITHUB_URL);
		ferGithub.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				openURI(ferGithub.getToolTipText());
			}
		});
		panel.add(labelContactGit);
		panel.add(ferGithub);
		panel.setBackground(Color.WHITE);
		return panel;

	}

	private JPanel facebook() {
		JPanel panel = new JPanel();
		JLabel labelName = new JLabel("Facebook : ");
		JLabel labelFer = new JLabel(new ImageIcon(getClass().getResource("/images/facebook.png")));
		labelName.setToolTipText(FER_FACEBOOK_URL);
		labelName.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				openURI(labelName.getToolTipText());
			}
		});
		panel.add(labelName);
		panel.add(labelFer);
		panel.setBackground(Color.WHITE);
		return panel;

	}

	private void openURI(String uri) {
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.browse(new URI(uri));
		} catch (Exception e1) {
			showMessageDialog(null, "Navegador no soportado");
		}
	}

}
