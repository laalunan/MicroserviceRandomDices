package DAO;

import java.sql.Connection;

public abstract class DBConnectionFactory {
    
    public static DBConnectionFactory getInstance() {
        return new DBConnectionFactoryImpl();
    }
    
    public abstract Connection getConnection();
    
}
