package ar.com.unpaz.organizerddd.presentation.userpanels;

import javax.swing.JOptionPane;

import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.presentation.controllers.IController;
import ar.com.unpaz.organizerddd.transversalinfrastructure.EnviromentVariables;

public class UserDialogAdd extends UserDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void initlisteners() {
		// TODO Auto-generated method stub
		
		accept.addActionListener((event) -> {
			if (controller.validate(createUser())) {
				if (controller.register(sendUser())) {
					clearFields();
					dispose();
					JOptionPane.showMessageDialog (null, "El usuario fue creado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, EnviromentVariables.APPERRORS, "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				showFrontErrorMsg(controller.getErrors());
			}
		});
		cancel.addActionListener((event) -> {
			dispose();
		});
	}

	@Override
	public void setController(IController<User> controller) {
		// TODO Auto-generated method stub
		this.controller=controller;
	}
	

}
