package OrmLite;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Student")
public class StudentOrmLite {
	
	private static final String STUDENT_NAME = "StudentName";
	
	private static final String STUDENT_LAST_NAEM = "StudentLastName";

	private static final String STUDENT_LESSON = "StudentLesson";
	
	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField(columnName = STUDENT_NAME , canBeNull = false , uniqueCombo = true)
	private String name;
	
	@DatabaseField(columnName = STUDENT_LAST_NAEM , canBeNull = false , uniqueCombo = true)
	private String lastName;
	
	@DatabaseField(columnName = STUDENT_LESSON , canBeNull = false)
	private String lesson;

	@ForeignCollectionField()
	private ForeignCollection<TeacherOrmLite> teachers;
	
	public ForeignCollection<TeacherOrmLite> getTeachers() {
		return teachers;
	}

	public StudentOrmLite() {
		
	}
	
	public StudentOrmLite( String name , String lastName , String lesson){
				
		this.lastName = lastName;

		this.name = name;
		
		this.lesson = lesson;

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	public static String getStudentName() {
		return STUDENT_NAME;
	}

	public static String getStudentLastNaem() {
		return STUDENT_LAST_NAEM;
	}

	public static String getStudentLesson() {
		return STUDENT_LESSON;
	}
	
}
