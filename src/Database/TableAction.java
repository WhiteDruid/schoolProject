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
	                + "Studentname text not null ,\n"
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
	                + "StudentNames text , \n"
	                + "CourseId integer, \n"
	                + "FOREIGN KEY (CourseId) REFERENCES Student(CourseId)\n"
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
	
	public static void createWiringTable() throws SQLException {
		 String url = Url.getUrl();
		 String sql = "CREATE TABLE IF NOT EXISTS Wiring(\n"
	                + "WiringId integer PRIMARY KEY AUTOINCREMENT,\n"
	                + "teacherId integer NOT NULL, \n"
	     		    + "courseId text NOT NULL,\n"
	                + "studentId text NOT NULL , \n"
	                + "FOREIGN KEY (CourseId) REFERENCES Course(CourseId)\n"
	                + "FOREIGN KEY (studentId) REFERENCES Student(StudentId)\n"
	                + "FOREIGN KEY (teacherId) REFERENCES Teacher(TeacherId)\n"
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
	
	public void CourseInsert(String CourseName , String TeacherName) throws SQLException {
		 String url = Url.getUrl();
		 String sql = "INSERT INTO Course(CourseId ,CourseName ,TeacherName) VALUES(?,?,?)"; 
		 Connection conn = null;
		 PreparedStatement state = null;
		 try { 
			 conn = DriverManager.getConnection(url);
			 state = conn.prepareStatement(sql );
			 state.setString(2, CourseName.toLowerCase());
			 state.setString(3, TeacherName.toLowerCase());
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
	
	public void TeacherInsert(String teacherName , int TeacherAge) throws SQLException {
		 String url = Url.getUrl();
		 String sql = "INSERT INTO Teacher(TeacherId ,TeacherAge ,TeacherName) VALUES(?,?,?)"; 
		 Connection conn = null;
		 PreparedStatement state = null;
		 try { 
			 conn = DriverManager.getConnection(url);
			 state = conn.prepareStatement(sql);
			 state.setInt(2, TeacherAge);
			 state.setString(3, teacherName.toLowerCase());
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

	public void StudentInsert(String teacherName , int TeacherAge) throws SQLException {
		 String url = Url.getUrl();
		 String sql = "INSERT INTO Student(StudentId ,Studentname ,StudentAge) VALUES(?,?,?)"; 
		 Connection conn = null;
		 PreparedStatement state = null;
		 try { 
			 conn = DriverManager.getConnection(url);
			 state = conn.prepareStatement(sql);
			 state.setString(2, teacherName.toLowerCase());
			 state.setInt(3, TeacherAge);
			 state.executeUpdate();
		 } catch(SQLException e) {
	            System.out.println(e.getMessage());
		 } finally {
			 conn.close();
		 }
	}
	
	public void wiringInsert(int studentId  , int teacherId , int CourseId) throws SQLException {
		 String url = Url.getUrl();
		 String sql = "INSERT INTO Wiring( WiringId ,  StudentId ,teacherId ,CourseId) VALUES(?,?,?,?)"; 
		 Connection conn = null;
		 PreparedStatement state = null;
		 try { 
			 conn = DriverManager.getConnection(url);
			 state = conn.prepareStatement(sql);
			 state.setInt(2 , studentId);
			 state.setInt(3, teacherId);
			 state.setInt(4, CourseId);
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
	
	public static void deletFromWiringTeacher(int where) throws SQLException {
		String url = Url.getUrl();
		String sql = "delete  " + "from Wiring where TeacherId = " + where + ";";
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

	public static void deletFromWiringStudent(int where) throws SQLException {
		String url = Url.getUrl();
		String sql = "delete  " + "from Wiring where StudentId = " + where + ";";
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

	public static void deletFromWiringCourse(int where) throws SQLException {
		String url = Url.getUrl();
		String sql = "delete  " + "from Wiring where CourseId = " + where + ";";
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

	public static void deletFromList(String ListName , String Column ,int where) throws SQLException {
		String url = Url.getUrl();
		String sql = "delete " + "from " + ListName + " where " + Column + "Id= " + where + ";";
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

	
	public static void update(String tableName ,String column , int where) throws SQLException {
		String url = Url.getUrl();
		String sql = "UPDATE " + tableName  + " SET " + column + " where " + tableName+"Id = " + where + ";";
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
	
	public static void updateTeacher(String column , int where) throws SQLException {
		String url = Url.getUrl();
		String sql = "INSERT INTO Teacher(StudentNames) VALUES(?,?,?) where teacherId =" + where + ";";
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

	public void wiringInsert(String studentId, int teacherId, int courseId) throws SQLException {
		 String url = Url.getUrl();
		 String sql = "INSERT INTO Wiring( WiringId ,  StudentId ,teacherId ,CourseId) VALUES(?,?,?,?)"; 
		 Connection conn = null;
		 PreparedStatement state = null;
		 try { 
			 conn = DriverManager.getConnection(url);
			 state = conn.prepareStatement(sql);
			 state.setString(2 , studentId);
			 state.setInt(3, teacherId);
			 state.setInt(4, courseId);
			 state.executeUpdate();
		 } catch(SQLException e) {
	            System.out.println(e.getMessage());
		 } finally {
			 conn.close();
		 }		
	}

	
}
	
