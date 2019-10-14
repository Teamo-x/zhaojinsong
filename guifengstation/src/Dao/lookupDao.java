package Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import Entity.News;
import Utils.DataSourceUtil;

public class lookupDao {

	public List<News> lookup(String lookup) throws SQLException {
		// TODO Auto-generated method stub
		       QueryRunner qr=new QueryRunner(DataSourceUtil.getDataSource());
		String sql="select * from news where title=?";
		     List<News> n = qr.query(sql, new BeanListHandler<News>(News.class),lookup);
		return n;
	}

}
