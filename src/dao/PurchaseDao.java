package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import pojo.Purchase;
import pojo.Sell;

public class PurchaseDao extends BaseDAO{
//	����ȫ��
	public List<Sell> selectAll(){
		String sql="select * from tb_purchase where del!=0";
		return super.selectAll(sql, new Object[] {});
	}
//	����
	public int insertPur(Purchase purchase) {
		String sql="insert into tb_purchase values(?,?,?,?,?,?)";
		int res=super.update(sql, new Object[] {
			0,
			purchase.getBar_code(),
			purchase.getPrice(),
			purchase.getQuality(),
			purchase.getTime(),
			1
		});
		return res;
	}
	
//	ɾ
	public int del(int id) {
		String sql="update tb_purchase set del=0 where id=?";
		int res=super.update(sql, new Object[] {id});
		return res;
	}
	
//	�顾�򵥲�ѯ��
	public List<Purchase> selectByBarCdoe(String bar_code){
		String sql="select * from tb_purchase where del!=0 and bar_code=?";
		return super.selectAll(sql, new Object[] {bar_code});
	}
	

	public List<Purchase> selectByBarCodeAndPrice(String bar_code,double price){
		String sql="select * from tb_purchase where del!=0 and bar_code=? and purchase_price=?";
		return super.selectAll(sql, new Object[] {bar_code,price});
	}
	

	public List<Purchase> selectByBarCdoes(String bar_code){
		String sql="SELECT * from tb_purchase\r\n"
				+ "WHERE bar_code LIKE ? and del!=0";
		return super.selectAll(sql, new Object[] {bar_code+"%"});
	}
	

	public int update(Purchase purchase) {
		String sql="update tb_purchase set bar_code=?,purchase_price=?,quality=?,time=?"
				+ "where id=?";
		int res=super.update(sql, new Object[] {
				purchase.getBar_code(),
				purchase.getPrice(),
				purchase.getQuality(),
				purchase.getTime(),
				purchase.getId()
		});
		return res;
	}
	

	
	@Override
	public Purchase rowMapper(ResultSet rs) {
		// TODO Auto-generated method stub
		Purchase purchase=new Purchase();
		try {
			purchase.setBar_code(rs.getString(2));
			purchase.setPrice(rs.getDouble(3));
			purchase.setQuality(rs.getInt(4));
			purchase.setTime(rs.getDate(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return purchase;
	}

}
