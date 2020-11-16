package ar.com.unpaz.organizerddd.presentation.userpanels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import ar.com.unpaz.organizerddd.domain.entitys.User;

public class UserTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private List<User> user;
	private static String[] COLUMNAS = { "Dni", "Nombre", "Apellido", "Usuario", "Contraseña"};

	public UserTableModel(List<User> user) {
		super();
		this.user = user;
	}

	public UserTableModel() {

	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return user.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COLUMNAS.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Object retorno = null;

		User u = this.user.get(rowIndex);
		switch (columnIndex) {
		case 0:
			retorno = String.valueOf(u.getDni());
			break;
		case 1:
			retorno = u.getName();
			break;
		case 2:
			retorno = u.getSecondName();
			break;
		case 3:
			retorno = u.getUser();
			break;
		case 4:
			retorno = u.getPass();
			break;
		}
		return retorno;
	}

	public void update(List<User> user) {
		this.user = user;
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int index) {
		return COLUMNAS[index];
	}

	public User getInRow(int row) {
		return user.get(row);

	}

}
