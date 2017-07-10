package model;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

public class Student extends Person {

	public Student() {
		}
	
	private ArrayList<Course> course;
	
	public ArrayList<Course> getCourse() {
		return course;
	}
	
	
	public void setCourse(ArrayList<Course> course) {
		this.course = course;
	}
					
	public int age() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void toing() {
		 for(Course array : getCourse()) {
		    System.out.println(array);
		 }
	}
	
}
