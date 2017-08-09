package OrmLite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName= "Teacher")
public class TeacherOrmLite {

	private static final String ACCOUNT_ID_FIELD_NAME = "AccountId";

	public final String First_Name_Column_Teacher = "firstName";
	
	public final String Last_Name_Column_Teacher = "lastName";
	
	public final String Teacher_Age = "Age";
	
	@DatabaseField(generatedId = true)
	private int Id;

	@DatabaseField(foreign = true, columnName = ACCOUNT_ID_FIELD_NAME , foreignAutoRefresh = true)
	private StudentOrmLite student;
	
	@DatabaseField(columnName = Teacher_Age , canBeNull = false)
	private int Age;
	
	@DatabaseField(columnName = Last_Name_Column_Teacher , canBeNull = false , uniqueCombo = true)
	private String lastName;

	@DatabaseField(columnName = First_Name_Column_Teacher , canBeNull = false, uniqueCombo = true)
	private String firstName;
	
	
	public TeacherOrmLite(){
		
	}
	
	public TeacherOrmLite(int age , String name , String lastName , StudentOrmLite student){
		this.Age = age;
		this.lastName = lastName;
		this.firstName = name;
		this.student = student;

	}
	
	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}

	public StudentOrmLite getStudent() {
		return student;
	}

	public void setStudent(StudentOrmLite student) {
		this.student = student;
	}

	public static String getAccountIdFieldName() {
		return ACCOUNT_ID_FIELD_NAME;
	}


	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		Age = age;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
