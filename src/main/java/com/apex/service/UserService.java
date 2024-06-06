package com.apex.service;

import com.apex.bean.User;

import com.apex.constants.UserConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apex.Dao.UserDao;
@Service
public class UserService 
{
	@Autowired
	private  UserDao userDao;
	

	public String registerUser(User user) {
		String error=null;
	
		try {
			if(!userDao.addUser(user)) 
			{
				//if there is no user then not add to database
				error="invalid to add user";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return error;
	}
	public String isUserNameDuplicate(User user) 
	{
		String error=null;
		Boolean usernameduplicate=userDao.isUserNameDuplicate(user);
		System.out.print("user name duplicate is:"+usernameduplicate);
		if(usernameduplicate==true) {
			error=UserConstants.DUPLICATE_USERNAME;
		}return error;
	}
	}

