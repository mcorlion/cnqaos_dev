package com.cnqaos.hibernate.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Subject entity. @author MyEclipse Persistence Tools
 */

public class Subject implements java.io.Serializable {

	// Fields

	private Integer subjectIdPk;
	private String subjectName;
	private Set trainingSubjects = new HashSet(0);
	private Set subjectTeachers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Subject() {
	}

	/** minimal constructor */
	public Subject(String subjectName) {
		this.subjectName = subjectName;
	}

	/** full constructor */
	public Subject(String subjectName, Set trainingSubjects, Set subjectTeachers) {
		this.subjectName = subjectName;
		this.trainingSubjects = trainingSubjects;
		this.subjectTeachers = subjectTeachers;
	}

	// Property accessors

	public Integer getSubjectIdPk() {
		return this.subjectIdPk;
	}

	public void setSubjectIdPk(Integer subjectIdPk) {
		this.subjectIdPk = subjectIdPk;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Set getTrainingSubjects() {
		return this.trainingSubjects;
	}

	public void setTrainingSubjects(Set trainingSubjects) {
		this.trainingSubjects = trainingSubjects;
	}

	public Set getSubjectTeachers() {
		return this.subjectTeachers;
	}

	public void setSubjectTeachers(Set subjectTeachers) {
		this.subjectTeachers = subjectTeachers;
	}

}