package ver1;

import java.sql.SQLException;

public interface Student {
	void addStudent(String name, int age, String email) throws SQLException;

	void infoStudent() throws SQLException;

	boolean infoStudent(int id) throws SQLException;

	boolean infoStudent(String name) throws SQLException;

	void modifyStudent(int id, String name, int age, String email) throws SQLException;

	void modifyStudent(String beforeName, String name, int age, String email) throws SQLException;

	void deleteStudent() throws SQLException;

	void deleteStudent(int id) throws SQLException;

	void deleteStudent(String name) throws SQLException;
}
