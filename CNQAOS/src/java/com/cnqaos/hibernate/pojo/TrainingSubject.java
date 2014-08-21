package com.cnqaos.hibernate.pojo;

/**
 * TrainingSubject entity. @author MyEclipse Persistence Tools
 */

public class TrainingSubject implements java.io.Serializable {

	// Fields

	private TrainingSubjectId id;
	private Subject subject;
	private Training training;

	// Constructors

	/** default constructor */
	public TrainingSubject() {
	}

	/** full constructor */
	public TrainingSubject(TrainingSubjectId id, Subject subject,
			Training training) {
		this.id = id;
		this.subject = subject;
		this.training = training;
	}

	// Property accessors

	public TrainingSubjectId getId() {
		return this.id;
	}

	public void setId(TrainingSubjectId id) {
		this.id = id;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Training getTraining() {
		return this.training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

}