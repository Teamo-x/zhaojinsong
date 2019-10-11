package Dao;

import java.sql.SQLException;

import javax.sql.DataSource;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import Entity.Admin;
import Utils.DataSourceUtil;

public class loginDao {

	public Admin login(String name) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DataSourceUtil.getDataSource());
		String sql="select * from admin where adminname=?";
		Admin a = qr.query(sql,new BeanHandler<Admin>(Admin.class),name);
		 return a;
		
		
	}

}
