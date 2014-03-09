package com.lunchtool;

public interface UserUtils {
	public void storeUser(User user);
	public User findUserByLogin(String login);
	public Boolean authenticateUser(String login, String password);

}
