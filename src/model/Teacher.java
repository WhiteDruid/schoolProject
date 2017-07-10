package model;

public class Teacher extends Person {
	
	Course course;

	public String getCourse() {
		return course.getName();
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
