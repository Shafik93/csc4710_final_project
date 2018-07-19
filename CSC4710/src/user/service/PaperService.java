package user.service;

import java.util.List;

import user.dao.UserDao;

public class PaperService {
	private UserDao userDao = new UserDao();
	
	

	public List<Object> Paperfindall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return userDao.Paperfindall();
	}
}
