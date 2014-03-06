package com.lunchtool;

public interface UserUtils {
	public void storeUser(User user);
	public String findUser();
	public Boolean authenticateUser(String login, String password);

}
