package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.MySqlConnec;
import pojo.User;


public class LoginDao {

	static MySqlConnec mySqlConnec = new MySqlConnec();
	static String queryLogin = "SELECT id_user, txt_email, txt_password, bol_state, dt_create, dt_update FROM db_contacs.tb_user where txt_email=? and txt_password=? and bol_state=?";

	public static User onLogin(String email,String password) {

		User userData = null;
		PreparedStatement preparedStatement;
		ResultSet rs;
		try {
			preparedStatement = mySqlConnec.getConexion().prepareStatement(queryLogin);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.setBoolean(3, true);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				userData = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5),
						rs.getString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userData;
	}
}
