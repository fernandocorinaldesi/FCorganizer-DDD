package ar.com.unpaz.organizerddd.presentation.userpanels;

import static javax.swing.BorderFactory.createTitledBorder;
import static javax.swing.border.TitledBorder.TOP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.locator.Context;
import ar.com.unpaz.organizerddd.presentation.controllers.IController;
import ar.com.unpaz.organizerddd.presentation.custom.Fonts;
import ar.com.unpaz.organizerddd.presentation.custom.MyDialogBar;

public class UserDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int WIDTH = 300;
	private final int HEIGHT = 400;
	private JLabel nameLabel;
	private JLabel secondNameLabel;
	private JLabel dniLabel;
	private JLabel userNameLabel;
	private JLabel passLabel;
	private JTextField nameField;
	private JTextField secondNameField;
	private JTextField dniField;
	private JTextField userField;
	private JTextField passField;
	private JButton accept;
	private JButton cancel;
	private IController<User> controller;

	public UserDialog() {
		initConfig();
		initPanels();
		initlisteners();
		getRootPane().setBorder(BorderFactory.createLineBorder(new Color(47, 62, 80)));
	}

	private void initlisteners() {
		// TODO Auto-generated method stub
		accept.addActionListener((event) -> {
			if (controller.validate(createUser())) {
				if (controller.register(sendUser())) {
					clearFields();
					dispose();
					JOptionPane.showMessageDialog (null, "El usuario fue creado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, Context.APPERRORS, "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				showFrontErrorMsg(controller.getErrors());
			}
		});
		cancel.addActionListener((event) -> {
			dispose();
		});
	}
	private void showFrontErrorMsg(List<String> list) {
		String to_print = "";
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).isEmpty()) {
				to_print+=list.get(i)+"\n";
				
			}
		}
		JOptionPane.showMessageDialog(this,to_print, "Se encontraron los siguientes errores", JOptionPane.ERROR_MESSAGE);
	}
	private User createUser() {
		String name =nameField.getText();
		String secondName =secondNameField.getText();
		String user = userField.getText();
		String pass =passField.getText();
		String dni =dniField.getText();
		return new User(dni,name,secondName,user,pass);
	}
	private User sendUser() {
		String name =nameField.getText();
		String secondName =secondNameField.getText();
		String user = userField.getText();
		String pass =passField.getText();
		String dni =dniField.getText();
		int Dni =dni.isEmpty()?0:Integer.parseInt(dni);
		return new User(Dni,name,secondName,user,pass);
	}
	public void clearFields() {
		nameField.setText("");
		secondNameField.setText("");
		dniField.setText("");
		userField.setText("");
		passField.setText("");
		
	}

	private void initConfig() {
		// TODO Auto-generated method stub
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initPanels() {
		getContentPane().add(new MyDialogBar(this, "Crear o modificar usuario"), BorderLayout.NORTH);
		getContentPane().add(createCenter(), BorderLayout.CENTER);
		getContentPane().add(createSouth(), BorderLayout.SOUTH);
	}

	private JPanel createSouth() {
		// TODO Auto-generated method stub
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout());
		cancel = new JButton("Cancelar");
		accept = new JButton(" Aceptar ");

		cancel.setFont(Fonts.BTNDIALOG);
		cancel.setForeground(Color.white);
		accept.setFont(Fonts.BTNDIALOG);
		accept.setForeground(Color.white);
		accept.setBackground(new Color(51, 103, 214));
		// accept.setBackground(new Color(47,62,80));
		cancel.setBackground(new Color(157, 0, 0));

		pane.add(accept);
		pane.add(cancel);
		return pane;
	}

	private JPanel createCenter() {
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));

		JPanel panecred = new JPanel();

		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(3, 2, 0, 20));
		panecred.setLayout(new GridLayout(2, 2, 0, 20));

		nameLabel = new JLabel("Nombre");
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		secondNameLabel = new JLabel("Apellido");
		secondNameLabel.setHorizontalAlignment(JLabel.CENTER);
		dniLabel = new JLabel("Dni");
		dniLabel.setHorizontalAlignment(JLabel.CENTER);
		userNameLabel = new JLabel("Usuario");
		userNameLabel.setHorizontalAlignment(JLabel.CENTER);
		passLabel = new JLabel("Password");
		passLabel.setHorizontalAlignment(JLabel.CENTER);

		nameField = new JTextField(10);
		secondNameField = new JTextField(10);
		dniField = new JTextField(10);
		userField = new JTextField(10);
		passField = new JTextField(10);

		pane.add(nameLabel);
		pane.add(nameField);
		pane.add(secondNameLabel);
		pane.add(secondNameField);
		pane.add(dniLabel);
		pane.add(dniField);
		panecred.add(userNameLabel);
		panecred.add(userField);
		panecred.add(passLabel);
		panecred.add(passField);

		pane.setBorder(createTitledBorder(null, "Datos de usuario", TitledBorder.CENTER, TOP));
		panecred.setBorder(createTitledBorder(null, "Credenciales de authenticacion", TitledBorder.CENTER, TOP));
		mainpanel.add(pane);
		mainpanel.add(panecred);
		return mainpanel;
	}
	public void setDialogController(IController<User> controller) {
		this.controller=controller;
	}

}
