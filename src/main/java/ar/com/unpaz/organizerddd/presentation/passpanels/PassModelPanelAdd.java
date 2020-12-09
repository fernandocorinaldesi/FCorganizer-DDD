package ar.com.unpaz.organizerddd.presentation.passpanels;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ar.com.unpaz.organizerddd.domain.entitys.Password;
import ar.com.unpaz.organizerddd.transversalinfrastructure.EnviromentVariables;

public class PassModelPanelAdd extends PassModelPanel {

	private static final long serialVersionUID = 1L;
	public PassModelPanelAdd() {
		setEditableFields();
		addListener();
		setMaximumSize(new Dimension(Integer.MAX_VALUE, getMinimumSize().height));
	}

	public void addListener() {
		JButton aceptar = new JButton("Agregar");
		aceptar.setBackground(new Color(51, 103, 214));
		aceptar.setForeground(Color.WHITE);
		aceptar.addActionListener(event -> {
			addPassword();
		});
		add(aceptar);
		setBackground(Color.WHITE);
	}
	
	private void addPassword() {
		if (controller.validate(getNewPassword())) {
			if (controller.register(getNewPassword())) {
				clearFields();
			} else {
				JOptionPane.showMessageDialog(null, EnviromentVariables.APPERRORS, "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			showFrontErrorMsg(controller.getErrors());
		}
	}

	private void showFrontErrorMsg(List<String> list) {
		String to_print = "";
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).isEmpty()) {
				to_print+=list.get(i)+"\n";
			}
		}
		JOptionPane.showMessageDialog(null,to_print, "Se encontraron los siguientes errores", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void setEditableFields() {
		site.setEditable(true);
		pass.setEditable(true);
		user.setEditable(true);
	}

	private Password getNewPassword() {
		String site = getSite();
		String user = getUser();
		String pass = getPass();
		return new Password(site, user, pass,EnviromentVariables.loggedUserDni);
	}

}
