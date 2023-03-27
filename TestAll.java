package app.core.tests;

import java.time.LocalDate;
import java.util.Locale.Category;

import javax.security.auth.login.LoginException;

import app.core.beans.Company;
import app.core.beans.Coupon;
import app.core.beans.Customer;
import app.core.connection.ConnectionPool;
import app.core.facade.AdminFacade;
import app.core.facade.CompanyFacade;
import app.core.facade.CustomerFacade;
import app.core.job.CouponExpirationDailyJob;

public class TestAll {

	public static void main(String[] args) throws Exception {

		System.out.println("starting connection pool");
		ConnectionPool.getInstance().init();
		CouponExpirationDailyJob jobRunable = new CouponExpirationDailyJob();
		Thread jobThread = new Thread(jobRunable);
		System.out.println("starting job");
		jobThread.start();
		
//		try {
//		System.out.println("============================");
//		System.out.println();
//		AdminFacade adminFacade = new AdminFacade();
//		adminFacade.login("email@admin.com", "admin");

//		System.out.println(adminFacade.getAllCompanies());
//		System.out.println();
//		System.out.println(adminFacade.getOneCompany(1));
//		System.out.println();
//		System.out.println(adminFacade.getAllCompanies());
//		System.out.println(adminFacade.getAllCustomers());
		

//		System.out.println();
//		adminFacade.addCompany(new Company(0, "Aminaj", "aminaj@mail", "amin"));
//		adminFacade.addCustomer(new Customer(0, "Moshe", "Mustaki", "mustak@mail", "musk"));
//
//		adminFacade.updateCompany(new Company(4, "Fox" , "fox@gmail.com", "fox3"));
//		adminFacade.updateCustomer(new Customer(3, "Shir", "Shabazi Levi", "shabazi@gmail.com", "shab"));
	
//		adminFacade.deleteCompany(34);
//		adminFacade.deleteCustomer(16);
//		} catch (Exception e) {
//			throw new Exception("Admin Facade exception");
//		}
		
//		try {
//		System.out.println("============================");
//		System.out.println();
//		CompanyFacade companyFacade = new CompanyFacade();
//		companyFacade.login("aireuropa@mail", "aire");
//		System.out.println(companyFacade.getCompanyDetails());
//		System.out.println(companyFacade.getAllCompanyCoupons());
//		System.out.println(companyFacade.getCompanyCoupon(102));
//		companyFacade.addCoupon(new Coupon(0, 7, app.core.beans.Category.CLOTHINGS, "Air Europa Shirt",
//				"free", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31),
//				10,20, "hkjhgh/AirEuropaShirt.ppp"));
//		System.out.println();
//		System.out.println(companyFacade.getAllCategoryCompanyCoupons(app.core.beans.Category.CLOTHINGS));
//		System.out.println();	
//		System.out.println(companyFacade.getAllMaxCompanyCoupons(100));
//		System.out.println();	
//		Coupon coupon = companyFacade.getCompanyCoupon(102);
//		coupon.setImage("c/image/beutifulNature");
//		companyFacade.updateCompanyCoupon(coupon);
		
//		companyFacade.deleteCompanyCoupon(104);
//		} catch (Exception e) {
//			throw new Exception("Company Facade exception");
//		}
		
		
//		System.out.println();
//		System.out.println("============================");
//		CustomerFacade customerFacade = new CustomerFacade();
//		customerFacade.login("shabazi@gmail.com", "shab");
//		System.out.println(customerFacade.getCustomerDetails());
//		System.out.println(customerFacade.getAllCustomerCoupons());
//		System.out.println(customerFacade.getOneCustomerCoupon(5));
//		System.out.println(customerFacade.getCategoryCustomerCoupons(app.core.beans.Category.ELECTRICITY));
//		System.out.println(customerFacade.getAllMaxCustomerCoupons(20));
//		customerFacade.purchaseCoupon(new Coupon(100));
//		customerFacade.sellCoupon(99);
			
		System.out.println();
		System.out.println("============================");
		System.out.println("stoping job");
		jobRunable.stop();
		try {
			jobThread.join();
		} catch (InterruptedException e) {
			throw new LoginException("Thread join exception");
		}
		
		System.out.println("closing connection pool");
		ConnectionPool.getInstance().closeAllConnections();
		
	}

}
