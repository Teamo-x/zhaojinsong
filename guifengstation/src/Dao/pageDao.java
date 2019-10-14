package Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import Entity.News;
import Utils.DataSourceUtil;






public class pageDao {
	public int queryTotalCount() throws SQLException {
		// TODO Auto-generated method stub
		
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql="select count(*) from news";
		Long totalCount = (Long)qr.query(sql,new ScalarHandler());
		return totalCount.intValue();
	}

	public List<News> queryPartData(int start, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql="select * from news limit ?,?";
		  List<News> list = qr.query(sql, new BeanListHandler<News>(News.class),start,pageSize);
		return list;
	}

}
