package com.deanntu.user.setup;

import com.deanntu.user.entity.User;
import com.deanntu.user.manager.UserManager;

public class UserSetup {
	public static void main(String[] args) {
		UserManager um = new UserManager();
		User admin = new User(1,"admin","admin","none");
		try {um.create(admin);}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	private void deleteAll() {
		/*try {
	        for(User x :UserManager.list()) {
	        	UserManager.delete(x.getCategoryID());
	        }
		}catch(Exception e) {
			
		}*/
	}
}
