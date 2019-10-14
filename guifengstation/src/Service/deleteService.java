package Service;

import java.sql.SQLException;

import Dao.deleteDao;

public class deleteService {

	public int delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		deleteDao dd=new deleteDao();
		   int q = dd.delete(id);
		return q;
		
	}

}
