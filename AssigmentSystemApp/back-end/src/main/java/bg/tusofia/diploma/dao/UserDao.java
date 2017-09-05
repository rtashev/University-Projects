package bg.tusofia.diploma.dao;

import bg.tusofia.diploma.entities.User;

public interface UserDao {
	
	User getUser(String username, String password);
	User getUserById(Integer id);
	void updateUser(User user);
}
