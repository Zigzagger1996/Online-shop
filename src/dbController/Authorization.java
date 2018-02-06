package dbController;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import dao.GenericDao;
import dao.PersistException;
import entity.User;
import mysql.MySqlDaoFactory;

public class Authorization {
	private DaoFactory factory = new MySqlDaoFactory();
    private Connection connection = (Connection) factory.getContext();
    private List<User> users;
     
    public Authorization() throws PersistException{
    	users  = new ArrayList<>();
    	readUsersFromDB();
    }
    
    public void readUsersFromDB() throws PersistException{
    	GenericDao dao = factory.getDao(connection, User.class);
    	users = dao.getAll();
    }
    
    public String checkForUser(String email, String password) {
    	for(User user: users) {
    		if(user.getEmail().equals(email) && user.getPassWord().equals(password)) {
    			return ("You've log in as a " + user.getFirstName() + " " + user.getSecondName());
    		}
    	}
    	return "";
    }

}
