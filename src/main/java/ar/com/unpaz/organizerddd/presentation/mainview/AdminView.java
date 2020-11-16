package ar.com.unpaz.organizerddd.presentation.mainview;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.presentation.controllers.IController;
import ar.com.unpaz.organizerddd.presentation.custom.SideButton;
import ar.com.unpaz.organizerddd.presentation.userpanels.UserPanel;
import ar.com.unpaz.organizerddd.transversalinfrastructure.LoginController;

public class AdminView extends AbstractMainView<User> {
	private static final long serialVersionUID = 1L;
	private SideButton usersButton;
	private UserPanel userpanel;
	private LoginController login;
	
	
	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		usersButton.addActionListener(e -> {
			cardLayout.show(cardPanel, "users");
			usersButton.setBackground(Color.DARK_GRAY);

		});
		aboutButton.addActionListener(e -> {
			cardLayout.show(cardPanel, "about");
		});
		exitButton.addActionListener(e -> {
			dispose();
		});
		logOutButton.addActionListener(e -> {
			dispose();
			login.startView();
		});
	
	}

	

	@Override
	public JPanel createCenter() {
		cardPanel = new JPanel();
		cardPanel.setLayout(new CardLayout());
		cardPanel.add(new AboutView(),"about");
		cardPanel.add(userpanel=new UserPanel(),"users");
		cardLayout = (CardLayout) cardPanel.getLayout();
		return cardPanel;

	}
	
	@Override
	public JPanel createSidePanel() {
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(10, 1, 0, 0));
		pane.setBorder(new EmptyBorder(0, 0, 0, 0));
		usersButton = new SideButton("Usuarios", "/images/newUser.png");
		aboutButton = new SideButton("Acerca", "/images/about.png");
		logOutButton = new SideButton("log out", "/images/logout.png");
		exitButton = new SideButton("Salir", "/images/exit.png");
		pane.add(usersButton);
		pane.add(aboutButton);
		pane.add(logOutButton);
		pane.add(exitButton);
		pane.setBackground(new Color(255,255,255));
		
		return pane;
	}
	
	

	@Override
	public void setPanelController(IController<User> controller) {
		// TODO Auto-generated method stub
		this.userpanel.setController(controller);
	}
	@Override
	public void loadPanelData() {
		// TODO Auto-generated method stub
		this.userpanel.loadUserList();
	}
	@Override
	public void updatePanelData() {
		// TODO Auto-generated method stub
		this.userpanel.loadUserList();
	}

	@Override
	public void setLogOut(LoginController login) {
		// TODO Auto-generated method stub
		this.login=login;
	}


	
	
	
	
	
	
}