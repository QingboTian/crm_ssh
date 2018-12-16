package tqb.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import tqb.user.dao.UserDao;
import tqb.user.entity.User;

@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User login(User userform) {
		return userDao.login(userform);
	}

	public List<User> list() {
		return userDao.findAll();
	}
	
	
}
