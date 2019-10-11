package Service;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Dao.addNewsDao;
import Entity.News;

public class addNewsService {

	public int add(News n) throws SQLException {
		// TODO Auto-generated method stub
	  
		 addNewsDao an=new  addNewsDao();
		          int re = an.add(n);
		
		return re;
	}

}
