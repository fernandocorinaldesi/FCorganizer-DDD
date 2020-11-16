package ar.com.unpaz.organizerddd.presentation.passpanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ar.com.unpaz.organizerddd.domain.entitys.Password;
import ar.com.unpaz.organizerddd.presentation.controllers.IController;



public class PassPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrolpane;
	private JPanel innerPanel;
	private List<Password> password;
	private IController<Password> controller;
	private PassModelPanel add;
	private PassModelPanel passmodelpanel;
	private EmptyPanel empty;
	private String emptymsg = "Todavia no tiene ninguna contraseña almacenada";
	
	
	public PassPanel() {
		initPanels();
	}
	private void initPanels() {
		setLayout(new BorderLayout());
		empty = new EmptyPanel();
		empty.setMsj(emptymsg);
		add=new PassModelPanelAdd();
		add(createCenter(), BorderLayout.CENTER);
		add(add,BorderLayout.SOUTH);
		setBackground(Color.WHITE);
	}
	private JScrollPane createCenter() {
		scrolpane = new JScrollPane();
		innerPanel = new JPanel();
		innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
		scrolpane.setViewportView(innerPanel);
		scrolpane.getVerticalScrollBar().setUnitIncrement(16);
		innerPanel.setBackground(Color.WHITE);
		return scrolpane;
	}
    public void setController(IController<Password> pass) {
    	controller=pass;
      	add.setController(pass);
    	
    }
	public void getPasswordsList() {
		password = controller.get();
	}

	public IController<Password> getController() {
		return controller;
	}

	public void updateFromDb() {
		innerPanel.removeAll();
		getPasswordsList();
		loadPassList();
	}

	public void removeComponent(Component pass) {
		innerPanel.remove(pass);
		if (isInnerPanelEmpty())
			innerPanel.add(empty);
	
	}
	public void update() {
		validate();
		repaint();
	}
	public void loadPassList() {
		getPasswordsList();
		for (Password pass : password) {
			passmodelpanel = new PassModelPanelList(this);
			passmodelpanel.setPassId(String.valueOf(pass.getPassId()));
			passmodelpanel.setUser(pass.getUser());
			passmodelpanel.setPass(pass.getPass());
			passmodelpanel.setSite(pass.getSite());
			innerPanel.add(passmodelpanel);
			
			}
		update();
		if (isInnerPanelEmpty())
			innerPanel.add(empty);
	}
	
	
	private boolean isInnerPanelEmpty() {
		return (innerPanel.getComponentCount() == 0);
	}
	public void removeAllPasswords() {
		// TODO Auto-generated method stub
		innerPanel.removeAll();
	}


}
