package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.Course;
import model.Student;
import model.Teacher;

public class TableAction {
		
	public static void createStudentTable() throws SQLException {
		 String url = Url.getUrl();
		 String sql = "CREATE TABLE IF NOT EXISTS Student(\n"
	                + "StudentId integer PRIMARY KEY AUTOINCREMENT,\n"
	                + "Studentname text NOT NULL,\n"
	                + "StudentAge integer NOT NULL, \n"
	                + "FOREIGN KEY (StudentId) REFERENCES Course(CourseId),\n"
	                + "FOREIGN KEY (StudentId) REFERENCES Teacher(TeacherId)\n"
	                + ");";
		 Connection conn = null;
		 Statement state = null;
		 try { 
			 conn = DriverManager.getConnection(url);
			  state = conn.createStatement();
			 state.execute(sql);
		 } catch(SQLException e) {
	            System.out.println(e.getMessage());
	            } finally {
			 conn.close();
		 }
	}
	
	public static void createCourceTable() throws SQLException {
		 String url = Url.getUrl();
		 String sql = "CREATE TABLE IF NOT EXISTS Course(\n"
	                + "CourseId integer PRIMARY KEY AUTOINCREMENT,\n"
	                + "CourseName text NOT NULL,\n"
	                + "TeacherName text NOT NULL\n"
	                + ");";
		 Connection conn = null;
		 Statement state = null;
		 try { 
			 conn = DriverManager.getConnection(url);
			 state = conn.createStatement();
			 state.execute(sql);
		 } catch(SQLException e) {
	            System.out.println(e.getMessage());
		 } finally {
			 conn.close();
		 }
	}
	
	public static void createTeacherTable() throws SQLException {
		 String url = Url.getUrl();
		 String sql = "CREATE TABLE IF NOT EXISTS Teacher(\n"
	                + "TeacherId integer PRIMARY KEY AUTOINCREMENT,\n"
	                + "TeacherAge integer NOT NULL, \n"
	     		    + "TeacherName text NOT NULL,\n"
	                + "FOREIGN KEY (TeacherId) REFERENCES Course(CourseId)\n"
	                + ");"; 
		 Connection conn = null;
		 Statement state = null;
		 try { 
			 conn = DriverManager.getConnection(url);
			 state = conn.createStatement();
			 state.execute(sql);
		 } catch(SQLException e) {
	            System.out.println(e.getMessage());
		 } finally {
			 conn.close();
		 }
	}

	public void SimpleCourseInsert(int key , String courseName , String TeacherName) throws SQLException {
		 String url = Url.getUrl();
		 String sql = "INSERT INTO Course(CourseId ,CourseName ,TeacherName) VALUES(?,?,?)"; 
		 Connection conn = null;
		 PreparedStatement state = null;
		 try { 
			 conn = DriverManager.getConnection(url);
			 state = conn.prepareStatement(sql);
			 state.setInt(1, key);
			 state.setString(2, courseName);
			 state.setString(3, TeacherName);
			 state.executeUpdate();
		 } catch(SQLException e) {
	            System.out.println(e.getMessage());
		 } finally {
			 conn.close();
		 }
		
	}
	
	public void CourseInsert(  Course course) throws SQLException {
		 String url = Url.getUrl();
		 String sql = "INSERT INTO Course(CourseId ,CourseName ,TeacherName) VALUES(?,?,?)"; 
		 Connection conn = null;
		 PreparedStatement state = null;
		 try { 
			 conn = DriverManager.getConnection(url);
			 state = conn.prepareStatement(sql);
			 state.setString(2, course.getName());
			 state.setString(3, course.getTeacher());
			 state.executeUpdate();
		 } catch(SQLException e) {
	            System.out.println(e.getMessage());
		 } finally {
			 conn.close();
		 }
	}

	public void TeacherInsert(Teacher teacher) throws SQLException {
		 String url = Url.getUrl();
		 String sql = "INSERT INTO Teacher(TeacherId ,TeacherAge ,TeacherName) VALUES(?,?,?)"; 
		 Connection conn = null;
		 PreparedStatement state = null;
		 try { 
			 conn = DriverManager.getConnection(url);
			 state = conn.prepareStatement(sql);
			 state.setInt(2, teacher.getAge());
			 state.setString(3, teacher.getName());
			 state.executeUpdate();
		 } catch(SQLException e) {
	            System.out.println(e.getMessage());
		 } finally {
			 conn.close();
		 }
	}

	public void StudentInsert(Student student) throws SQLException {
		 String url = Url.getUrl();
		 String sql = "INSERT INTO Student(StudentId ,Studentname ,StudentAge,) VALUES(?,?,?)"; 
		 Connection conn = null;
		 PreparedStatement state = null;
		 try { 
			 conn = DriverManager.getConnection(url);
			 state = conn.prepareStatement(sql);
			 state.setString(2, student.getName());
			 state.setInt(3, student.age());
			 state.executeUpdate();
		 } catch(SQLException e) {
	            System.out.println(e.getMessage());
		 } finally {
			 conn.close();
		 }
	}

	
}
	
