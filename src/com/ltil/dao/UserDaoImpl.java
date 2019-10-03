package com.ltil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ltil.model.User;
import com.ltil.utilities.ConnectionManager;

public class UserDaoImpl implements UserDao {
	private Connection connection=ConnectionManager.getConnection();
	private String s="select * from users1 where id=? and password =?";
	private String si="insert into users1 values(?,?,?)";
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	@Override
	public boolean validateUser(User user) {
		
		 try {
			ps=connection.prepareStatement(s);
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getPassword());
		//	ps.setString(3, user.getUsername());
			rs=ps.executeQuery();
			while(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean insertUser(User user) {
		 try {
				ps=connection.prepareStatement(si);
				ps.setString(1, user.getUserid());
				ps.setString(2, user.getUsername());
				ps.setString(3, user.getPassword());
				int i=ps.executeUpdate();
				return true;
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			return false;
	}
	
	

}
