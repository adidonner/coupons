package app.core.tests;

import java.util.Random;


import app.core.beans.Customer;
import app.core.connection.ConnectionPool;
import app.core.data.dao.CustomerDao;
import app.core.data.dao.CustomerDaoDbPreparedStatements;

public class DaoCustomersTest {

	public static void main(String[] args) {

		ConnectionPool.getInstance().init(); // starts the connection pool
		try {
			Random random = new Random();
			String[] firstNames = { "Dan", "Ran", "Dina", "Dor", "Yanki", "Roz", "Soli", "Ari", "Richard" };
			String[] lastNames = { "Cohen", "Levi", "Badash", "Havatzelet", "Gonzales", "Avrahamov", "Kagan", "Halevi",
					"Mustaki" };
			CustomerDao dao = new CustomerDaoDbPreparedStatements();
			Customer customers = new Customer();

			for (int i = 0; i < 5; i++) {
				String firstName = firstNames[random.nextInt(firstNames.length)];
				String lastName = lastNames[random.nextInt(lastNames.length)];
				customers.setId(i);
				customers.setFirstName(firstName);
				customers.setLastName(lastName);
				customers.setEmail(firstName.toLowerCase() + "@gmail.com");
				int password = (int) (Math.random() * 9000) + 1000;
				String str = String.valueOf(password);
				customers.setPassword(str);
				dao.create(customers);
			}
			
			System.out.println(dao.readAll());// check list	
			
			System.out.println();
			System.out.println(dao.read(3));// check customer 3 details
			
			customers = dao.read(3);
			customers.setPassword("1111");// change password to custoemer 3			
			dao.update(customers);
			System.out.println(dao.read(3));//password updated 

//			System.out.println();
//			dao.delete(4);
//			System.out.println(dao.readAll());

			System.out.println(customers);
			customers = new Customer(3, "Shir", "Shabazi", "shabazi@gmail.com", "shab");
			System.out.println(customers);
			dao.update(customers);
			
			//check if new customer's name equal
			Customer customers1 = new Customer(3, "Shir", "Levi", "fgdh@sf", "1234");
			System.out.println(customers1);
			System.out.println(customers.getFirstName().equals(customers1.getFirstName()));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeAllConnections();
		}

	}

}
