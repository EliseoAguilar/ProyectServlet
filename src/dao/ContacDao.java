package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnec;
import pojo.Contac;

public class ContacDao {

	static MySqlConnec mySqlConnec = new MySqlConnec();
	static String queryGetAll = "SELECT id_contac, txt_name, txt_number, id_user FROM tb_contac";
	static String queryCreate = "INSERT INTO tb_contac (txt_name, txt_number, id_user) VALUES (?,?,?)";
	static String queryUpdate = "UPDATE tb_contac SET txt_name=?, txt_number=?, id_user=? WHERE id_contac = ?";
	static String queryDelete = "DELETE FROM tb_contac WHERE id_contac = ?";
	static String queryGet = "SELECT id_contac, txt_name, txt_number, id_user FROM tb_contac WHERE id_contac = ?";

	public static List<Contac> getAllContac() {

		List<Contac> listCont = new ArrayList<Contac>();
		PreparedStatement preparedStatement;
		ResultSet rs;
		try {
			preparedStatement = mySqlConnec.getConexion().prepareStatement(queryGetAll);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				listCont.add(new Contac(rs.getString(2), rs.getString(3), rs.getInt(1), rs.getInt(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCont;

	}

	public static void insertContac(Contac con) {

		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = mySqlConnec.getConexion().prepareStatement(queryCreate);
			preparedStatement.setString(1, con.getName());
			preparedStatement.setString(2, con.getNumber());
			preparedStatement.setInt(3, con.getIdUser());
			int rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateContac(Contac con) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = mySqlConnec.getConexion().prepareStatement(queryUpdate);
			preparedStatement.setString(1, con.getName());
			preparedStatement.setString(2, con.getNumber());
			preparedStatement.setInt(3, con.getIdUser());
			preparedStatement.setInt(4, con.getId());
			int rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Contac getContac(int id) {

		Contac cont = null;
		PreparedStatement preparedStatement;
		ResultSet rs;
		try {
			preparedStatement = mySqlConnec.getConexion().prepareStatement(queryGet);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				cont = new Contac(rs.getString(2), rs.getString(3), rs.getInt(1), rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cont;

	}

	public static void deleteContac(int id) {

		PreparedStatement preparedStatement;
		try {
			preparedStatement = mySqlConnec.getConexion().prepareStatement(queryDelete);
			preparedStatement.setInt(1, id);
			int rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
