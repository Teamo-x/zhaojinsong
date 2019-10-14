package Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import Entity.Contact;
import Utils.DataSourceUtil;

public class viewMessagesDao {

	public List<Contact> viewMessages() throws SQLException {
		// TODO Auto-generated method stub
	          QueryRunner qr=new 	QueryRunner(DataSourceUtil.getDataSource());
	          String sql="select * from contact";
	          List<Contact> q = qr.query(sql, new BeanListHandler<Contact>(Contact.class));
		return q;
		
	}

}
