import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.*;
import Database.*;

public class School {
	
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
		TableAction Actions = new TableAction();
		
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
		mathExam.setResualt(19);
		mathExam.setStudent(Taha);
		mathExam.setTeacher(brayan);
		mathExam.Strings();
		
		rep.CreateDatabase("tahaDataBase.db");
		tables.createCourceTable();
		tables.createTeacherTable();
		tables.createStudentTable();
		Actions.TeacherInsert(brayan);
	}

}
