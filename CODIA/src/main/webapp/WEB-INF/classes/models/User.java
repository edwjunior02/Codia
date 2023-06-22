package models;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements java.io.Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private int id = 0;
	private String username = "";
	private String mail = "";
	private String pwd1 = "";
	private String pwd2 = "";
	private String phonenumber = "";
	private String genders = "";
	private String experience = "";
	private String languages = "";
	private String linkedin = "";

	private HashMap<String,Boolean> error = null;
	
	public User() {
		 error = new HashMap<String, Boolean>();
		 error.put("username", false);
		 error.put("mail", false);
		 error.put("pwd1", false);
		 error.put("pwd2", false);
		 error.put("phonenumber", false);
		 error.put("genders", false);
		 error.put("experience", false);
		 error.put("languages", false);
		 error.put("linkedin", false);
	}
	
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
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
			System.out.println("mail is correct.");
		} else {
			error.put("mail", true);
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
			System.out.println("pwd is correct.");
		} else {
			error.put("pwd1", true);
		}
	}
	
	public String getPwd2() {
		return this.pwd2;
	}
	
	public void setPwd2(String pwd2) {
	    if (pwd1 != null && pwd1.equals(pwd2)) {
	        this.pwd2 = pwd2;
	    } else {
	        error.put("pwd2", true);        
	    }
	}

	
	public String getPhonenumber() {
		return this.phonenumber;
	}
	
	public void setPhonenumber(String phonenumber) {
		String regex = "(\\+34|0034|34)?[ -]*(6|7)[ -]*([0-9][ -]*){8}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phonenumber);
		if (matcher.matches()) {
			this.phonenumber = phonenumber;
			System.out.println("phone is correct.");
		} else {
			error.put("phonenumber", true);
		}
	}
	
	public String getGenders() {
		return this.genders;
	}
	
	public void setGenders(String genders) {
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
	
	public HashMap<String,Boolean> getError() {
		return this.error;
	}
	
	public void setError(String name, boolean error) {
		this.error.put(name, error);
	}
		
}
