package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Select {
	
	private static String url;

	public static Connection connection() {
		String url = Url.getUrl();
		Connection conn = null ;
		try {
			conn = DriverManager.getConnection(url);
		} catch(SQLException e) {
			e.getSQLState();
		}
		return conn;
	}
	
	
	public static void selectAllStudent() throws SQLException {
		url = Url.getUrl();
		String sql = "Select * "+ " From " + "Student" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
		 System.out.println(rs.getString("StudentId") + "\t"  +
						rs.getString("StudentName" ) + " \t" +
						rs.getInt("StudentAge"));
			}
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 } finally {
		 conn.close();
	 }
  }
	
	public List<String> selcetStudentAge() {
		url = Url.getUrl();
		String sql = "Select StudentAge "+ " From " + "Student" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<String> strings = new ArrayList<String>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			while(rs.next()) {
				strings.add(rs.getString("StudentAge"));
				strings.add("\n");
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}

	public List<String> selcetTeacherAge() {
		url = Url.getUrl();
		String sql = "Select TeacherAge "+ " From " + "Teacher" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<String> strings = new ArrayList<String>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			while(rs.next()) {
				strings.add(rs.getString("TeacherAge"));
				strings.add("\n");
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}
	
	public List<String> selcetTeacherName() {
		url = Url.getUrl();
		String sql = "Select TeacherName "+ " From " + "Teacher" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<String> strings = new ArrayList<String>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			while(rs.next()) {
				strings.add(rs.getString("TeacherName"));
				strings.add("\n");
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}
	
	public List<String> selcetTeacherId() {
		url = Url.getUrl();
		String sql = "Select TeacherId "+ " From " + "Teacher" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<String> strings = new ArrayList<String>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			while(rs.next()) {
				strings.add(rs.getString("TeacherId"));
				strings.add("\n");
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}
	
	public List<String> selcetStudentName() {
		url = Url.getUrl();
		String sql = "Select StudentName "+ " From " + "Student" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<String> strings = new ArrayList<String>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			while(rs.next()) {
				strings.add(rs.getString("StudentName"));
				strings.add("\n");
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}

	
	public List<String> selcetStudentId() {
		url = Url.getUrl();
		String sql = "Select StudentId "+ " From " + "Student" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<String> strings = new ArrayList<String>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			while(rs.next()) {
				strings.add(rs.getString("StudentId"));
				strings.add("\n");
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}
	
	public static void selectAllTeacher() throws SQLException {
		 url = Url.getUrl();
		String sql = "Select * "+ " From " + "Teacher" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("TeacherId") + "\t"  +
						rs.getString("TeacherName" ) + " \t" +
						rs.getInt("TeacherAge"));
			}
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 } finally {
		 conn.close();
	 }
	}

	public static void selectAllCourse() throws SQLException {
		 url = Url.getUrl();
		String sql = "Select * "+ " From " + "Course" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("CourseId") + "\t"  +
						rs.getString("CourseName" ) + " \t" 
		);
					}
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 } finally {
		 conn.close();
	 }
	}
	
}