package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import pojo.Purchase;
import pojo.Stock;

public class StockDao extends BaseDAO{

	public List<Stock> selectAll(){
		String sql="select * from tb_stock";
		return super.selectAll(sql, new Object[] {});
	}
	
//	添加记录
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
//	根据条形码查找记录
	public Stock getStock(String bar_code) {
		String sql="select * from tb_stock where bar_code=?";
		return super.select(sql, new Object[] {bar_code});
	}
	
//	根据条形码修改数量
	public int updateQualityByBar_code(String bar_code,int num) {
		String sql="update tb_stock set stock_num=? where bar_code=?";
		return super.update(sql, new Object[] {num,bar_code});
	}
//	根据名字查询
	public List<Stock> selectByName(String name){
		String sql="SELECT * from tb_stock\r\n"
				+ "WHERE name LIKE ? ";
		return super.selectAll(sql, new Object[] {name+"%"});
	}
	
// 根据条形码查询
	public List<Stock> selectByBarcode(String bar_code){
		String sql="SELECT * from tb_stock\r\n"
				+ "WHERE bar_code LIKE ? ";
		return super.selectAll(sql, new Object[] {bar_code});
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
