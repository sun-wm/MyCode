package pzhu.service.impl;

import java.util.List;

import pzhu.dao.UserDao;
import pzhu.dao.impl.UserDaoImpl;
import pzhu.pojo.User;
import pzhu.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao ud=new UserDaoImpl();
	@Override
	public List<User> showUsers() {
		
		return ud.selectAllUsers();
	
}
}
