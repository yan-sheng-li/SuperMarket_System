package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import pojo.Sell;

public class SellDao extends BaseDAO{

//	查找全部
	public List<Sell> selectAll(){
		String sql="select * from tb_sell where del!=0";
		return super.selectAll(sql, new Object[] {});
	}
//	增
	public int insertSell(Sell sell) {
		String sql="INSERT into tb_sell\r\n"
				+ "VALUES(?,?,?,?,?,?)";
		int res=super.update(sql, new Object[] {
				0,
				sell.getBar_code(),
				sell.getNum(),
				sell.getSell_price(),
				sell.getTime(),
				1
		});
		return res;
	}
//	删
	public int delete(int id) {
		String sql="update tb_sell set del=0 where id=? ";
		return super.update(sql, new Object[] {id});
	}
//	改
	public int update(Sell sell) {
		String sql="update tb_sell set bar_code=?,num=?,sell_price=?,time=? where id=?";
		return super.update(sql, new Object[] {
				sell.getBar_code(),
				sell.getNum(),
				sell.getSell_price(),
				sell.getTime(),
				sell.getId()
		});
	}
	
//	查
	public List<Sell> selectByBarCdoe(String bar_code){
		String sql="select * from tb_sell where del!=0 and bar_code=?";
		return super.selectAll(sql, new Object[] {bar_code});
	}
	
	
	
	
	@Override
	public Sell rowMapper(ResultSet rs) {
		// TODO Auto-generated method stub
		Sell sell=new Sell();
		try {
			sell.setId(rs.getInt(1));
			sell.setBar_code(rs.getString(2));
			sell.setNum(rs.getInt(3));
			sell.setSell_price(rs.getDouble(4));
			sell.setTime(rs.getDate(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sell;
	}
	
}
