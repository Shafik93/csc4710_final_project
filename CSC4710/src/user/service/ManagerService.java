package user.service;

import user.domain.Manager;
import user.dao.UserDao;

public class ManagerService {
	private UserDao userDao = new UserDao();

	public void login(Manager form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Manager manager = userDao.findByUsername1(form.getMusername());
		if(manager.getMusername()==null) throw new UserException("The manager is not in the database");
		
		String password = manager.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			throw new UserException(" The password is not right");
		
	}
}
