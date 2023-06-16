package models;

public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String user = "";
	private String mail = "";
	private String pwd1 = "";
	private String pwd2 = "";
	private String phoneNumber = "";
	private String genders = "";
	private String experience = "";
	private String languages = "";
	private String linkedin = "";
	private int[] error = {0,0}; 
	
	/* Getters */
	public String getUser(){
		return user;
	}
	
	public String getMail() {
		return mail;
	}
	
	public String getPwd1() {
		return pwd1;
	}
	
	public String getPwd2() {
		return pwd2;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getGenders() {
		return genders;
	}
	
	public String getExperience() {
		return experience;
	}
	
	public String getLanguages() {
		return languages;
	}
	
	public String getLinkedin() {
		return linkedin;
	}
	
	public int[] getError() {
		return error;
	}
	
	/*Setters*/
	public void setUser(String user){
		this.user = user;
	}
	
	public void setMail(String mail){
		this.mail = mail;
	}
	
	public void setPwd1(String pwd1){
		this.pwd1 = pwd1;
	}
	
	public void setPwd1(String pwd2){
		this.pwd2 = pwd2;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public void setGenders(String genders){
		this.genders = genders;
	}
	
	public void setExperience(String experience){
		this.experience = experience;
	}
	
	public void setLanguages(String languages){
		this.languages = languages;
	}
	
	public void setLinkedin(String linkedin){
		this.linkedin = linkedin;
	}
	
	/* Logic Functions */
	public boolean isComplete() {
	    return(hasValue(getUser()) &&
	           hasValue(getMail()) &&
	           hasValue(getPwd1()) &&
	           hasValue(getPwd2()));
	}
	
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}
}
