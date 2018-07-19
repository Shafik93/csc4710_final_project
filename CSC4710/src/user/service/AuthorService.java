package user.service;

import java.util.List;

import user.dao.UserDao;
import user.domain.Author;

public class AuthorService {
	private UserDao userDao = new UserDao();
	
	

	public List<Object> Authorfindall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return userDao.Authorfindall();
	}






}
