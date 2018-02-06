package dbController;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import dao.DaoFactory;
import dao.GenericDao;
import dao.PersistException;
import entity.User;
import mysql.MySqlDaoFactory;

public class Registration {
	private DaoFactory factory = new MySqlDaoFactory();
    private Connection connection = (Connection) factory.getContext();
    private List<User> users;
    
    public Registration() throws PersistException{
    	users  = new ArrayList<>();
    	readUsersFromDB();
    }
    
    public void readUsersFromDB() throws PersistException{
    	GenericDao dao = factory.getDao(connection, User.class);
    	users = dao.getAll();
    }
    
    public Boolean checkUserFirstName(String firstName) {
    	Matcher m = Regex.NAME_REGEX.matcher(firstName);
    	return m.matches();    
    }
    
    public Boolean checkUserSecondName(String secondName) {
    	Matcher m = Regex.NAME_REGEX.matcher(secondName);
    	return m.matches();
    }
    
    public Boolean checkUserEmail(String email) {
    Matcher m = Regex.REGEX_MAIL.matcher(email);
    return m.matches();
    }
    
    public Boolean checkUserPassword(String pass) {
    	if(pass.equals(null)|| pass.equals(""))
    		return false;
    	return true;
    }
    
    public Boolean checkForExistingUsers(String email) {
    	for(User user: users) {
    		if(user.getEmail().equals(email))
    			return false;
    	}
    	return true;
    	
    }
    
   public String insertNewUser(String firstName, String secondName, String email, String password) throws PersistException {
	   User user = new User();
	  if(checkUserFirstName(firstName)&& checkUserSecondName(secondName)&& checkUserEmail(email)&& checkUserPassword(password)&& checkForExistingUsers(email)) {
		  user.setFirstName(firstName);
		  user.setSecondName(secondName);
		  user.setEmail(email);
		  user.setPassword(password);
		  GenericDao dao = factory.getDao(connection, User.class);
		  dao.persist(user);
		  return "You are now in the system as" + user.getFirstName() + " " + user.getSecondName();
		  
	  }
	  return "";
	   
   }
}
