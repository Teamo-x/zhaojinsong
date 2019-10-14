package Service;

import java.sql.SQLException;
import java.util.List;

import Dao.lookupDao;
import Entity.News;

public class lookupService {

	public List<News> lookup(String lookup) throws SQLException {
		// TODO Auto-generated method stub
		
		lookupDao ld=new lookupDao();
		List<News> n = ld.lookup(lookup);
		return n;
		 
	}

}
