package model;

import java.util.Date;

public class Exam {

	private Date date;
	
	private Teacher teacher;
	
	private Student student;
	
	private float resualt;
	
	private Course course;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTeacher() {
		return teacher.getName();
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public float getResualt() {
		return resualt;
	}

	public void setResualt(float resualt) {
		this.resualt = resualt;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void Strings() { 
		System.out.print(getResualt() + " " + getCourse().getName() + " " + getTeacher() + " " + getStudent().getName() + " " +
				getDate().toString());
	}
	
}
