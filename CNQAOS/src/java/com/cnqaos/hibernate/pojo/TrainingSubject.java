package com.cnqaos.hibernate.pojo;

/**
 * TrainingSubject entity. @author MyEclipse Persistence Tools
 */

public class TrainingSubject implements java.io.Serializable {

	// Fields

	private TrainingSubjectId id;
	private Subject subject;
	private Training training;
	private String description;
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
	
	/** full constructor */
	public TrainingSubject(TrainingSubjectId id, Subject subject,
			Training training,String description) {
		this.id = id;
		this.subject = subject;
		this.training = training;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}