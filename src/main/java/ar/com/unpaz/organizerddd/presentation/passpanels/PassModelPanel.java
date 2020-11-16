package ar.com.unpaz.organizerddd.presentation.passpanels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.border.DropShadowBorder;

import ar.com.unpaz.organizerddd.domain.entitys.Password;
import ar.com.unpaz.organizerddd.presentation.controllers.IController;

public abstract class PassModelPanel extends JXPanel {
	private static final long serialVersionUID = 1L;
	private JTextField id;
	protected JTextField user;
	protected JPasswordField pass;
	protected JTextField site;
	protected PassPanel passpanel;
	protected IController<Password> controller;

	public PassModelPanel() {
		setLayout(new FlowLayout());
		createMainPanel();
		setMaximumSize(new Dimension(getMinimumSize().width,getMinimumSize().height));
		DropShadowBorder shadow = new DropShadowBorder(Color.DARK_GRAY, 10);
		shadow.setShowLeftShadow(true);
		shadow.setShowRightShadow(true);
		shadow.setShowBottomShadow(true);
		shadow.setShowTopShadow(true);
		this.setBorder(shadow);
		setBackground(Color.WHITE);

	}

	private void createMainPanel() {
		JLabel labelPass;
		JLabel labelUser;
		JLabel labelSite;

		id = new JTextField(1);

		site = new JTextField(20);
		labelSite = new JLabel("Sitio Web");
		labelSite.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		user = new JTextField(20);
		labelUser = new JLabel("Usuario");
		labelUser.setAlignmentX(Component.CENTER_ALIGNMENT);

		pass = new JPasswordField(10);
		labelPass = new JLabel("Contraseña");
		labelPass.setAlignmentX(Component.CENTER_ALIGNMENT);

	
		add(labelSite);
		add(site);
		add(labelUser);
		add(user);
		add(labelPass);
		add(pass);
		setBackground(Color.WHITE);
	}

	public abstract void setEditableFields();

	public abstract void addListener();
	
	
	public int getPassId() {
		return Integer.parseInt(id.getText());
	}

	public JTextField getUserField() {
		return user;
	}

	public JPasswordField getPassField() {
		return pass;
	}

	public JTextField getSiteField() {
		return site;
	}

	public String getUser() {
		return user.getText();
	}

	public String getPass() {
		return new String(pass.getPassword());
	}

	public String getSite() {
		return site.getText();
	}

	public void setPassId(String PassId) {
		this.id.setText(PassId);
	}

	public void setUser(String user) {
		this.user.setText(user);
	}

	public void setPass(String pass) {
		this.pass.setText(pass);
	}

	public void setSite(String pass) {
		this.site.setText(pass);
	}

	public void clearFields() {
		setSite("");
		setPass("");
		setUser("");
	}

	public void setController(IController<Password> controller) {
	   this.controller=controller;
		
	}

	

}
