package com.cnqaos.hibernate.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Training entity. @author MyEclipse Persistence Tools
 */

public class Training implements java.io.Serializable {

	// Fields

	private Integer trainingIdPk;
	private TrainingType trainingType;
	private String trainingName;
	private String description;
	private Set trainingSubjects = new HashSet(0);
	private Set centreTrainings = new HashSet(0);

	// Constructors

	/** default constructor */
	public Training() {
	}

	/** minimal constructor */
	public Training(TrainingType trainingType, String trainingName) {
		this.trainingType = trainingType;
		this.trainingName = trainingName;
	}

	/** full constructor */
	public Training(TrainingType trainingType, String trainingName,
			String description, Set trainingSubjects, Set centreTrainings) {
		this.trainingType = trainingType;
		this.trainingName = trainingName;
		this.description = description;
		this.trainingSubjects = trainingSubjects;
		this.centreTrainings = centreTrainings;
	}

	// Property accessors

	public Integer getTrainingIdPk() {
		return this.trainingIdPk;
	}

	public void setTrainingIdPk(Integer trainingIdPk) {
		this.trainingIdPk = trainingIdPk;
	}

	public TrainingType getTrainingType() {
		return this.trainingType;
	}

	public void setTrainingType(TrainingType trainingType) {
		this.trainingType = trainingType;
	}

	public String getTrainingName() {
		return this.trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getTrainingSubjects() {
		return this.trainingSubjects;
	}

	public void setTrainingSubjects(Set trainingSubjects) {
		this.trainingSubjects = trainingSubjects;
	}

	public Set getCentreTrainings() {
		return this.centreTrainings;
	}

	public void setCentreTrainings(Set centreTrainings) {
		this.centreTrainings = centreTrainings;
	}

}