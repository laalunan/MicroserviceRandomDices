package DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.DBConnectionFactory;

public class DBConnectionFactoryImpl extends DBConnectionFactory {

	Properties prop = new Properties();
	InputStream input = null;

	public Connection getConnection() {
		try {
			input = new FileInputStream("config/application.properties");

			prop.load(input);

			if (prop.getProperty("use.database").equals("true")) {

				Class.forName(prop.getProperty("db.mysql.drivername"));
				Connection conn = DriverManager.getConnection(prop.getProperty("db.mysql.url"),
						prop.getProperty("db.mysql.username"), prop.getProperty("db.mysql.password"));
				return conn;
			}
			return null;
		} catch (ClassNotFoundException | SQLException | IOException io) {
			Logger.getLogger(DBConnectionFactoryImpl.class.getName()).log(Level.SEVERE, null, io);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}