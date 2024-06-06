package com.apex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apex.Dao.UserDao;
import com.apex.Util.DbUtil;
import com.apex.bean.User;
import com.apex.service.UserService;

@Controller

public class RegistrationController1 {
	private final  UserService userService;

	@Autowired    
     public RegistrationController1 (UserService userService) {
		this.userService=userService;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String controller(ModelMap modelMap) 
	{System.out.print("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
		modelMap.addAttribute("message", "Registration Form");
		return "registration";
	}
	
//	@RequestMapping(value="/register",method=RequestMethod.POST)
//	public ModelAndView controller1(@ModelAttribute User user) 
//	{System.out.print("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
//	
//		ModelAndView modelAndview=new ModelAndView();
//		modelAndview.setViewName("succes");
//		modelAndview.addObject("user", user);
//		return modelAndview;
//	}
//	
	@RequestMapping(value="/registerform",method = RequestMethod.POST)    
    public ModelAndView register(@ModelAttribute User user)
	{ 
		
		ModelAndView modelAndview=new ModelAndView();
		
        String validationError=DbUtil.validateRequest(user);
        if(validationError!=null) {
        	
        	modelAndview.setViewName("RegisterFailure");
    		modelAndview.addObject("Error",validationError);
    		return modelAndview;  
        }
        if(userService.isUserNameDuplicate(user)!=null) {
        	
        	modelAndview.setViewName("RegisterFailure");
    		modelAndview.addObject("Error","user already exist");
    		return modelAndview;  
        	}
        if(userService.registerUser(user)==null) {
        	//user is there to register( error=null)
        	modelAndview.setViewName("RegisterSuccess");
    		modelAndview.addObject("message","user register succesfully");
    		return modelAndview;  
        	}
        else {
        	modelAndview.setViewName("RegisterFailure");
    		modelAndview.addObject("Error","Fail to register user try again later");
        }
        return modelAndview;  
        }
   }    



