package app.core.tests;

import app.core.beans.Company;

import app.core.connection.ConnectionPool;
import app.core.data.dao.CompanyDao;
import app.core.data.dao.CompanyDaoDbPreparedStatements;
import app.core.exceptions.CompaniesException;

public class DaoCompaniesTest {

	public static void main(String[] args) {

		ConnectionPool.getInstance().init(); // starts the connection pool
		try {
			CompanyDao dao = new CompanyDaoDbPreparedStatements();

			Company[] companies = new Company[7];
			
			companies[0] = new Company(1, "Osem", "osem@mail", "osem");
			companies[1] = new Company(2, "Teva", "teva@mail", "teva");
			companies[2] = new Company(3, "Gali", "gali@mail", "gali");
			companies[3] = new Company(4, "Fox", "fox@mail", "fox1");
			companies[4] = new Company(5, "JumusLevi", "jumuslevi@mail", "jumu");
			companies[5] = new Company(6, "Tornado", "tornado@mail", "torn");
			companies[6] = new Company(7, "AirEuropa", "aireuropa@mail", "aire");
			
			for (int i = 0; i < companies.length; i++) {
				dao.create(companies[i]);				
			}
			System.out.println(dao.readAll());
			System.out.println();
			System.out.println(dao.read(3));
			System.out.println();
			companies[4].setPassword("baby");
			dao.update(companies[4]);
//			System.out.println();
//			dao.delete(5);
//			System.out.println(dao.readAll());
			
		} catch (CompaniesException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeAllConnections();
		}

	}

}
