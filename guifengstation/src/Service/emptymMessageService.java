package Service;

import java.sql.SQLException;

import Dao.emptymMessageDao;

public class emptymMessageService {
	

	public int empty() throws SQLException {
		// TODO Auto-generated method stub
		emptymMessageDao ed=new emptymMessageDao();
		      int u = ed.empty();
		    return u;  
	}
}
