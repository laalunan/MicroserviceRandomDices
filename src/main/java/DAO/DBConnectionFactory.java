package DAO;

import java.sql.Connection;

public abstract class DBConnectionFactory {
    private String driverName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/random";
    private String username = "la";
    private String password = "1234";
    
    public static DBConnectionFactory getInstance() {
        return new DBConnectionFactoryImpl();
    }
    
    public abstract Connection getConnection();

    public String getDriverName() {
        return driverName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
}
