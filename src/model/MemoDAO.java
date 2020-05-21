package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemoDAO {

	static final String URL = "jdbc:mysql://localhost/memo?useSSL=false";
	static final String USER = "Java";
	static final String PASS = "pass";

	public ArrayList<Memo> findAll() {
		ArrayList<Memo> list = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {

			String sql = "SELECT * FROM memo";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int mid = rs.getInt("mid");
				String title = rs.getString("title");
				String body = rs.getString("body");

				Memo m = new Memo(mid, title, body);
				list.add(m);

			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("findAllエラー：" + e.getMessage());
		}
		return list;

	}


	public Memo findByMid(int mid) {
		Memo m = null;

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {

			String sql = "SElECT * FROM memo WHERE mid = ?";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, mid);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String title = rs.getString("title");
				String body = rs.getString("body");

				m = new Memo(mid, title, body);

			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("findAllエラー：" + e.getMessage());
		}
		return m;

	}

}
