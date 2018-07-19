package user.service;

import java.util.List;

import user.dao.UserDao;

public class PcMemberService {
	private UserDao userDao = new UserDao();
	
	

	public List<Object> PcMemberfindall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return userDao.PcMemberfindall();
	}
}
