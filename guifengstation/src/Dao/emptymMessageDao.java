package Dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import Utils.DataSourceUtil;

public class emptymMessageDao {

	public int empty() throws SQLException {
		// TODO Auto-generated method stub
		       QueryRunner qr=new QueryRunner(DataSourceUtil.getDataSource());
		       String sql=" truncate  table contact";
		             int u = qr.update(sql);
		       return u;
	}

}
