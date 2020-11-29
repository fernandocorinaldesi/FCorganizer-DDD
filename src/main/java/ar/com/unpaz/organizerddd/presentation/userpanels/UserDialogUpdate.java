package ar.com.unpaz.organizerddd.presentation.userpanels;

import javax.swing.JOptionPane;

import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.locator.Context;
import ar.com.unpaz.organizerddd.presentation.controllers.IController;

public class UserDialogUpdate extends UserDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserDialogUpdate() {
		
	}

	@Override
	public void initlisteners() {
		// TODO Auto-generated method stub
		accept.addActionListener((event) -> {
			if (controller.validate(createUser())) {
				if (controller.update(sendUser())) {
					clearFields();
					dispose();
					JOptionPane.showMessageDialog (this, "El usuario fue modificado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, Context.APPERRORS, "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				showFrontErrorMsg(controller.getErrors());
			}
		});
		cancel.addActionListener((event) -> {
			dispose();
		});
		
	}
	public void setUser(User user) {
		this.dniField.setText(String.valueOf(user.getDni()));
		this.dniField.setEditable(false); 
		this.nameField.setText(user.getName());
		this.secondNameField.setText(user.getSecondName());
		this.userField.setText(user.getUser());
		this.passField.setText(user.getPass());
	}
	@Override
	public void setController(IController<User> controller) {
		// TODO Auto-generated method stub
		this.controller=controller;
	}

}
