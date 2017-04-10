package com.revature.kkoders.testing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.kkoders.service.UserService;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	
    	//ApplicationContext a = new ClassPathXmlApplicationContext("beans.xml");

    	//UserService service = (UserService)a.getBean(UserService.class);
    	
        UserService service = new UserService();
        
        service.addUser();
        
        System.out.println("test main");
        
    }

}