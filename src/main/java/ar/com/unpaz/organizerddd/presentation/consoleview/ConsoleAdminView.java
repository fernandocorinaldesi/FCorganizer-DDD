package ar.com.unpaz.organizerddd.presentation.consoleview;

import java.util.List;
import java.util.Scanner;

import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.presentation.controllers.IController;
import ar.com.unpaz.organizerddd.presentation.mainview.MainViewOperations;
import ar.com.unpaz.organizerddd.transversalinfrastructure.LoginController;

public class ConsoleAdminView implements MainViewOperations<User> {

	private IController<User> controller;
	private int option;
	private Scanner scan;
	private ArtCreator art;
	private List<User> userList;

	public ConsoleAdminView() {
		// TODO Auto-generated constructor stub
		art = new ArtCreator();
		scan = new Scanner(System.in);
	}

	@Override
	public void setVisible() {
		// TODO Auto-generated method stub
		art.ShowArt("Bienvenido al modulo admin");
		System.out.println("\n");
		do {
			showMenu();
			loadOptions();

		} while (option != 4);
	}

	private void showMenu() {
		System.out.println("1-MOSTRAR USUARIOS");
		System.out.println("2-CREAR UN NUEVO USUARIO");
		System.out.println("3-BORRAR UN USUARIO");
		System.out.println("4-SALIR");
	}

	private void loadOptions() {

		System.out.println("Seleccionar una opcion");
		option = scan.nextInt();
		switch (option) {
		case 1:
			showPasswordList();
			break;
		case 2:
			System.out.println("Falta implementar");
			break;
		case 3:
			System.out.println("Falta implementar");
			break;
		case 4:
			System.out.println("Aplicacion cerrada");
			break;

		}
	}

	private void showPasswordList() {
		// TODO Auto-generated method stub
		for (User us : userList) {
			System.out.println(us);
		}
		System.out.println("\n");
	}

	@Override
	public void setController(IController<User> controller) {
		// TODO Auto-generated method stub
		this.controller = controller;
	}

	@Override
	public void setLogOut(LoginController login) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		userList = controller.get();
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showInMemWarning() {
		// TODO Auto-generated method stub
	}

	
}
