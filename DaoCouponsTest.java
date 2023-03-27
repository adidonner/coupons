package app.core.tests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import app.core.beans.Category;
import app.core.beans.Coupon;
import app.core.connection.ConnectionPool;
import app.core.data.dao.CouponDao;
import app.core.data.dao.CouponDaoDbPreparedStatements;

public class DaoCouponsTest {

	public static void main(String[] args) {
		
		ConnectionPool.getInstance().init();
		try {
			CouponDao dao = new CouponDaoDbPreparedStatements();
//			List<Coupon> coupons = new ArrayList<>();
//			coupons.add(new Coupon(0,1, Category.FOOD, "Sourdough bread",
//					"10% discount", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31),
//					7,10.5, "hkjhgh/SourdoughBread.ppp"));
//			coupons.add(new Coupon(0,1, Category.FOOD, "White bread",
//					"10% discount", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31),
//					10, 7, "hkjhgh/WhiteBread.ppp"));
//			coupons.add(new Coupon(0, 2, Category.CLOTHINGS, "Jeans","buy 2 get 1 free", 
//					LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31) ,
//					3, 120, "hkjhgh/cooljeans.ppp"));
//			coupons.add(new Coupon(0, 3, Category.VACATIONS, "Paris in Autemn","romantic and great offer ", 
//					LocalDate.of(2022, 9, 1), LocalDate.of(2022, 12, 4) ,
//					9, 750, "hkjhgh/autemnParis.ppp"));
//			coupons.add(new Coupon(0, 4, Category.RESTAURANTS, "Humus Taltul","very tasty arab majadra ", 
//					LocalDate.of(2022, 9, 1), LocalDate.of(2028, 1, 1) ,
//					100, 12.7, "hkjhgh/humusTov.ppp"));
//			coupons.add(new Coupon(0, 5, Category.ELECTRICITY, "Hot Winter Sale","An economical electric stoves sale", 
//					LocalDate.of(2022, 9, 1), LocalDate.of(2023, 4, 1) ,
//					42, 450, "hkjhgh/electricStove.ppp"));
//			
//			Iterator<Coupon> it = coupons.iterator(); 
//			while(it.hasNext()) {
//				dao.create(it.next());							
//			}
			System.out.println(dao.readAll());
//			System.out.println();
//			System.out.println(dao.read(3));
//			Coupon coupon = dao.read(97);
			dao.delete(96);
//			coupon.setPrice(690);
//			coupon.setAmount(coupon.getAmount()-1);
//			dao.update(coupon);
//			System.out.println(dao.read(3));
//			dao.delete(2);
//			System.out.println(dao.readAll());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionPool.getInstance().closeAllConnections();
		}
	}

}
