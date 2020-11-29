package ar.com.unpaz.organizerddd.presentation.consoleview;

import java.util.Scanner;

import ar.com.unpaz.organizerddd.presentation.loginview.LoginViewOperations;
import ar.com.unpaz.organizerddd.transversalinfrastructure.LoginController;

public class ConsoleLoginView implements LoginViewOperations {

	private LoginController controller;
	private ArtCreator art;
	private Scanner scan;
	private String user;
	private String pass;
	private String err;
	private String strOption;

	public ConsoleLoginView() {
		err="";
		art = new ArtCreator();
		scan = new Scanner(System.in);
	}

	@Override
	public void startView() {
		// TODO Auto-generated method stub
		art.ShowArt("LOGIN");
		System.out.println("\n");
		showMenu();
		
	}

	private void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("Ingrese su nombre de usuario");
		user = scan.nextLine();
		System.out.println("Ingrese su contraseña");
		pass = scan.nextLine();
		controller.checkCredentials(user, pass);
		
		if (this.err.equals("login incorrecto")) {
			System.out.println("desea continuar intentado?ingrese si/no");
			strOption = scan.nextLine();
			if (strOption.equals("no")) {
				close();
			} else {
				showMenu();
			}
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
	System.out.println("Login cerrado");
	
	}

	@Override
	public void showError(String err) {
		// TODO Auto-generated method stub
		this.err=err;
		System.out.println(this.err);
	}

	@Override
	public void setController(LoginController controller) {
		// TODO Auto-generated method stub
		this.controller = controller;
	}

}
