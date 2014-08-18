package com.cnqaos.hibernate.pojo;

/**
 * SubjectTeacher entity. @author MyEclipse Persistence Tools
 */

public class SubjectTeacher implements java.io.Serializable {

	// Fields

	private SubjectTeacherId id;
	private Subject subject;
	private UserMaster userMaster;

	// Constructors

	/** default constructor */
	public SubjectTeacher() {
	}

	/** full constructor */
	public SubjectTeacher(SubjectTeacherId id, Subject subject,
			UserMaster userMaster) {
		this.id = id;
		this.subject = subject;
		this.userMaster = userMaster;
	}

	// Property accessors

	public SubjectTeacherId getId() {
		return this.id;
	}

	public void setId(SubjectTeacherId id) {
		this.id = id;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public UserMaster getUserMaster() {
		return this.userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

}