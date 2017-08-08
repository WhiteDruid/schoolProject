
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import model.*;
import Database.*;

public class School {
	
	private Dao<TeacherOrmLite , Integer> teacherDao;

	String ormUrl = "jdbc:sqlite:C:/sqlite/db/ormLiteDataBase.db";

	public static void main(String[] args) throws SQLException {
		
		ArrayList<Course> TahaCourse = new ArrayList<Course>();
		Teacher brayan = new Teacher();
		Course math = new Course();
		Student Taha = new Student();
		Course olom = new Course();
		Exam mathExam = new Exam();
		Date date = new Date();
		Repository rep = new Repository();
		Teacher henry = new Teacher();
		TableAction tables = new TableAction();
		Select select = new Select();
		
		math.setName("math");
		math.setTeacher(brayan);
		
		olom.setName("olom");
		olom.setTeacher(henry);
		
		brayan.setAge(20);
		brayan.setCourse(math);
		brayan.setName("brayan");
		
		henry.setAge(34);
		henry.setCourse(olom);
		henry.setName("henry");

		TahaCourse.add(math);
		TahaCourse.add(olom);

		Taha.setCourse(TahaCourse);
		Taha.setAge(14);
		Taha.setName("taha");
		Taha.toing();
		
		mathExam.setCourse(math);
		mathExam.setDate(date);
		mathExam.setScore(19);
		mathExam.setStudent(Taha);
		mathExam.Strings();
		
		rep.CreateDatabase();
		tables.createCourceTable();
		tables.createTeacherTable();
		tables.createStudentTable();
		tables.createWiringTable();

		new School().doMain(args);
		
	}
	
	private void setupDatabase(ConnectionSource connectionSource ) throws SQLException{
		
		teacherDao = DaoManager.createDao(connectionSource, TeacherOrmLite.class);
		
		TableUtils.createTable(connectionSource, TeacherOrmLite.class);
		
	}
	
	public void doMain(String[] args) throws SQLException{
		
		ConnectionSource conn = null ;
		
		try { 
			conn = new JdbcConnectionSource(ormUrl);
			
			setupDatabase(conn);
			
			readAndWriteDate();
			
		} finally {
			
		}
		
	}

	private void readAndWriteDate() throws SQLException{
		TeacherOrmLite ali = new TeacherOrmLite( 9 , "ali" , "hasani" );
		int aliId = ali.getId();
		
		teacherDao.create(ali);
		VerifyDb(aliId);
	
		List<TeacherOrmLite> teacherList = teacherDao.queryForAll();
		
		QueryBuilder<TeacherOrmLite , Integer> query = teacherDao.queryBuilder();
		query.where().like(ali.First_Name_Column_Teacher, "ali");
		
		teacherList = teacherDao.query(query.prepare());
	}
	
	private void VerifyDb(int id) throws SQLException{
		TeacherOrmLite teacher1 = teacherDao.queryForId(id);
		
		if(teacher1 == null){
			System.out.println("oh oh this id dosent exits");
		}
	}
	
}
