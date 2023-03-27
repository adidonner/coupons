package app.core.tests;

import javax.security.auth.login.LoginException;

import app.core.connection.ConnectionPool;
import app.core.facade.AdminFacade;
import app.core.facade.CustomerFacade;
import app.core.login.ClientType;
import app.core.login.LoginManager;

public class LoginManagerTest {

	public static void main(String[] args) throws LoginException {

		ConnectionPool.getInstance().init();
		try {
//			LoginManager loginManager1 = LoginManager.getInstance();
//			System.out.println(loginManager1.login("email@admin.com", "admin", ClientType.ADMINISTRADOR));
//			System.out.println(AdminFacade.getOneCompany(2));
			
			
			LoginManager loginManager = LoginManager.getInstance();
			System.out.println(loginManager.login("dina@gmail.com", "1352", ClientType.CUSTOMER));	
			
			
//			System.out.println(loginManager);
//			System.out.println(loginManager1);
//			System.out.println(LoginManager.getInstance().login("gali@mail", "gali", ClientType.COMPANY));

		} finally {
			ConnectionPool.getInstance().closeAllConnections();
		}
	}

}