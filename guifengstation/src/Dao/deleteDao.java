package Dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import Utils.DataSourceUtil;

public class deleteDao{

	public int delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DataSourceUtil.getDataSource());
	String sql="delete from news where nid=?";
	          int q=qr.update(sql,id);
	          return q;
	}
 
}
