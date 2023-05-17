package com.hibernate_mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.*;

@Entity
public class Professor {
	@Id
	private int professorId;
	private String professorName;
	private String professorLocation;
	
	@ManyToMany
	@JoinTable(
			name="professor_courses",
			joinColumns= {@JoinColumn(name="professorId")},
					inverseJoinColumns={@JoinColumn(name="courseId")}
			
			)
	private List<Courses> crs;

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public String getProfessorLocation() {
		return professorLocation;
	}

	public void setProfessorLocation(String professorLocation) {
		this.professorLocation = professorLocation;
	}

	public List<Courses> getCrs() {
		return crs;
	}

	public void setCrs(List<Courses> crs) {
		this.crs = crs;
	}

	@Override
	public String toString() {
		return "Professor [professorId=" + professorId + ", professorName=" + professorName + ", professorLocation="
				+ professorLocation + ", crs=" + crs + "]";
	}
	
	

}