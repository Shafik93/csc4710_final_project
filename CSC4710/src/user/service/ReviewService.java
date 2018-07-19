package user.service;

import java.util.List;

import user.dao.UserDao;

public class ReviewService {
	private UserDao userDao = new UserDao();
	
	

	public List<Object> Reviewfindall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return userDao.Reviewfindall();
	}
}
