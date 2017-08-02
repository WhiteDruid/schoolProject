package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import GUI.ui;

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
	
	public static List<String> selcetStudentAge() {
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
			rs.rowUpdated();
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
	
	public static List<String> selcetWiringId() {
		url = Url.getUrl();
		String sql = "Select wiringId "+ " From " + "Wiring" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<String> strings = new ArrayList<String>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			rs.rowUpdated();
			while(rs.next()) {
				strings.add(rs.getString("wiringId"));
				strings.add("\n");
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}

	public static List<String> selcetTeacherIdWiring() {
		url = Url.getUrl();
		String sql = "Select teacherId "+ " From " + "Wiring" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<String> strings = new ArrayList<String>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			rs.rowUpdated();
			while(rs.next()) {
				strings.add(rs.getString("teacherId"));
				strings.add("\n");
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}
	
	public static List<String> selcetStudentIdWiring() {
		url = Url.getUrl();
		String sql = "Select studentId "+ " From " + "Wiring" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<String> strings = new ArrayList<String>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			rs.rowUpdated();
			while(rs.next()) {
				strings.add(rs.getString("studentId"));
				strings.add("\n");
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}

	public static List<String> selcetCourseIdWiring() {
		url = Url.getUrl();
		String sql = "Select courseId "+ " From " + "Wiring" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<String> strings = new ArrayList<String>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			rs.rowUpdated();
			while(rs.next()) {
				strings.add(rs.getString("courseId"));
				strings.add("\n");
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}

	

	public static List<String> selcetTeacherAge() {
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
	
	public static ArrayList<Integer> selcetCourseIdArray() {
		url = Url.getUrl();
		String sql = "Select  courseId "+ " From " + "Course" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		ArrayList<Integer> strings = new ArrayList<Integer>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			while(rs.next()) {
				strings.add(rs.getInt("courseId"));
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}

	
	public static ArrayList<Integer> selcetTeacherIdArray() {
		url = Url.getUrl();
		String sql = "Select  teacherId "+ " From " + "Teacher" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		ArrayList<Integer> strings = new ArrayList<Integer>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			while(rs.next()) {
				strings.add(rs.getInt("teacherId"));
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}
	

	
	public static ArrayList<Integer> selcetTeacherIdArrayWiring() {
		url = Url.getUrl();
		String sql = "Select  teacherId "+ " From " + "Wiring" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		ArrayList<Integer> strings = new ArrayList<Integer>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			while(rs.next()) {
				strings.add(rs.getInt("teacherId"));
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}
	
	public static ArrayList<Integer> selcetStudentIdArray() {
		url = Url.getUrl();
		String sql = "Select  StudentId "+ " From " + "Student" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		ArrayList<Integer> strings = new ArrayList<Integer>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			while(rs.next()) {
				strings.add(rs.getInt("studentId"));
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}


	
	public static List<String> selcetteacherName() {
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
	
	public static List<String> selcetTeacherId() {
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
	
	public static List<String> selcetStudentName() {
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

	
	public static List<String> selcetStudentId() {
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
	
	public static List<String> selcetCourseId() {
		url = Url.getUrl();
		String sql = "Select CourseId "+ " From " + "Course" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<String> strings = new ArrayList<String>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			while(rs.next()) {
				strings.add(rs.getString("CourseId"));
				strings.add("\n");
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}
	
	public static List<String> selcetCourseName() {
		url = Url.getUrl();
		String sql = "Select CourseName "+ " From " + "Course" +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<String> strings = new ArrayList<String>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			while(rs.next()) {
				strings.add(rs.getString("CourseName"));
				strings.add("\n");
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}

	
	public static List<String> selcetCourseTeacher() {
		url = Url.getUrl();
		String sql = "Select TeacherName "+ " From " + "Course" +  ";";
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
	
	public static List<String> selcetWiringTeacherInnerJoin() {
		url = Url.getUrl();
		String sql = "Select teacherName "+ " From " + "  Teacher INNER JOIN Wiring On Teacher.teacherId = Wiring.teacherId  " +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<String> strings = new ArrayList<String>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			while(rs.next()) {
				strings.add(rs.getString("teacherName"));
				strings.add("\n");
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}
	
	public static List<String> selcetWiringStudentInnerJoin() {
		url = Url.getUrl();
		String sql = "Select studentName "+ " From " + " Student INNER JOIN Wiring On student.studentId = Wiring.studentId   " +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<String> strings = new ArrayList<String>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			while(rs.next()) {
				strings.add(rs.getString("studentName"));
				strings.add("\n");
			}
			return strings;
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 }
		return null ;
	}

	public static List<String> selcetWiringCourseInnerJoin() {
		url = Url.getUrl();
		String sql = "Select CourseName "+ " From " + "Course INNER JOIN Wiring On Course.courseId  = Wiring.courseId  " +  ";";
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<String> strings = new ArrayList<String>();
		try { 
			conn =  connection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			while(rs.next()) {
				strings.add(rs.getString("CourseName"));
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