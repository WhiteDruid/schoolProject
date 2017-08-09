package OrmLite;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import OrmLite.TeacherOrmLite;


public class Main {
	
	private Dao<TeacherOrmLite , Integer> teacherDao;

	private Dao<StudentOrmLite , Integer> studentDao;
	
	String ormUrl = "jdbc:sqlite:C:/sqlite/db/ormLiteDataBase.db";

	public static void main(String[] args) throws SQLException {
		
		new Main().doMain(args);
		
	}
	
	private void setupDatabase(ConnectionSource connectionSource ) throws SQLException{
		
		teacherDao = DaoManager.createDao(connectionSource, TeacherOrmLite.class);
		
		studentDao = DaoManager.createDao(connectionSource, StudentOrmLite.class);
		

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
		
		StudentOrmLite taha = new StudentOrmLite("ali" , " taha" , "math");
		
		TeacherOrmLite ali = new TeacherOrmLite( 9 , "ali" , "hasani"  , taha );
		
		TeacherOrmLite keivan = new TeacherOrmLite( 18 , "keivan" , "hossein"  , taha );
	
		TeacherOrmLite ramim = new TeacherOrmLite( 19 , "ramim" , "hossein"  , taha );

		StudentOrmLite meh = new StudentOrmLite("meh " , " meh" , "math");

		TeacherOrmLite moh = new TeacherOrmLite( 100 , "moh" , "moh"  , meh );

		TeacherOrmLite search = teacherDao.queryForId(taha.getId());
		
		List<TeacherOrmLite> teacherList = teacherDao.queryForAll();
		teacherList.size();
		
		QueryBuilder<TeacherOrmLite , Integer> query = teacherDao.queryBuilder();
		query.where().like(ali.First_Name_Column_Teacher, "keivan");
		
		TeacherOrmLite teacher = teacherDao.queryForId(ramim.getId());
		
		teacherList = teacherDao.query(query.prepare());

				
	}
	
	private void VerifyDb(int id) throws SQLException{
		TeacherOrmLite teacher1 = teacherDao.queryForId(id);
		
		if(teacher1 == null){
			System.out.println("oh oh this id dosent exits");
		}
	}
	
}