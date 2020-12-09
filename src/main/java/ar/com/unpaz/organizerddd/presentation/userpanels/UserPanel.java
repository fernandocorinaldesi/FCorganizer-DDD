package ar.com.unpaz.organizerddd.presentation.userpanels;

import static javax.swing.BorderFactory.createTitledBorder;
import static javax.swing.border.TitledBorder.TOP;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
	private UserDialog userdiagAdd;
	private UserDialog userdiagUp;


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
		
		pane.add(reg);
		pane.add(mod);
		pane.add(del);
        pane.setBorder(createTitledBorder(null, "Operaciones", TitledBorder.CENTER, TOP));
		return pane;
	}
	private void initDialogs(){
		 userdiagAdd=new UserDialogAdd();
		 userdiagUp=new UserDialogUpdate();
		
	}

	private void initListeners() {
		reg.addActionListener((event) -> {
			userdiagAdd.setController(controller);
			userdiagAdd.setVisible(true);
			
		
		});
		mod.addActionListener((event) -> {
			userdiagUp.setController(controller);
			userdiagUp.setUser(createUser());
			userdiagUp.setVisible(true);
		});
		del.addActionListener((event) -> {
           controller.delete(createUser());
           JOptionPane.showMessageDialog (this, "El usuario fue eliminado", "Exito", JOptionPane.INFORMATION_MESSAGE);
        });
	}
	
	private User createUser() {
		 int col ; 
		 int dni = 0 ;
		 String name = "" ;
		 String secondName = "";
		 String usr ="" ;
		 String pass = "";
		 
		 col = table.convertRowIndexToModel(table.getSelectedRow()); 
		 dni = Integer.parseInt(table.getModel().getValueAt(col,0).toString());
		 name = table.getModel().getValueAt(col,1).toString();
		 secondName = table.getModel().getValueAt(col,2).toString();
		 usr = table.getModel().getValueAt(col,3).toString();
		 pass = table.getModel().getValueAt(col,4).toString();
			 
		return new User(dni,name,secondName,usr,pass);
	}


	public void setController(IController<User> controller) {
		// TODO Auto-generated method stub
		this.controller=controller;
	}

	public void loadUserList() {
		// TODO Auto-generated method stub
		List<User> userList=controller.get();
		if(userList.isEmpty()) {
			mod.setEnabled(false);
			del.setEnabled(false);
		}
		else {
			mod.setEnabled(true);
			del.setEnabled(true);
		}
		userTablemodel.update(userList);
	}

	public void updateFromDb() {
		// TODO Auto-generated method stub
		
	}


}
