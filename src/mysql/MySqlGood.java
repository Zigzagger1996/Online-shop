package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import dao.AbstractJDBCDao;
import dao.PersistException;
import entity.Good;
import entity.User;


public class MySqlGood extends AbstractJDBCDao<Good, Integer>{
	
	private class PersistGood extends Good {
        public void setId(int id) {
            super.setId(id);
        }
    }


    @Override
    public String getSelectQuery() {
        return "SELECT id, name, quantity, price, link FROM shop.good";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO shop.good (name, quantity, price, link) \n" +
                "VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE shop.good SET name=? quantity=? price=? link = ? WHERE id= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM shop.good WHERE id= ?;";
    }

    @Override
    public Good create() throws PersistException {
        Good g = new Good();
        return persist(g);
    }

    public MySqlGood(Connection connection) {
        super(connection);
    }

    @Override
    protected List<Good> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Good> result = new LinkedList<Good>();
        try {
            while (rs.next()) {
                PersistGood good = new PersistGood();
                good.setId(rs.getInt("id"));	                
                good.setName(rs.getString("name"));
                good.setQuantity(rs.getInt("quantity"));	                
                good.setPrice(rs.getDouble("price"));
                good.setLink(rs.getString("link"));
                result.add(good);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Good object) throws PersistException {
        try {	            
            statement.setString(1, object.getName());
            statement.setInt(2, object.getQuantity());
            statement.setDouble(3, object.getPrice());	            
            statement.setString(4, object.getLink());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Good object) throws PersistException {
        try {	            
        	statement.setString(1, object.getName());
            statement.setInt(2, object.getQuantity());
            statement.setDouble(3, object.getPrice());	            
            statement.setString(4, object.getLink());
            statement.setInt(5, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

}
