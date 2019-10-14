package Service;

import java.sql.SQLException;
import java.util.List;

import Dao.titleDao;

public class titleService {

	public List<Object> findnewsBytitle(String title) throws SQLException {
		// TODO Auto-generated method stub
		
		titleDao td=new titleDao();
		   List<Object> q = td.titleDao(title);
		
		return q;
	}

	


}
