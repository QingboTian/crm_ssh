package tqb.user.dao;

import java.util.List;

import tqb.user.entity.User;

public interface UserDao {

	User login(User userform);

	List<User> findAll();

}
