package Dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import Utils.DataSourceUtil;
import Entity.News;

public class addNewsDao {

	public int add(News n) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner  qr=new QueryRunner(DataSourceUtil.getDataSource());
		String sql="insert into news(title,author,time,content,img) values(?,?,?,?,?)";
		       int re = qr.update(sql,n.getTitle(),n.getAuthor(),n.getTime(),n.getContent(),n.getImg());
		return re;
		
	}

}
