package Service;

import java.sql.SQLException;

import Dao.loginDao;
import Entity.Admin;

public class loginService {

	public Admin login(String name) throws SQLException {
		// TODO Auto-generated method stub
		loginDao ld=new loginDao();
		         Admin a = ld.login(name);
		         return a; 
		
	}

}
