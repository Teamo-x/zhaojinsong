package Service;

import java.sql.SQLException;

import Dao.AdminDao;
import Entity.Admin;

public class AdminService {


		public boolean checkUsername(String adminName){
		AdminDao dao = new AdminDao();
			Long isExist = 0L;
			
				try {
					isExist = dao.checkUsername(adminName);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return isExist>0?true:false;
			
		}
	/**
	 * 注册
	 * @param user
	 * @return
	 */
		public boolean regist(Admin admin) {
			AdminDao dao = new AdminDao();
			int row = 0;
			try {
				row = dao.regist(admin);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return row>0?true:false;
		}

	

	}
