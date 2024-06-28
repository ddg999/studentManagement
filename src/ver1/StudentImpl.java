package ver1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentImpl implements Student {

	public static final String ADD_STUDENT = " INSERT INTO students(name, age, email) values (?, ?, ?) ";
	public static final String INFO_ALL_STUDENT = " SELECT * FROM students ";
	public static final String INFO_ID_STUDENT = " SELECT * FROM students WHERE id = ? ";
	public static final String INFO_NAME_STUDENT = " SELECT * FROM students WHERE name = ? ";
	public static final String MODIFY_ID_STUDENT = " UPDATE students SET name = ?, age = ?, email = ? WHERE id = ?";
	public static final String MODIFY_NAME_STUDENT = " UPDATE students SET name = ?, age = ?, email = ? WHERE name = ?";
	public static final String DELETE_ALL_STUDENT = " DELETE FROM students";
	public static final String DELETE_ID_STUDENT = " DELETE FROM students WHERE id = ? ";
	public static final String DELETE_NAME_STUDENT = " DELETE FROM students WHERE NAME = ? ";

	@Override
	public void addStudent(String name, int age, String email) throws SQLException {
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(ADD_STUDENT);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, email);
			pstmt.executeUpdate();
			System.out.println(">>> 추가 완료 <<<");
		}
	}

	@Override
	public void infoStudent() throws SQLException {
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(INFO_ALL_STUDENT);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null && rs.isBeforeFirst()) {
				while (rs.next()) {
					System.out.println("====================================");
					System.out.println("학번 : " + rs.getInt("id"));
					System.out.println("이름 : " + rs.getString("name"));
					System.out.println("나이 : " + rs.getInt("age"));
					System.out.println("Email : " + rs.getString("email"));
				}
			} else {
				System.out.println("조회할 정보가 없습니다");
			}
		}
	}

	@Override
	public boolean infoStudent(int id) throws SQLException {
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(INFO_ID_STUDENT);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null && rs.isBeforeFirst()) {
				while (rs.next()) {
					System.out.println("====================================");
					System.out.println("학번 : " + rs.getInt("id"));
					System.out.println("이름 : " + rs.getString("name"));
					System.out.println("나이 : " + rs.getInt("age"));
					System.out.println("Email : " + rs.getString("email"));
				}
				return true;
			} else {
				System.out.println("조회할 정보가 없습니다");
				return false;
			}
		}
	}

	@Override
	public boolean infoStudent(String name) throws SQLException {
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(INFO_NAME_STUDENT);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null && rs.isBeforeFirst()) {
				while (rs.next()) {
					System.out.println("====================================");
					System.out.println("학번 : " + rs.getInt("id"));
					System.out.println("이름 : " + rs.getString("name"));
					System.out.println("나이 : " + rs.getInt("age"));
					System.out.println("Email : " + rs.getString("email"));
				}
				return true;
			} else {
				System.out.println("조회할 정보가 없습니다");
				return false;
			}
		}
	}

	@Override
	public void modifyStudent(int id, String name, int age, String email) throws SQLException {
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(MODIFY_ID_STUDENT);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, email);
			pstmt.setInt(4, id);
			pstmt.executeUpdate();
			System.out.println(">>> 수정 완료 <<<");
		}
	}

	@Override
	public void modifyStudent(String beforeName, String name, int age, String email) throws SQLException {
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(MODIFY_NAME_STUDENT);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, email);
			pstmt.setString(4, beforeName);
			pstmt.executeUpdate();
			System.out.println(">>> 수정 완료 <<<");
		}
	}

	@Override
	public void deleteStudent() throws SQLException {
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(DELETE_ALL_STUDENT);
			pstmt.executeUpdate();
			System.out.println(">>> 모든 학생정보 삭제 완료 <<<");
		}
	}

	@Override
	public void deleteStudent(int id) throws SQLException {
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(DELETE_ID_STUDENT);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			System.out.println(">>> " + id + "학번 학생 삭제 완료 <<<");
		}
	}

	@Override
	public void deleteStudent(String name) throws SQLException {
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(DELETE_NAME_STUDENT);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			System.out.println(">>> " + name + " 학생 삭제 완료 <<<");
		}
	}

}
