package model;

import java.util.Date;

public class Exam {

	private Date date;
		
	private Student student;
	
	private float score;
	
	private Course course;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void Strings() { 
		System.out.print(getScore()+ " " + getCourse().getName() + " " + getStudent().getName() + " " +
				getDate().toString());
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
}
