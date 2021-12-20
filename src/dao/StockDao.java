package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import pojo.Stock;

public class StockDao extends BaseDAO{

	public List<Stock> selectAll(){
		String sql="select * from tb_stock";
		return super.selectAll(sql, new Object[] {});
	}
	

	public int insertStock(Stock stock) {
		String sql="insert into tb_stock values(?,?,?,?,?,?)";
		return super.update(sql, new Object[] {
				stock.getBar_code(),
				stock.getName(),
				stock.getStock_num(),
				stock.getManufac(),
				stock.getSpecifications(),
				stock.getRetail_price()
		});
	}

	@Override
	public Stock rowMapper(ResultSet rs) {
		// TODO Auto-generated method stub
		Stock stock=new Stock();
		try {
			stock.setBar_code(rs.getString(1));
			stock.setName(rs.getString(2));
			stock.setStock_num(rs.getInt(3));
			stock.setManufac(rs.getString(4));
			stock.setSpecifications(rs.getString(5));
			stock.setRetail_price(rs.getDouble(6));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stock;
	}
	
}
