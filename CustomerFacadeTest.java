package app.core.tests;

import java.time.LocalDate;

import app.core.beans.Coupon;
import app.core.connection.ConnectionPool;
import app.core.facade.CustomerFacade;

public class CustomerFacadeTest {

	public static void main(String[] args) {
		ConnectionPool.getInstance().init();
		try {
			CustomerFacade customerFacade = new CustomerFacade();
			customerFacade.login("shabazi@gmail.com", "shab");
//			System.out.println(customerFacade.getAllMaxCustomerCoupons(50));
			
			customerFacade.purchaseCoupon(new Coupon(78));
//			System.out.println(customerFacade.getOneCustomerCoupon(1).getEndDate());
//			System.out.println(LocalDate.now());
//			System.out.println(customerFacade.getOneCustomerCoupon(1).getEndDate().compareTo(LocalDate.now()));
//			System.out.println(LocalDate.now().compareTo(LocalDate.now()));
			
//			customerFacade.purchaseCoupon(new Coupon(2));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeAllConnections();
		}
	}

}
