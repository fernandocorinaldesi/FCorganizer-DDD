package ar.com.unpaz.organizerddd.presentation.loginview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.com.unpaz.organizerddd.presentation.custom.MyTitleBar;
import ar.com.unpaz.organizerddd.presentation.custom.WindowsSnapper;
import ar.com.unpaz.organizerddd.transversalinfrastructure.login.LoginController;

public class LoginView extends JFrame implements LoginViewOperations{
    
	private static final long serialVersionUID = 1L;
	private JTextField userText;
	private JPasswordField  passwordText;
	private JButton loginButton;
	private JButton exitButton;
	private MyTitleBar titleView;
	
	public LoginView() {
		// TODO Auto-generated constructor stub
		init();
		titleView = new MyTitleBar(this,"login");
		getContentPane().add(titleView, BorderLayout.NORTH);
		getContentPane().add(createCenter(), BorderLayout.CENTER);
		getContentPane().add(createSouth(), BorderLayout.SOUTH);
		getRootPane().setBorder(BorderFactory.createLineBorder(new Color(0, 122, 244)));
		addComponentListener(new WindowsSnapper());
	
	}

	
	public void init() {
		
		setSize(400,450);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
	}
	private JPanel createCenter() {
		JPanel pane = new JPanel();
		
		userText = new JTextField();
		//userText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
          //userText.setContentAreaFilled(false);
        passwordText = new JPasswordField ();
		JLabel userLabel = new JLabel("Ingresar Usuario");
        userLabel.setForeground(new Color(0,128,255));
		JLabel passwordLabel = new JLabel("Ingresar Contraseña");
		passwordLabel.setForeground(new Color(0,128,255));
		
		pane.setBackground(new Color(255,255,255));
		pane.add(userLabel);
		pane.add(userText);
		pane.add(passwordLabel);
		pane.add(passwordText);
		pane.setLayout(new GridLayout(2,2,5,20));
		pane.setBorder(new EmptyBorder(50,50,10,50));
		
		return pane;

	}
	private JPanel createSouth() {
		JPanel pane = new JPanel();
		
		loginButton = new JButton("Entrar");
		loginButton.setBackground(new Color(0, 122, 244));
		loginButton.setForeground(Color.WHITE);
	    exitButton = new JButton("Salir");
		exitButton.setBackground(new Color(157, 0, 0));
		exitButton.setForeground(Color.WHITE);
		exitButton.addActionListener((event) -> {
			dispose();
		});
		
		pane.add(loginButton);
		pane.add(exitButton);
		pane.setBackground(new Color(255,255,255));
		pane.setLayout(new GridLayout(2,1,5,5));
		pane.setBorder(new EmptyBorder(10,50,50,50));
		
		return pane;
		
	}
	
	
	@Override
	public void startView() {
		// TODO Auto-generated method stub
		setVisible(true);
		
	}
	@Override
	public void close() {
		// TODO Auto-generated method stub
		dispose();
	}
	@Override
	public void setController(LoginController controller) {
		// TODO Auto-generated method stub
		loginButton.addActionListener((event) -> {

			controller.checkCredentials(userText.getText(),new String(passwordText.getPassword()));
			clean();

		});
		
	}


	@Override
	public void showError(String err) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, err);
		
	}
	private void clean() {
		userText.setText("");
		passwordText.setText("");
	}




}
