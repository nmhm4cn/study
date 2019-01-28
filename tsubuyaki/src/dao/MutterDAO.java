package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {

	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String JDBC_URL ="jdbc:mysql://localhost:3306/tsubuyaki";
	private final String DB_USER = "dbuser";
	private final String DB_PASS = "Aaa123";

	public List<Mutter> findAll() { // つぶやきリストをデータベースから取得
		Connection con = null;
		List<Mutter> mutterList = new ArrayList<Mutter>();
		try {
			// データベースへ接続
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// SELECT文の準備
			String sql = "SELECT ID,NAME,TEXT FROM MUTTER ORDER BY ID DESC";
			PreparedStatement pStmt = con.prepareStatement(sql);

			// SELECTを実行
			ResultSet rs = pStmt.executeQuery();

			// SELECT文の結果をArrayListに格納
			while(rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Mutter mutter = new Mutter(id, userName, text);
				mutterList.add(mutter);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {

			// データベース切断
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return mutterList;
	}

	public boolean create(Mutter mutter) {
		Connection con = null;
		try {
			// データベースへ接続
			con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// INSERT文の準備
			String sql = "INSERT INFO MUTTER(NAME, TEXT) VALUES(?, ?)";
			PreparedStatement pStmt = con.prepareStatement(sql);
			// INSERT文の?に値を入れる
			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getText());

			// INSERT文を実行
			int result = pStmt.executeUpdate();

			if(result != 1) {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {

			// データベース切断
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
}
