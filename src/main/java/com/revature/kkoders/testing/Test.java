package com.revature.kkoders.testing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.kkoders.service.UserService;
import com.revature.kkoders.service.GamePlanService;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.beans.GamePlanImpl;
import com.revature.kkoders.service.EditAccountService;;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	
    	//ApplicationContext a = new ClassPathXmlApplicationContext("beans.xml");

    	//UserService service = (UserService)a.getBean(UserService.class);
    	

        //UserService service = new UserService();

        
        //service.addUser();
        
        //System.out.println("test main");
        
        /****************************************************************************************/
        /*					Testing edit account service with tguy credetnials					*/
        /****************************************************************************************/
        
        
       // EditAccountService update_user = new EditAccountService();
        
        String guy = "tguy";
        //update_user.checkNewpassword(guy, "opeth");
        
        //testing game plan service
        GamePlanService gms = new GamePlanService();
        GamePlanImpl GMS = new GamePlanImpl();
        System.out.println("before putting info into the table");
        //gms.GamePlanSet(GMS);
        System.out.println(gms.GetPlansWithId(1250).toString());
    }

}