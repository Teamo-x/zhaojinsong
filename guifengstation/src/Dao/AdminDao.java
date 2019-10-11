package Dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import Utils.DataSourceUtil;

import Entity.Admin;

public class AdminDao {
	public Long checkUsername(String adminName) throws SQLException {
		
		QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select count(*) from admin where adminname=?";
		Long query = (Long) runner.query(sql, new ScalarHandler(), adminName);
		return query;
		
	
	}
/**
 * 注册
 * @param user
 * @return
 * @throws SQLException
 */
	public int regist(Admin admin) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "insert into admin(adminname,adminpassword,phonenumber) values(?,?,?)";
		int update = runner.update(sql,admin.getAdminName(),admin.getAdminPassword(),admin.getPhoneNumber() );
		return update;
	}
}
