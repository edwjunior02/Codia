package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements java.io.Serializable {
	
	/*
	 CREATE TABLE user (
		ID INTEGER NOT NULL AUTO_INCREMENT,
		user_name VARCHAR(24),
    	mail VARCHAR(255),
		user_password VARCHAR(24), 
    	gender VARCHAR(24),
    	phone_number VARCHAR(24),
    	experience VARCHAR(50),
    	languages VARCHAR(255),
    	linkedin VARCHAR(255),
    	UNIQUE KEY (user_name),
    	UNIQUE KEY (mail),
    	UNIQUE KEY (phone_number), 
    	PRIMARY KEY (ID)
	);
	*/
	
	private static final long serialVersionUID = 1L;
	
	private String user = "";
	private String mail = "";
	private String pwd1 = "";
	private String pwd2 = "";
	private String phone_number = "";
	private String genders = "";
	private String experience = "";
	private String languages = "";
	private String linkedin = "";
	
	private boolean[] error  = {false,false,false,false};
	
	public User() {
		
	}
	
	public String getUser() {
		return this.user;
	}
	
	public void setUser(String user) {
		/* We can simulate that a user with the same name exists in our DB and mark error[0] as true  */
		error[0] = true;
		//this.user = user;
		System.out.println(user);
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public void setMail(String mail) {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mail);
		if (matcher.matches()) {
			this.mail = mail;
			System.out.println(mail);
		} else {
			error[1]=true;
			System.out.println(mail);
		}
		
	}
	
	public String getPwd1() {
		return this.pwd1;
	}
	
	public void setPwd1(String pwd1) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pwd1);
		if (matcher.matches()) {
			this.pwd1 = pwd1;
			System.out.println(pwd1);
		} else {
			error[1]=true;
			System.out.println(pwd1);
		}
	}
	
	public String getPwd2() {
		return this.pwd2;
	}
	
	public void setPwd2(String pwd2) {
		if (pwd2 == this.pwd1) {
			this.pwd2 = pwd2;
			System.out.println(pwd2);
		} else {
			error[1]=true;
			System.out.println(pwd2);
		}
	}
	
	public String getPhoneNumber() {
		return this.phone_number;
	}
	
	public void setPhoneNumber(String phone_number) {
		String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone_number);
        if (matcher.matches()) {
            this.phone_number = phone_number;
            System.out.println(phone_number);
        } else {
            error[1] = true;
            System.out.println(phone_number);
        }
	}
	
	public String getGender() {
		return this.genders;
	}
	
	public void setGender(String genders) {
		this.genders = genders;
	}
	
	public String getExperience() {
		return this.experience;
	}
	
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	public String getLanguages() {
		return this.languages;
	}
	
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	
	public String getLinkedin(){
		return this.linkedin;
	}
	
	public void setLinkedin(String linkedin){
		this.linkedin = linkedin; 
	}
	
	public boolean[] getError() {
		return error;
	}
		
}
