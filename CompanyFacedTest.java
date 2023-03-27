package app.core.tests;

import java.time.LocalDate;

import app.core.beans.Category;
import app.core.beans.Coupon;
import app.core.connection.ConnectionPool;
import app.core.facade.CompanyFacade;

public class CompanyFacedTest {

	public static void main(String[] args) {

		ConnectionPool.getInstance().init();
		try {
			CompanyFacade companyFacade = new CompanyFacade();
			companyFacade.login("jumuslevi@mail", "baby");
			System.out.println(companyFacade.getAllCompanyCoupons());
//			companyFacade.addCoupon(new Coupon(0, 5, Category.RESTAURANTS, "Humus Taltul1", "very tasty arab majadra", LocalDate.of(2022, 9, 01),LocalDate.of(2026, 12, 11), 100, 12.7, "hkjhgh/humusTov.ppp"));
//			companyFacade.addCoupon(new Coupon(0, 5, Category.RESTAURANTS, "Humus Taltul2", "very tasty arab majadra", LocalDate.of(2022, 9, 01),LocalDate.of(2026, 12, 11), 100, 8, "hkjhgh/humusTov.ppp"));
//			companyFacade.addCoupon(new Coupon(0, 5, Category.RESTAURANTS, "Humus Taltul3", "very tasty arab majadra", LocalDate.of(2022, 9, 01),LocalDate.of(2026, 12, 11), 100, 50, "hkjhgh/humusTov.ppp"));
			companyFacade.updateCompanyCoupon(new Coupon(11, 5, Category.RESTAURANTS, "Humus Taltul3", "very tasty arab majadra", LocalDate.of(2022, 9, 01),LocalDate.of(2026, 12, 11), 100, 46, "hkjhgh/humusTov.ppp"));

			
			
//			System.out.println(companyFacade.getAllMaxCompanyCoupons(50));
//			companyFacade.addCoupon(new Coupon(0, CompanyFacade.getId(), Category.VACATIONS, "Cold Russia", "real winter" , LocalDate.of(2022, 9, 1), LocalDate.of(2023, 4, 1) ,
//					42, 450, "hkjhgh/mamaRussia.ppp"));
			
//			companyFacade.deleteCompanyCoupon(7);
//			System.out.println(companyFacade.getCompanyCoupon(3));
//			System.out.println(companyFacade.getCompanyCoupon(2));
//			System.out.println(companyFacade.getAllCompanyCoupons(Category.FOOD));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeAllConnections();
		}
	}

}
