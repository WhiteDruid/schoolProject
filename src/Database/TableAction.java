package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	                + "CourseId integer, \n"
	                + "TeacherId integet , \n"
	                + "FOREIGN KEY (CourseId) REFERENCES Course(CourseId),\n"
	                + "FOREIGN KEY (TeacherId) REFERENCES Teacher(TeacherId)\n"
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
	
	public static void createExamTable() {
		String url = Url.getUrl();
		String sql = " Create Table If not Exists Exam(\n "
				+ "ExamId integer PRIMARY KEY AUTOINCREMENT,\n"
				+ "Date text NOT NULL , \n"
				+ "score REAL Not Null , \n"
				+ "CourseId integer, \n"
				+ "StudentId integer, \n"
				+ "FOREIGN KEY (CourseId) REFERENCES Course(CourseId),\n"
				+ "FOREIGN KEY (StudentId) REFERENCES Student(StudentId)\n"
				+ "); ";
	}
	
	public static void createCourceTable() throws SQLException {
		 String url = Url.getUrl();
		 String sql = "CREATE TABLE IF NOT EXISTS Course(\n"
	                + "CourseId integer PRIMARY KEY AUTOINCREMENT,\n"
	                + " CourseName text NOT NULL,\n"
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
	                + "CourseId integer, \n"
	                + "FOREIGN KEY (CourseId) REFERENCES Course(CourseId)\n"
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

	public static boolean isExist(String name) throws SQLException {
		 boolean ret=false;
		 String url = Url.getUrl();
		 String select = "Select CourseName from Course Where CourseName='" + name + "' LIMIT 1 ;";
		 Connection conn = null;
		 try { 
			 conn = DriverManager.getConnection(url);
			 Statement sta = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,
             ResultSet.CONCUR_READ_ONLY);
			 ResultSet rs = sta.executeQuery(select);
			 while(rs.next()){
				 String nameF=rs.getString("CourseName")	;
				 if(nameF.equals(name)){
					 ret=true;
					 break;
				 }
			 }
		 } catch(SQLException e) {
			 e.printStackTrace();
		 } finally {
			 conn.close();
	}
		 return ret;
}

	public void SimpleCourseInsert(int key , String courseName , String TeacherName) throws SQLException {
		 String url = Url.getUrl();
		 String sql = "INSERT INTO Course(CourseId ,CourseName ,TeacherName) VALUES(?,?,?)"; 
		 Connection conn = null;
		 PreparedStatement state = null;
		 PreparedStatement sta = null;
		 try { 
		 		conn = DriverManager.getConnection(url);
		 			if(isExist(courseName) == false){
			 		state = conn.prepareStatement(sql , ResultSet.TYPE_FORWARD_ONLY,
                     ResultSet.CONCUR_READ_ONLY);
					 state.setInt(1, key);
					 state.setString(2, courseName.toLowerCase());
					 state.setString(3, TeacherName);
					 state.executeUpdate();
					 }
			 else{
						 System.out.println("we cant do it.");
					 }
		 } catch(SQLException e) {
			 e.printStackTrace();
		 } finally {
			 conn.close();
		 }
	}
	
	public void CourseInsert(Course course) throws SQLException {
		 String url = Url.getUrl();
		 String sql = "INSERT INTO Course(CourseId ,CourseName ,TeacherName) VALUES(?,?,?)"; 
		 Connection conn = null;
		 PreparedStatement state = null;
		 try { 
			 conn = DriverManager.getConnection(url);
			 state = conn.prepareStatement(sql );
			 state.setString(2, course.getName());
			 state.setString(3, course.getTeacher().toLowerCase());
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
			 state.setString(3, teacher.getName().toLowerCase());
			 state.executeUpdate();
		 } catch(SQLException e) {
	            System.out.println(e.getMessage());
		 } finally {
			 conn.close();
		 }
	}

	public void StudentInsert(Student student) throws SQLException {
		 String url = Url.getUrl();
		 String sql = "INSERT INTO Student(StudentId ,Studentname ,StudentAge) VALUES(?,?,?)"; 
		 Connection conn = null;
		 PreparedStatement state = null;
		 try { 
			 conn = DriverManager.getConnection(url);
			 state = conn.prepareStatement(sql);
			 state.setString(2, student.getName().toLowerCase());
			 state.setInt(3, student.age());
			 state.executeUpdate();
		 } catch(SQLException e) {
	            System.out.println(e.getMessage());
		 } finally {
			 conn.close();
		 }
	}

	public static void deletFromCourse(String where) throws SQLException {
		String url = Url.getUrl();
		String sql = "delete " + "from Course where " + where + ";";
		Connection conn = null;
		Statement stat = null;
		try { 
			conn = DriverManager.getConnection(url);
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		}catch(SQLException e) {
            System.out.println(e.getMessage());
	 } finally {
		 conn.close();
	 }
	}

	public static void deletFromTeacher(String where) throws SQLException {
		String url = Url.getUrl();
		String sql = "delete " + "from Teacher where " + where + ";";
		Connection conn = null;
		Statement stat = null;
		try { 
			conn = DriverManager.getConnection(url);
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		}catch(SQLException e) {
            System.out.println(e.getMessage());
	 } finally {
		 conn.close();
	 }
	}

	public static void deletFromStudent(String where) throws SQLException {
		String url = Url.getUrl();
		String sql = "delete " + "from Student where " + where + ";";
		Connection conn = null;
		Statement stat = null;
		try { 
			conn = DriverManager.getConnection(url);
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		}catch(SQLException e) {
            System.out.println(e.getMessage());
	 } finally {
		 conn.close();
	 }
	}

	public static void update(String column ,String set,String where) throws SQLException {
		String url = Url.getUrl();
		String sql = "UPDATE "+ column + "\n SET " + set + "\n where " + where + ";";
		Connection conn = null;
		Statement stat = null;
		try { 
			conn = DriverManager.getConnection(url);
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		}catch(SQLException e) {
	        System.out.println(e.getMessage());
	 } finally {
		 conn.close();
	 }
	}
	
	
	
}
	
