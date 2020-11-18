package ar.com.unpaz.organizerddd;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import ar.com.unpaz.organizerddd.application.services.AppServicePass;
import ar.com.unpaz.organizerddd.application.services.AppServiceUser;
import ar.com.unpaz.organizerddd.application.services.AppServices;
import ar.com.unpaz.organizerddd.domain.entitys.Password;
import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.domain.repositorycontracts.IRepository;
import ar.com.unpaz.organizerddd.domain.services.DomainPasswordServices;
import ar.com.unpaz.organizerddd.domain.services.DomainUserService;
import ar.com.unpaz.organizerddd.domain.services.IDomainServices;
import ar.com.unpaz.organizerddd.infrastructure.PasswordRepositoryImp;
import ar.com.unpaz.organizerddd.infrastructure.UserRepositoryImp;
import ar.com.unpaz.organizerddd.presentation.controllers.IController;
import ar.com.unpaz.organizerddd.presentation.controllers.Selector;
import ar.com.unpaz.organizerddd.presentation.controllers.SelectorImp;
import ar.com.unpaz.organizerddd.presentation.controllers.ViewAdminController;
import ar.com.unpaz.organizerddd.presentation.controllers.ViewPasswordController;
import ar.com.unpaz.organizerddd.presentation.loginview.LoginView;
import ar.com.unpaz.organizerddd.presentation.loginview.LoginViewOperations;
import ar.com.unpaz.organizerddd.presentation.mainview.AdminView;
import ar.com.unpaz.organizerddd.presentation.mainview.MainView;
import ar.com.unpaz.organizerddd.presentation.mainview.MainViewOperations;
import ar.com.unpaz.organizerddd.presentation.validator.IValidator;
import ar.com.unpaz.organizerddd.presentation.validator.PasswordFrontValidator;
import ar.com.unpaz.organizerddd.presentation.validator.UserFrontValidator;
import ar.com.unpaz.organizerddd.transversalinfrastructure.LoginController;
import ar.com.unpaz.organizerddd.transversalinfrastructure.LoginControllerImp;

/**
 * Hello world!
 *
 */
public class EntryPoint 
{
    public static  void main( String[] args )
    {
        /*IMPLEMENTACION SERVICE LOCATOR DINAMICO
    	    	    	
    	Iservice service=new ServiceLocator();
    	Iservice serviceTest=new ServiceLocator();
    	*////
    	
       	try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		EventQueue.invokeLater(() -> {
			
	            /////////COMPOSITE ROOT///////
			 
			    
				//PESISTENCE INFRAESTRUCTURE
				IRepository<Password> passwordrepository=new PasswordRepositoryImp();
				IRepository<User> userrepository=new UserRepositoryImp();
				
				//DOMAIN
				//Domainservices
				IDomainServices<Password> passdomainservices=new DomainPasswordServices();
				IDomainServices<User> userdomainservices=new DomainUserService();
				
				//APPLICATION
				AppServices<Password> appservicepass=new AppServicePass(passwordrepository,passdomainservices);
				AppServices<User> appserviceuser=new AppServiceUser(userrepository,userdomainservices);
		    	
				
		    	//PRESENTACION
				
				//Front validator
				IValidator<Password> passfrontValidator=new PasswordFrontValidator();
				IValidator<User> userfrontValidator=new UserFrontValidator();
				
				//main view
				MainViewOperations<Password> mainview=new MainView();
				MainViewOperations<User> adminview=new AdminView();
				
				//view controller
				IController<Password> viewpasscontroller=new ViewPasswordController(appservicepass,mainview,passfrontValidator);
				IController<User> viewadmincontroller=new ViewAdminController(appserviceuser,adminview,userfrontValidator);
				
				//selector de modulo(usuarios o admin)
				Selector selector=new SelectorImp(viewpasscontroller,
						                          viewadmincontroller);
				
				LoginViewOperations loginview=new LoginView();
				
				//TRANSVERSAL INFRAESTRUCTURE
				LoginController logincontroller=new LoginControllerImp(
						loginview,
						selector);
				
				
				logincontroller.startView();
					
		});
    	
    	
    
    	
   
    	
    	
    
    	
        
    }
}
