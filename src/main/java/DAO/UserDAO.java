package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import hello.Dice;


public class UserDAO {
	public void insertDice(List<Dice> d) {
		DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
		Connection conn = myFactory.getConnection();

		
		String query = "INSERT INTO random_number(dice1, dice2, dice3, timestamp) VALUES(?,?,?,?)";
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, d.get(0).getNumber());
			pstmt.setInt(2, d.get(1).getNumber());
			pstmt.setInt(3, d.get(2).getNumber());

			java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            pstmt.setString(4, sdf.format(dt));

			rs = pstmt.executeUpdate();


		} catch (SQLException ex) {
			Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
