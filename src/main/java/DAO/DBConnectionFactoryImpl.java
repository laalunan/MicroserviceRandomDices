package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.DBConnectionFactory;

public class DBConnectionFactoryImpl extends DBConnectionFactory{
	

    public Connection getConnection() {
        try {
            Class.forName(getDriverName());
            Connection conn = 
                    DriverManager.getConnection(getUrl(), getUsername(), getPassword());
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnectionFactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
}