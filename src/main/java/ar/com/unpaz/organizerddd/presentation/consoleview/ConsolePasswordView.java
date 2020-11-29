package ar.com.unpaz.organizerddd.presentation.consoleview;

import java.util.List;
import java.util.Scanner;

import ar.com.unpaz.organizerddd.domain.entitys.Password;
import ar.com.unpaz.organizerddd.presentation.controllers.IController;
import ar.com.unpaz.organizerddd.presentation.mainview.MainViewOperations;
import ar.com.unpaz.organizerddd.transversalinfrastructure.LoginController;

public class ConsolePasswordView implements MainViewOperations<Password> {
	
	private IController<Password> controller;
	private int option = 0;
	private Scanner scan;
	private ArtCreator art;
	private List<Password> passList;

	public ConsolePasswordView() {
		// TODO Auto-generated constructor stub
		scan = new Scanner(System.in);
		art = new ArtCreator();
	}

	@Override
	public void setVisible() {
		// TODO Auto-generated method stub
		art.ShowArt("Bienvenidos a FCORGANIZER");
		System.out.println("\n");
		art.ShowArt("Version consola");
		System.out.println("\n");
		do {
			showMenu();
			loadOptions();

		} while (option != 4);
	}

	private void showMenu() {
		System.out.println("1-MOSTRAR CONTRASEÑAS");
		System.out.println("2-INGRESAR UNA NUEVA CONTRASEÑA");
		System.out.println("3-BORRAR CONTRASEÑA");
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
		for (Password pass : passList) {
			System.out.println(pass);
		}
		System.out.println("\n");
	}

	@Override
	public void setController(IController<Password> controller) {
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
		passList = controller.get();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		passList = controller.get();
	}

	@Override
	public void showInMemWarning() {
		// TODO Auto-generated method stub
		
	}

}
