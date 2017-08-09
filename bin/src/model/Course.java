package model;

public class Course {

	private String name;

	private Teacher teacher;
	
	public String getTeacher() {
		return teacher.getName();
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
