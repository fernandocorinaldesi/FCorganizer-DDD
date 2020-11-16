package ar.com.unpaz.organizerddd.presentation.mainview;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.unpaz.organizerddd.domain.entitys.Password;
import ar.com.unpaz.organizerddd.presentation.controllers.IController;
import ar.com.unpaz.organizerddd.presentation.custom.SideButton;
import ar.com.unpaz.organizerddd.presentation.passpanels.PassPanel;
import ar.com.unpaz.organizerddd.transversalinfrastructure.LoginController;


public class MainView extends AbstractMainView<Password> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PassPanel passpanel;
	private SideButton passButton;
	private LoginController login;
	
	public void initListener() {

		passButton.addActionListener(e -> {
			cardLayout.show(cardPanel, "pass");
			passButton.setBackground(Color.DARK_GRAY);

		});
	
		aboutButton.addActionListener(e -> {
			cardLayout.show(cardPanel, "about");
		});
		exitButton.addActionListener(e -> {
			login.closeView();
			dispose();
			
		});
		logOutButton.addActionListener(e -> {
			dispose();
			passpanel.removeAllPasswords();
			login.startView();
		});
	
				

	}
	public JPanel createCenter() {
		cardPanel = new JPanel();
		cardPanel.setLayout(new CardLayout());
		cardPanel.add(new AboutView(),"about");
		cardPanel.add(passpanel=new PassPanel(),"pass");
		cardLayout = (CardLayout) cardPanel.getLayout();
		return cardPanel;

	}

	public JPanel createSidePanel() {
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(10, 1, 0, 0));
		pane.setBorder(new EmptyBorder(0, 0, 0, 0));
		passButton = new SideButton("Contraseñas", "/images/newUser.png");
		aboutButton = new SideButton("Acerca", "/images/about.png");
		logOutButton = new SideButton("log out", "/images/logout.png");
		exitButton = new SideButton("Salir", "/images/exit.png");
		pane.add(passButton);
		pane.add(aboutButton);
		pane.add(logOutButton);
		pane.add(exitButton);
		pane.setBackground(new Color(255,255,255));
		
		return pane;
	}

	
	@Override
	public void setVisible() {
		setLocationRelativeTo(null);
		setVisible(true);
	}


	@Override
	public void setPanelController(IController<Password> controller) {
		// TODO Auto-generated method stub
		this.passpanel.setController(controller);
	}
	@Override
	public void loadPanelData() {
		// TODO Auto-generated method stub
		this.passpanel.loadPassList();
	}
	@Override
	public void updatePanelData() {
		// TODO Auto-generated method stub
		this.passpanel.updateFromDb();
	}
	@Override
	public void setLogOut(LoginController login) {
		// TODO Auto-generated method stub
		this.login=login;
	}
	
	
	
}
