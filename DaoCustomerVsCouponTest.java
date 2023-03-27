package app.core.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import app.core.beans.CustomerVsCoupon;
import app.core.connection.ConnectionPool;
import app.core.data.dao.CustomerVsCouponDao;
import app.core.data.dao.CustomerVsCouponDaoDbPreparedStatements;

public class DaoCustomerVsCouponTest {

	public static void main(String[] args) {

		ConnectionPool.getInstance().init(); // starts the connection pool
		try {
			
			CustomerVsCouponDao dao = new CustomerVsCouponDaoDbPreparedStatements();
			
			List<CustomerVsCoupon> customerVsCoupons = new ArrayList<>();
			
//			customerVsCoupons.add(new CustomerVsCoupon(1,1));
//			customerVsCoupons.add(new CustomerVsCoupon(1,3));
//			customerVsCoupons.add(new CustomerVsCoupon(2,4));
//			customerVsCoupons.add(new CustomerVsCoupon(3,5));
//			customerVsCoupons.add(new CustomerVsCoupon(4,3));
//			customerVsCoupons.add(new CustomerVsCoupon(5,3));
			customerVsCoupons.add(new CustomerVsCoupon(5,78));
			
			Iterator<CustomerVsCoupon> it = customerVsCoupons.iterator();
			while(it.hasNext()) {
				CustomerVsCoupon curr = it.next();
				dao.create(curr);							
			}
//			System.out.println(dao.read(1));
			System.out.println(dao.readAll());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeAllConnections();
		}

	}

}
