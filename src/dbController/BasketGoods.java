package dbController;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import dao.GenericDao;
import dao.PersistException;
import entity.Good;
import entity.User;
import mysql.MySqlDaoFactory;

public class BasketGoods {
	private DaoFactory factory = new MySqlDaoFactory();
    private Connection connection = (Connection) factory.getContext();
    private List<Good> goods;
    
    public BasketGoods() throws PersistException{
    	goods = new ArrayList<>();
    	readGoodsFromDB();
    }

    public void readGoodsFromDB() throws PersistException{
    	GenericDao dao = factory.getDao(connection, Good.class);
    	goods = dao.getAll();
    }
    
    public String searchByNameAndGetInfo(String name) {
    	StringBuilder builder = new StringBuilder("");
    	for(Good good: goods) {
    		if (good.getName().equals(name)) {
    			return good.getName();
    			//builder.append(good.getName() + " " + good.getPrice() + "\n" + good.getLink() + "\n")  ;
    		} 
    	}
    	return builder.toString();
    }
}
