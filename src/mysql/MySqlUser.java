package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import dao.AbstractJDBCDao;
import dao.Identified;
import dao.PersistException;
import entity.User;

public class MySqlUser extends AbstractJDBCDao<User, Integer>{
	 private class PersistUser extends User {
	        public void setId(int id) {
	            super.setId(id);
	        }
	    }


	    @Override
	    public String getSelectQuery() {
	        return "SELECT id, firstName, secondName, email, password FROM shop.user";
	    }

	    @Override
	    public String getCreateQuery() {
	        return "INSERT INTO shop.user (firstName, secondName, email, password) \n" +
	                "VALUES (?, ?, ?, ?);";
	    }

	    @Override
	    public String getUpdateQuery() {
	        return "UPDATE shop.user SET firstName=? secondName=? email=? password = ? WHERE id= ?;";
	    }

	    @Override
	    public String getDeleteQuery() {
	        return "DELETE FROM shop.user WHERE id= ?;";
	    }

	    @Override
	    public User create() throws PersistException {
	        User g = new User();
	        return persist(g);
	    }

	    public MySqlUser(Connection connection) {
	        super(connection);
	    }

	    @Override
	    protected List<User> parseResultSet(ResultSet rs) throws PersistException {
	        LinkedList<User> result = new LinkedList<User>();
	        try {
	            while (rs.next()) {
	                PersistUser user = new PersistUser();
	                user.setId(rs.getInt("id"));	                
	                user.setFirstName(rs.getString("firstName"));
	                user.setSecondName(rs.getString("secondName"));	                
	                user.setEmail(rs.getString("email"));
	                user.setPassword(rs.getString("password"));
	                result.add(user);
	            }
	        } catch (Exception e) {
	            throw new PersistException(e);
	        }
	        return result;
	    }

	    @Override
	    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws PersistException {
	        try {	            
	            statement.setString(1, object.getFirstName());
	            statement.setString(2, object.getSecondName());
	            statement.setString(3, object.getEmail());	            
	            statement.setString(4, object.getPassWord());
	        } catch (Exception e) {
	            throw new PersistException(e);
	        }
	    }

	    @Override
	    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws PersistException {
	        try {	            
	            statement.setString(1, object.getFirstName());
	            statement.setString(2, object.getSecondName());
	            statement.setString(3, object.getEmail());	            
	            statement.setString(4, object.getPassWord());
	            statement.setInt(5, object.getId());
	        } catch (Exception e) {
	            throw new PersistException(e);
	        }
	    }

}
