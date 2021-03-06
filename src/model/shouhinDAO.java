package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class shouhinDAO {

	static final String URL = "jdbc:mysql://localhost/hanbai?useSSL=false";
	static final String USER = "Java";
	static final String PASS = "pass";



	public ArrayList<Shouhin> findAll() {

		ArrayList<Shouhin> list = new ArrayList<Shouhin>();

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {

			String sql = "SElECT * FROM shouhin";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int sid = rs.getInt("sid");
				String sname = rs.getString("sname");
				int tanka = rs.getInt("tanka");

				Shouhin s = new Shouhin(sid, sname, tanka);
				list.add(s);

			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("findAllエラー：" + e.getMessage());
		}

		return list;

	}


	public static void find(int sid, String sname, int tanka) {

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {

			String sql = "SElECT * FROM shouhin WHERE sid=?, sname=?, tanka=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			stmt.setInt(1, sid);
			stmt.setString(2, sname);
			stmt.setInt(3, tanka);

			if (rs.next()) {
				sname = rs.getNString("sname");
				tanka = rs.getInt("tanka");

				System.out.println(sname + " " + tanka);
			}

			stmt.close();

		} catch (SQLException e) {
			System.out.println("findエラー：" + e.getMessage());
		}
	}


	public Shouhin findBySid(int sid) {

		Shouhin s = null;

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {

			String sql = "SElECT * FROM shouhin WHERE sid = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt	.setInt(1, sid);
			ResultSet rs = stmt.executeQuery();



			if(rs.next()) {
				String sname = rs.getString("sname");
				int tanka = rs.getInt("tanka");

				s = new Shouhin(sid, sname, tanka);
			}

			stmt.close();

		} catch (SQLException e) {
			System.out.println("findBySidエラー：" + e.getMessage());
		}

		return s;
	}


	public static void insert(Shouhin s) {

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {

			String sql = "INSERT into shouhin (sname, tanka) values(?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, s.getSname());
			stmt.setInt(2, s.getTanka());

			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("insertエラー：" + e.getMessage());
		}
	}

	public static void update(Shouhin s) {

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {

			String sql = "UPDATE shouhin SET sname=?, tanka=? WHERE (sid=?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, s.getSname());
			stmt.setInt(2, s.getTanka());
			stmt.setInt(3, s.getSid());

			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("updateエラー：" + e.getMessage());
		}
	}


	public static void delete(int sid) {

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {

			String sql = "DELETE FROM shouhin WHERE sid=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, sid);

			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("updateエラー：" + e.getMessage());
		}
	}




}
