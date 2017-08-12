package model;

public class studentJson {

	private int StudentId;
	
	private String Studentname;
	
	private int StudentAge;

	public int getId() {
		return StudentId;
	}

	public void setId(int id) {
		this.StudentId = id;
	}

	public String getName() {
		return Studentname;
	}

	public void setName(String name) {
		this.Studentname = name;
	}

	public int getAge() {
		return StudentAge;
	}

	public void setAge(int age) {
		this.StudentAge = age;
	}
	
    public String toString() {
        return String.format("id:%d,name:%s,age:%d", StudentId, Studentname, StudentAge);
    }
	
}
