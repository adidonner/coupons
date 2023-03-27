package app.core.tests;

import app.core.beans.Company

;
import app.core.connection.ConnectionPool;
import app.core.facade.AdminFacade;

public class AdminFacadeTest {

	public static void main(String[] args) {

		ConnectionPool.getInstance().init();
		try {
			AdminFacade adminFacade = new AdminFacade();
			adminFacade.login("email@admin.com", "admin");

//			adminFacade.updateCompany(new Company(4	,"Fox"	,"fox@mail"	,"fox2"));
			
//			AdminFacade.addCompany(new Company(0, "Rolex1", "rolex@mail", "role"));
//			AdminFacade.addCompany(new Company(0,"Elite", "elite@mail", "elit"));
			
//			System.out.println(AdminFacade.getAllCompanies());
			
			System.out.println(adminFacade.getOneCompany(2));
			adminFacade.deleteCompany(2);
//			System.out.println(AdminFacade.getOneCompany(2));

//			AdminFacade.updateCompany(new Company(3, "Teva", "teva@mail", "1111"));
			
//			AdminFacade.deleteCompany(10);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeAllConnections();
		}
	}

}
