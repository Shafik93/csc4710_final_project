package user.service;

import java.util.List;

import user.dao.UserDao;

public class WritePaperService {
private UserDao userDao = new UserDao();
	
	

	public List<Object> WritePaperfindall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return userDao.WritePaperfindall();
	}
}
