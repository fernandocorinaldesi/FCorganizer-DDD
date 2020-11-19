package ar.com.unpaz.organizerddd.presentation.mainview;

import static java.awt.BorderLayout.NORTH;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ar.com.unpaz.organizerddd.presentation.controllers.IController;
import ar.com.unpaz.organizerddd.presentation.custom.MyTitleBar;
import ar.com.unpaz.organizerddd.presentation.custom.SideButton;

public abstract class AbstractMainView<E> extends JFrame implements MainViewOperations<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyTitleBar titleView;
	public SideButton aboutButton;
	public SideButton exitButton;
	public SideButton logOutButton;
	public JPanel cardPanel;
	public CardLayout cardLayout;
	private final static int HEIGHT =700;
	private final static int WIDTH =1150;
	
	public AbstractMainView(){
		setSize(WIDTH,HEIGHT);
		titleView = new MyTitleBar(this,"admin");
		getContentPane().add(titleView, NORTH);
		getContentPane().add(createSidePanel(), BorderLayout.WEST);
		getContentPane().add(createCenter(), BorderLayout.CENTER);
		getRootPane().setBorder(BorderFactory.createLineBorder(new Color(51,103,214)));
		initListener();
		loadSystemTrayFuncion();
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
			
	}
	

	abstract public  void initListener(); 
	
	abstract public   JPanel createCenter(); 

	abstract public  JPanel createSidePanel() ;
	
	public void loadSystemTrayFuncion(){
		SystemTray tray=SystemTray.getSystemTray();
		ActionListener exitListener=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Saliendo....");
                System.exit(0);
            }
        };
        
     	PopupMenu popup=new PopupMenu();
        MenuItem open=new MenuItem("Abrir");
        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(true);
                setExtendedState(JFrame.NORMAL);
            }
        });
        popup.add(open);
        MenuItem exit=new MenuItem("Salir");
        exit.addActionListener(exitListener);
        popup.add(exit);
        TrayIcon trayIcon=new TrayIcon(loadIconImage(), "Fc Organicer",popup);
        trayIcon.setImageAutoSize(true);
		this.addWindowStateListener(new WindowStateListener() {

		    @Override
		    public void windowStateChanged(WindowEvent e) {
		        if (e.getNewState() == ICONIFIED) {
		            try {
		                tray.add(trayIcon);
		                setVisible(false);
		            } catch (AWTException ex) {
		            }
		        }
		        if(e.getNewState()==MAXIMIZED_BOTH){
                    tray.remove(trayIcon);
                    setVisible(true);
                   // System.out.println("Tray icon removed");
                }
                if(e.getNewState()==NORMAL){
                    tray.remove(trayIcon);
                    setVisible(true);
                    //System.out.println("Tray icon removed");
                }
            }
        });
		
	}
	public void showInMemWarning() {
		 JOptionPane.showMessageDialog(this, "Esta aplicacion se esta ejecutando en modo en memoria. Este modo esta pensando para realizar test, por lo tanto los cambios no seran guardados", "Cuidado",
			        JOptionPane.WARNING_MESSAGE);
			  
	}
	private BufferedImage loadIconImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResource("/images/minicon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return image;
	}
	
	@Override
	public void setVisible() {
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		 loadPanelData();
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		updatePanelData();
	}
	@Override
	public void setController(IController<E> controller) {
		// TODO Auto-generated method stub
		//this.passpanel.setController(pass);
		setPanelController(controller);
	}
	
	public abstract void setPanelController(IController<E> controller);
	public abstract void loadPanelData();
	public abstract void updatePanelData();
	

}
