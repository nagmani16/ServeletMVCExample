package service;

import java.util.HashMap;

import dto.User;

public class LginService {
	
	HashMap<String, String> users= new HashMap<String, String>();
	
	public LginService(){
		
		users.put("n16", "nagmani Prasad");
		users.put("r25", "Rajani Gandha");
		users.put("i24", "Ishani Prasad");
		users.put("r11", "Raya Prasad");
				
	}
	
	
	public boolean authenticate (String userID, String password){
		
		if (password==null ||password.trim()==""){
			
			return false;
		} else {
			return true;
		}
	}
	
	
	public User getUserDetails(String userId){
		User user= new User(); 
		
		user.setUserId(userId);
		user.setUserName(users.get(userId));
		
		return user;
		
	}

}
