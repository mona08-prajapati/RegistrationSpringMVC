package com.apex.Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apex.Util.DbUtil;

//import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Jdbc;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcOperations;
//import org.springframework.jdbc.core.JdbcTemplate;    
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;

import com.apex.bean.User;
import com.apex.constants.UserConstants;


    @Repository
public class UserDao {
    	
//    	@Autowired    
//        private  DbUtil Util ;
//    	public UserDao() {
//    		connection = DbUtil.getConnection();
//    	}

    	public  Boolean addUser(User user) {
    		try {
    			try {
    				Connection connection ;
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "Vriha@50");
    			PreparedStatement preparedStatement = connection
    					.prepareStatement("insert into user(firstname,lastname,username,password,id) values (?, ?, ?, ? ,?)");
    			// Parameters start with 1
    			preparedStatement.setString(1, user.getFirstname());
    			preparedStatement.setString(2, user.getLastname());
    			preparedStatement.setString(3, user.getUsername());
    			preparedStatement.setString(4, user.getPassword());
    			preparedStatement.setString(5, user.getId());
    			
    			int executeUpdate=preparedStatement.executeUpdate();
            if (executeUpdate==1) {
            	return true;
	
}
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
			return false;}
    	
    	public  Boolean isUserNameDuplicate(User user) 
    	{   
    		try {
    			try {
    				Connection connection ;
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			 System.out.print("count :Step11111111111111111");
    			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "Vriha@50");
    			PreparedStatement preparedStatement = connection
    					.prepareStatement("select Count(*) from user where username=?");
    			
    			preparedStatement.setString(1, user.getUsername());   			
    			
				
					ResultSet resultset;
					resultset = preparedStatement.executeQuery();
					 System.out.print("count isssssssssssssssssssss:"+resultset);
    		
            if (resultset.next()) 
            {
            	int count=resultset.getInt(1);
            System.out.print("count isssssssssssssssssssss:"+count);
            if(count>0) {
            	return true;
            }
            }
    		}
    		 catch (SQLException e) {
    			e.printStackTrace();
    		}
    		
			return false;}
    	
    	
    		
    	}
    
    
