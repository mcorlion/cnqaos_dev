package com.cnqaos.hibernate.pojo;

/**
 * CenterTraining entity. @author MyEclipse Persistence Tools
 */

public class CenterTraining implements java.io.Serializable {

	// Fields

	private CenterTrainingId id;
	private Training training;
	private Center center;

	// Constructors

	/** default constructor */
	public CenterTraining() {
	}

	/** full constructor */
	public CenterTraining(CenterTrainingId id, Training training, Center center) {
		this.id = id;
		this.training = training;
		this.center = center;
	}

	// Property accessors

	public CenterTrainingId getId() {
		return this.id;
	}

	public void setId(CenterTrainingId id) {
		this.id = id;
	}

	public Training getTraining() {
		return this.training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public Center getCenter() {
		return this.center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

}