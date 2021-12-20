package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.*;

public abstract class BaseDAO {
	// 共通的增删改方法
		public int update(String sql,Object[] arr) {
			Connection conn = ConnDB.getConnection();
			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);
				//对占位符赋值
				for (int i = 0; i < arr.length; i++) {
					pst.setObject(i+1, arr[i]);
				}
				int row = pst.executeUpdate();
				return row;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				ConnDB.closeDB(null, pst, conn);
			}
			return 0;
		}
		// 共通查询
		public <T>T select(String sql,Object[] arr){
			Connection conn = ConnDB.getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null;
			T t = null;
			try {
				pst= conn.prepareStatement(sql);
				for (int i = 0; i < arr.length; i++) {
					pst.setObject(i+1, arr[i]);
				}
				rs = pst.executeQuery();
				// 对结果集的收集
				if(rs.next()) {
					// 收集对象的属性
					t = this.rowMapper(rs);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				ConnDB.closeDB(null, pst, conn);
			}
			return t;
		}
		// 查询结果集合
		public <T> List<T> selectAll(String sql,Object[] arr){
			List<T> list = new ArrayList<>();
			Connection conn = ConnDB.getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null;
			
			try {
				pst= conn.prepareStatement(sql);
				for (int i = 0; i < arr.length; i++) {
					pst.setObject(i+1, arr[i]);
				}
				rs = pst.executeQuery();
				T t = null;
				// 对结果集的收集
				while(rs.next()) {
					// 收集对象的属性
					t = this.rowMapper(rs);
					// 添加到集合
					list.add(t);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				ConnDB.closeDB(null, pst, conn);
			}
			return list;
		}
		// 定义方法  每个查询的结果集获取对应的属性
		public  abstract <T> T rowMapper(ResultSet rs) ;
}
