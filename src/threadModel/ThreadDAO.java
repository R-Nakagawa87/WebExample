package threadModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ThreadDAO {

	static final String URL = "jdbc:mysql://localhost/keijiban?useSSL=false";
	static final String USER = "Java";
	static final String PASS = "pass";


	public ArrayList<Thread> findAll() {
		ArrayList<Thread> list = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {

			String sql = "SELECT * FROM thread";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int tid = rs.getInt("tid");
				String name = rs.getString("name");
				String mainText = rs.getString("mainText");
				Timestamp insertTime = rs.getTimestamp("insertTime");

				Thread t = new Thread(tid, name, mainText, insertTime);
				list.add(t);

			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("findAllエラー：" + e.getMessage());
		}
		return list;
	}


	public Thread findByMid(int tid) {
		Thread t = null;

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {

			String sql = "SElECT * FROM thread WHERE tid = ?";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, tid);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				String mainText = rs.getString("mainText");
				Timestamp insertTime = rs.getTimestamp("insertTime");

				t = new Thread(tid, name, mainText, insertTime);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("findAllエラー：" + e.getMessage());
		}
		return t;

	}


	public void insert(Thread t) {

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {

			String sql = "INSERT into thread (name, mainText, insertTime) values(?,?,now())";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, t.getName());
			stmt.setString(2, t.getMainText());

			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("insertエラー：" + e.getMessage());
		}
	}

	public void update(Thread t) {

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {

			String sql = "UPDATE thread SET name=?, adr=? WHERE (tid=?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, t.getName());
			stmt.setString(2, t.getMainText());
			stmt.setInt(3, t.getTid());

			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("updateエラー：" + e.getMessage());
		}
	}


	public void delete(int tid) {

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {

			String sql = "DELETE FROM thread WHERE tid=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, tid);
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("updateエラー：" + e.getMessage());
		}
	}
}
