package ar.com.unpaz.organizerddd.presentation.userpanels;

import static javax.swing.BorderFactory.createTitledBorder;
import static javax.swing.border.TitledBorder.TOP;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.presentation.controllers.IController;
import ar.com.unpaz.organizerddd.presentation.custom.Fonts;

;

public class UserPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private UserTableModel userTablemodel;
	private JScrollPane scrollPane;
	private JButton reg;
	private JButton del;
	private JButton mod;
	private IController<User> controller;
	private UserDialog userdiag;


	public UserPanel() {
		setBackground(Color.WHITE);
		userTablemodel=new UserTableModel();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	   	add(UserTable());
		add(operationsPanel());
		initDialogs();
		initListeners();
		
	}

	private JScrollPane UserTable() {
		table = new JTable(userTablemodel);
		table.setBackground(Color.WHITE);
		scrollPane = new JScrollPane(table);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		table.getTableHeader().setBackground(Color.WHITE);
		table.setGridColor(Color.WHITE);

		table.addMouseListener(new MouseAdapter() {// listener para obtener los datos de las filas y columnas
			@Override
			public void mouseClicked(MouseEvent e) {
				 int col = table.convertRowIndexToModel(table.getSelectedRow()); 
				 String dni = table.getModel().getValueAt(col,1).toString();
				 System.out.println(dni);
				
			}
		});
		scrollPane.setBorder(createTitledBorder(null, "Lista de Usuarios", TitledBorder.CENTER, TOP));
		return scrollPane;
	}

	private JPanel operationsPanel() {
		
		//JButton aceptar = new JButton("Agregar");
		//aceptar.setBackground(new Color(51, 103, 214));
		//aceptar.setForeground(Color.WHITE);
		
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout());
		pane.setBackground(Color.WHITE);
		reg = new JButton("Agregar");
		mod = new JButton("Modificar");
		del = new JButton("Borrar");

		reg.setFont(Fonts.BTN);
		reg.setForeground(Color.white);
		mod.setFont(Fonts.BTN);
		mod.setForeground(Color.white);
		del.setFont(Fonts.BTN);
		del.setForeground(Color.white);

		reg.setBackground(new Color(47, 62, 80));
		mod.setBackground(Color.GRAY);
		del.setBackground(new Color(157, 0, 0));
		//reg.setBackground(new Color(51, 103, 214));
		//mod.setBackground(new Color(51, 103, 214));
		//del.setBackground(new Color(51, 103, 214));

		pane.add(reg);
		pane.add(mod);
		pane.add(del);
        pane.setBorder(createTitledBorder(null, "Operaciones", TitledBorder.CENTER, TOP));
		return pane;
	}
	private void initDialogs(){
		userdiag=new UserDialog();
		
	}

	private void initListeners() {
		reg.addActionListener((event) -> {
			
			userdiag.setVisible(true);
		});
		mod.addActionListener((event) -> {

		});
		del.addActionListener((event) -> {

		});
	}


	public void setController(IController<User> controller) {
		// TODO Auto-generated method stub
		this.controller=controller;
		userdiag.setDialogController(controller);
	}

	public void loadUserList() {
		// TODO Auto-generated method stub
		userTablemodel.update(controller.get());
	}

	public void updateFromDb() {
		// TODO Auto-generated method stub
		
	}


}
