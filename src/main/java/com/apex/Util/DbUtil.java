package com.apex.Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import jakarta.servlet.http.HttpServletRequest;

import com.apex.constants.UserConstants;

import com.apex.bean.User;
import jakarta.servlet.http.HttpServletRequest;



public class DbUtil {
	 final String UserConstants = null;
//	private static Connection connection = null;
//
//    public static Connection getConnection() {
//    	
//        if (connection != null)
//            return connection;
//        else {
//            try {
//            	Properties prop = new Properties();
//                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
//                prop.load(inputStream);
//                String driver = prop.getProperty("driver");
//                System.out.println(driver+"Sameerrrrrrrrrrrrr");
//                String url = prop.getProperty("url");
//                String user = prop.getProperty("user");
//                String password = prop.getProperty("password");
//                Class.forName(driver);
//                connection = DriverManager.getConnection(url, user, password);
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return connection;}}
//    

	public static String validateRequest(User user) {
		String error=null;
		String username=user.getUsername();
		String password=user.getPassword();
		String firstname=user.getFirstname();
		String lastname=user.getLastname();
		if(username.isEmpty()||password.isEmpty()||firstname.isEmpty()||lastname.isEmpty()) 
		{
			error=com.apex.constants.UserConstants.EMPTY_FIRSTNAME;
		}
		return error;
	
}}