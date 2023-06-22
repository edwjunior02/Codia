package managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import models.User;
import utils.DB;

public class ManageUsers {
	
	private DB db = null ;
	private boolean exists = false;
	
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
	
	/* Get a user given its PK*/
	public User getUser(Integer id) {
		String query = "SELECT id,name,mail FROM users WHERE id = ? ;";
		PreparedStatement statement = null;
		ResultSet rs = null;
		User user = null;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,id);
			rs = statement.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("name"));
				user.setMail(rs.getString("mail"));
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
		
	// Add new user
	public void addUser(User user) {
        String query = "INSERT INTO codia.users (name, mail, pwd, gender, phonenumber, experience, languages, linkedin) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setString(1, user.getUsername());
            statement.setString(2, user.getMail());
            statement.setString(3, user.getPwd1());
            statement.setString(4, user.getGenders());
            statement.setString(5, user.getPhonenumber());
            statement.setString(6, user.getExperience());
            statement.setString(7, user.getLanguages());
            statement.setString(8, user.getLinkedin());
			statement.executeUpdate();
			statement.close();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Follow a user
	public void followUser(Integer uid, Integer fid) {
		String query = "INSERT INTO codia.follows (uid,fid) VALUES (?,?)";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,uid);
			statement.setInt(2,fid);
			statement.executeUpdate();
			statement.close();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Unfollow a user
	public void unfollowUser(Integer uid, Integer fid) {
		String query = "DELETE FROM codia.follows WHERE uid = ? AND fid = ?";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,uid);
			statement.setInt(2,fid);
			statement.executeUpdate();
			statement.close();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Get all the users
	public List<User> getUsers(Integer start, Integer end) {
		 String query = "SELECT id,name FROM codia.users ORDER BY name ASC LIMIT ?,?;";
		 PreparedStatement statement = null;
		 List<User> l = new ArrayList<User>();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,start);
			 statement.setInt(2,end);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 User user = new User();
				 user.setId(rs.getInt("id"));
				 user.setUsername(rs.getString("name"));
				 l.add(user);
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	
	public List<User> getNotFollowedUsers(Integer id, Integer start, Integer end) {
		 String query = "SELECT id,name FROM codia.users WHERE id NOT IN (SELECT id FROM codia.users,codia.follows WHERE id = fid AND uid = ?) AND id <> ? ORDER BY name LIMIT ?,?;";
		 PreparedStatement statement = null;
		 List<User> l = new ArrayList<User>();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,id);
			 statement.setInt(2, id);
			 statement.setInt(3,start);
			 statement.setInt(4,end);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 User user = new User();
				 user.setId(rs.getInt("id"));
				 user.setUsername(rs.getString("name"));
				 l.add(user);
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	
	public List<User> getFollowedUsers(Integer id, Integer start, Integer end) {
		 String query = "SELECT id,name FROM codia.users,codia.follows WHERE id = fid AND uid = ? ORDER BY name LIMIT ?,?;";
		 PreparedStatement statement = null;
		 List<User> l = new ArrayList<User>();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,id);
			 statement.setInt(2,start);
			 statement.setInt(3,end);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 User user = new User();
				 user.setId(rs.getInt("id"));
				 user.setUsername(rs.getString("name"));
				 l.add(user);
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	
	public Pair<Boolean,User> checkLogin(User user) {
		
		String query = "SELECT id,mail from codia.users where name=? AND pwd=?";
		PreparedStatement statement = null;
		boolean output = false;
		try {
			statement = db.prepareStatement(query);
			statement.setString(1,user.getUsername());
			statement.setString(2,user.getPwd1());
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setMail(rs.getString("mail"));
				output = true;
			} 
			rs.close();
			statement.close();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Pair.of(output,user);
		
	}
	
	public boolean checkUser(String user) {
		
		String query = "SELECT name from codia.users where name=?";
		PreparedStatement statement = null;
		ResultSet rs = null;
		boolean output = false;
		try {
			
			statement = db.prepareStatement(query);
			statement.setString(1,user);
			rs = statement.executeQuery();
			if (rs.isBeforeFirst()) {
				output = true;
			}
			rs.close();
			statement.close();
			return output;
			
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("output: " + output);
		return output;
		
	}
	
	public boolean checkMail(String mail) {
		
		String query = "SELECT mail from codia.users where mail=?";
		PreparedStatement statement = null;
		ResultSet rs = null;
		boolean output = false;
		try {
			
			statement = db.prepareStatement(query);
			statement.setString(1,mail);
			rs = statement.executeQuery();
			if (rs.isBeforeFirst()) {
				output = true;
			}
			rs.close();
			statement.close();
			return output;
			
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("output: " + output);
		return output;
		
	}
		
	/*Check if all the fields are filled correctly */
	public boolean isComplete(User user) {
		/*System.out.println("User: " + hasValue(user.getUsername()));
	    System.out.println("Mail: " + hasValue(user.getMail()));
	    System.out.println("Pwd1: " + hasValue(user.getPwd1()));
	    System.out.println("Pwd2: " + hasValue(user.getPwd2()));
	    System.out.println("PhoneNumber: " + hasValue(user.getPhonenumber()));
	    System.out.println("Genders: " + hasValue(user.getGenders()));
	    System.out.println("Experience: " + hasValue(user.getExperience()));
	    System.out.println("Languages: " + hasValue(user.getLanguages()));
	    System.out.println("Linkedin: " + hasValue(user.getLinkedin()));*/
	    
	    return(hasValue(user.getUsername()) &&
                hasValue(user.getMail()) &&
                hasValue(user.getPwd1()) &&
                hasValue(user.getPwd2()) &&
                hasValue(user.getPhonenumber()) &&
                hasValue(user.getGenders()) &&
                hasValue(user.getExperience()) &&
                hasValue(user.getLanguages()) &&
                hasValue(user.getLinkedin()));
	}
	
	public boolean isLoginComplete(User user) {
		
		System.out.println("User: " + hasValue(user.getUsername()));
	    System.out.println("Pwd1: " + hasValue(user.getPwd1()));
		
	    return(hasValue(user.getUsername()) &&
	    	   hasValue(user.getPwd1()));
	}
	
	private boolean hasValue(String val) {
		return (val != null && !val.isEmpty());
	}
		
	
	// TODO: add other methods 
	//Check if user is in DataBase
    public boolean userExists(String name) {
        String query = "SELECT COUNT(*) FROM codia.users WHERE name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            statement = db.prepareStatement(query);
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                exists = count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return exists;
    }

}