package Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;



public class titleDao {

	public List<Object> titleDao(String title) throws SQLException {
		// TODO Auto-generated method stub
		 QueryRunner runner = new QueryRunner(Utils.DataSourceUtil.getDataSource());
		    //查询语句，limit是限制显示的条数0到8
		    String sql = "select * from news where title like ? limit 0,4";
		    //List<Product> productList = runner.query(sql, new BeanListHandler<Product>(Product.class), "%"+word+"%");
		    List<Object> query = runner.query(sql, new ColumnListHandler("title"), "%"+title+"%");
		    return query;
		
	}

}
