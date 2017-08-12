
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import model.*;
import Database.*;
import OrmLite.TeacherOrmLite;

public class School {
	
	private Dao<TeacherOrmLite , Integer> teacherDao;

	String ormUrl = "jdbc:sqlite:C:/sqlite/db/ormLiteDataBase.db";
	
	static TableAction tables = new TableAction();
	
	static Select select = new Select();
		
	public static String convertToJson() {
		String json = null;
		try {
			json = "{ \n" + '"' + tables.Student + '"' + ": " + "[ \n" + select.str().toString().replace("[" ,  "").replace("]" , "") + "] \n" + "}";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return json.toString();
	}
	
	public static ArrayList<String> convertToJsonArray() {
		ArrayList<String> json = null;
		try {	
			json.add("{ \n" + '"' + tables.Student + '"' + ": " + "[ \n" + select.str().toString().replace("[" ,  "").replace("]" , "") + "] \n" + "}");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return json;
	}

	
	static Gson gson = new Gson();

	
	public static ArrayList<String> forGson(){
		ArrayList<String> array = new ArrayList<String>();
		ArrayList<String> array2 = new ArrayList<String>();
		try {
			for(int i = 0 ;  i < select.selectAllStudentJson().size() ; i++){
			array2.add(select.selectAllStudentJson().get(i).toString().replace("{ \n\"Student\": [ \n{ ", "{").replace(" } ] \n}", "}"));
			}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0 ; i < array2.size() ; i++ ){
			array.add(array2.get(i));
		}
		return array;
	}

	
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
				
		rep.CreateDatabase();
		tables.createCourceTable();
		tables.createTeacherTable();
		tables.createStudentTable();
		tables.createWiringTable();
		
		System.out.println(forGson().get(0).toString());
		String jsonInString = "{\"StudentId\":\"1\" , \"Studentname\":\"taha\" ,  \"StudentAge\":\"14\"}";
		studentJson user= gson.fromJson(jsonInString, studentJson.class);		
		System.out.println(gson.toJson(user));
		for(int i = 0 ; i < forGson().size() ; i++){
		String str = forGson().get(i);
		studentJson taha= gson.fromJson(str , studentJson.class);		
		System.out.println(gson.toJson(taha));
		}
	}
	
}
