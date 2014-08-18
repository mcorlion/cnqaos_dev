package com.cnqaos.hibernate.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * TrainingType entity. @author MyEclipse Persistence Tools
 */

public class TrainingType implements java.io.Serializable {

	// Fields

	private Integer trainingTypeIdPk;
	private String trainingTypeName;
	private String description;
	private Set trainings = new HashSet(0);

	// Constructors

	/** default constructor */
	public TrainingType() {
	}

	/** minimal constructor */
	public TrainingType(String trainingTypeName) {
		this.trainingTypeName = trainingTypeName;
	}

	/** full constructor */
	public TrainingType(String trainingTypeName, String description,
			Set trainings) {
		this.trainingTypeName = trainingTypeName;
		this.description = description;
		this.trainings = trainings;
	}

	// Property accessors

	public Integer getTrainingTypeIdPk() {
		return this.trainingTypeIdPk;
	}

	public void setTrainingTypeIdPk(Integer trainingTypeIdPk) {
		this.trainingTypeIdPk = trainingTypeIdPk;
	}

	public String getTrainingTypeName() {
		return this.trainingTypeName;
	}

	public void setTrainingTypeName(String trainingTypeName) {
		this.trainingTypeName = trainingTypeName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getTrainings() {
		return this.trainings;
	}

	public void setTrainings(Set trainings) {
		this.trainings = trainings;
	}

}