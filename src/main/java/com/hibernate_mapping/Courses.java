package com.hibernate_mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.*;

@Entity
public class Courses {
	
	@Id
	private int courseId;
	private String courseName;
	
	@ManyToMany
	
	private List<Professor> prof;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Professor> getProf() {
		return prof;
	}

	public void setProf(List<Professor> prof) {
		this.prof = prof;
	}

	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + ", prof=" + prof + "]";
	}
	

}