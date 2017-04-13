package com.revature.kkoders.service;

import com.revature.kkoders.dao.GamePlanImplDAOImpl;

public class GamePlanService {
	
	GamePlanImplDAOImpl gmpl = new GamePlanImplDAOImpl();
	
	//The following functions will set/change the game plan for the user
	public boolean GameTitle(String name, int id) {
		boolean complete = false;
		
		if( name.isEmpty() && (name instanceof String == false) & id < 0 ) {
			System.out.println("You need to pass in ");
			return complete;
		}
		
		else {
			gmpl.setTitleForForm(name, id);
			complete = true;
		}
		return complete;
		
	}
	
	//id should be the username passed in and name is the date as a string format
	public boolean StartDate(String name, int id) {
		boolean complete;
		
		if ( name.isEmpty() & (name instanceof String == false) & id < 0 ){
			System.out.println("You need to pass in a string and the id can not be negative");
			complete = false;
		}
		else {
			gmpl.setEndDate(name, id);
			complete = true;
		}
		
		return complete;
	}
	
	//id is the user id in the game plan table which should be retrived by the user 
	//
	public boolean EndDate(String name, int id) {
		boolean complete;
		if ( name.isEmpty() & (name instanceof String == false) & id < 0 ){
			System.out.println("You need to pass in a string and the id can not be negative");
			complete = false;
		}
		
		else {
			gmpl.ChangeEndDate(name, id);
			complete = true;
		}
		
		return complete;
	}
	
	public boolean HoursSet(double h, int id) {
		boolean complete;
		if( h < 0.0 & id < 0 ){
			System.out.println("These numbers should not be negtive!!");
			complete = false;
		}
		else {
			gmpl.setHoursByUser(h, id);
			complete = true;
		}
		
		return complete;
	}
	
	

}
