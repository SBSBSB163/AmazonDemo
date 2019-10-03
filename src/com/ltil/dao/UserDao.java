package com.ltil.dao;

import com.ltil.model.User;

public interface UserDao {


	public boolean validateUser(User user);
	public boolean insertUser(User user);
}
