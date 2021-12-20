package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import pojo.User;

public class UserDao extends BaseDAO{

	public List<User> selectAll() {
		String sqlString="select * from tb_user";
		return super.selectAll(sqlString, new Object[] {});
	}
	
	public User selectUserByName(String name) {
		String sqlString="select * from tb_user where user=?";
		return super.select(sqlString, new Object[] {name});
	}

	@Override
	public User rowMapper(ResultSet rs) {
		// TODO Auto-generated method stub
		User user=new User();
		try {
			user.setName(rs.getString("user"));
			user.setPassword(rs.getString("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return user;
	}

}
