package service;

import java.util.List;

import com.devcortes.components.entity.User;
import com.devcortes.components.interfaces.IUserDao;
import com.devcortes.components.service.UserDao;

public class UserService {

	private IUserDao iUserDao;

	public void add(User user, UserDao userDao) {

		iUserDao = userDao;
		iUserDao.add(user);
	}

	public void addMany(List<User> users, UserDao userDao) {

		iUserDao = userDao;
		iUserDao.addMany(users);
	}
	
	public void readAll(UserDao userDao) {

		iUserDao = userDao;
		iUserDao.readAll();
	}
	
	public void deleteByLogin(String login, UserDao userDao) {

		iUserDao = userDao;
		iUserDao.deleteByLogin(login);
	}
	
	public void clearCollection(UserDao userDao) {

		iUserDao = userDao;
		iUserDao.clearCollection();
	}
	
	public void updateLogin(User user, UserDao userDao) {

		iUserDao = userDao;
		iUserDao.update(user);
	}
	
	public void getAll(UserDao userDao) {

		iUserDao = userDao;
		iUserDao.getAll();
	}
	
	public void getByLogin(String login, UserDao userDao) {

		iUserDao = userDao;
		iUserDao.getByLogin(login);;
	}
}
