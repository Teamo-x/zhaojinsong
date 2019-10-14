package Service;

import java.sql.SQLException;
import java.util.List;

import Dao.viewMessagesDao;
import Entity.Contact;

public class viewMessagesService {

	public List<Contact> viewMessages() throws SQLException {
		// TODO Auto-generated method stub
		viewMessagesDao vd=new viewMessagesDao();
		 List<Contact> q = vd.viewMessages();
		return q;
	}

}
