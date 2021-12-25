package test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mysql.cj.result.Field;

import dao.PurchaseDao;
import dao.SellDao;
import dao.StockDao;
import dao.UserDao;
import pojo.Purchase;
import pojo.Sell;
import pojo.Stock;
import pojo.User;

public class Test1 {
	public static void main(String[] args) {
		/*
		 * User user=new User(); user.setName("liming"); user.setPassword("12323");
		 * System.out.println(user);
		 */
		
		UserDao userDao=new UserDao();
		
//		System.out.println(userDao.selectAll());
//		System.out.println(userDao.selectUserByName("admin"));
		
		StockDao stockDao=new StockDao();
//		System.out.println(stockDao.selectAll());
//		System.out.println(stockDao.insertStock(new Stock("1123","鍙箰",2,"鐧句簨","灏�",6.3)));
//		System.out.println(stockDao.getStock("1123"));
//		System.out.println(stockDao.updateQualityByBar_code("1124", 10));
		System.out.println(stockDao.selectByName("1"));
		
		SellDao sellDao=new SellDao();
//		System.out.println(sellDao.selectAll());
//		System.out.println(sellDao.selectAll());
//		System.out.println(sellDao.delete(1));
//		System.out.println(sellDao.insertSell(new Sell(0,"23412",23,89,new Date())));
//		System.out.println(sellDao.update(new Sell(2,"23412",23,50,new Date())));
//		System.out.println(sellDao.selectByBarCdoe("1123"));
//		System.out.println(sellDao.selectByTime("2021-12-22"));
		
		
		
		PurchaseDao purchaseDao=new PurchaseDao();
//		System.out.println(purchaseDao.selectAll());
//		System.out.println(purchaseDao.del(1));
//		System.out.println(purchaseDao.selectByBarCodeAndPrice("1123",34));
//		System.out.println(purchaseDao.selectByBarCdoe("1123"));
//		System.out.println(purchaseDao.selectByBarCdoes("1123"));
//		System.out.println(purchaseDao.insertPur(new Purchase("234",23.32,78,new Date())));
//		List<Purchase> ps=purchaseDao.selectByTime("2021-12");
//		System.out.println(ps);
		/*
		 * // java.lang.reflect.Field[] s=Purchase.class.getDeclaredFields();
		 * System.out.println(s.length); Object[][] arr=new Object[ps.size()][s.length];
		 * int i=0; int j=0; for (Purchase purchase : ps) {
		 * System.out.println(purchase); arr[i][j]=purchase.getId();
		 * arr[i][j+1]=purchase.getBar_code(); arr[i][j+2]=purchase.getPrice();
		 * arr[i][j+3]=purchase.getQuality(); arr[i][j+4]=purchase.getTime(); i++; }
		 * 
		 * 
		 * for(Object a[]:arr) { for(Object o:a) { System.out.println(o.toString()); } }
		 */
	}
}
