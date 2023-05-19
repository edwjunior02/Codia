package managers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.User;
import utils.DB;

public class ManageUsers {
	
	private DB db = null ;
	
	public ManageUsers() {
		try {
			db = new DB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void finalize() {
		try {
			db.disconnectBD();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
		
	// Add new user
	public void addUser(String name, String mail, String pwd, String genders, String phone_number, String experience, String languages, String linkedin) {
		String query = "INSERT INTO users (user_name,mail,user_password,gender,phone_number,experience,languages,linkedin) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setString(1,name);
			statement.setString(2,mail);
			statement.setString(3,pwd);
			statement.setString(4,genders);
			statement.setString(5,phone_number);
			statement.setString(6,experience);
			statement.setString(7,languages);
			statement.setString(8,linkedin);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*Check if all the fields are filled correctly */
	public boolean isComplete(User user) {
	    return(hasValue(user.getUser()) 		&&
	    	   hasValue(user.getMail()) 		&&
	    	   hasValue(user.getPwd1()) 		&&
	           hasValue(user.getPwd2()) 		&&
	           hasValue(user.getPhoneNumber()) 	&&
	           hasValue(user.getGender()) 		&&
	           hasValue(user.getExperience()) 	&&
	           hasValue(user.getLanguages()) 	&&
	           hasValue(user.getLinkedin())	);
	}
	
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}
		
	
	// TODO: add other methods 

}
