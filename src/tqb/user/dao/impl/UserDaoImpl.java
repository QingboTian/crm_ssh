package tqb.user.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import tqb.user.dao.UserDao;
import tqb.user.entity.User;

public class UserDaoImpl implements UserDao {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("all")
	@Override
	public User login(User userform) {
		List<User> list = (List<User>) hibernateTemplate.find("from User where username=? and password=?", 
				userform.getUsername(), userform.getPassword());
		if (list != null && list.size() != 0){
			return list.get(0);
		}else{
			return null;	
		}
	}

	@SuppressWarnings("all")
	@Override
	public List<User> findAll() {
		return (List<User>) hibernateTemplate.find("from User");
	}
}
