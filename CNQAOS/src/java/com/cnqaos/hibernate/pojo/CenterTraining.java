package com.cnqaos.hibernate.pojo;

/**
 * CenterTraining entity. @author MyEclipse Persistence Tools
 */

public class CenterTraining implements java.io.Serializable {

	// Fields

	private CenterTrainingId id;
	private Training training;
	private Center center;
	private String description;
        
	// Constructors

	/** default constructor */
	public CenterTraining() {
	}

	/** full constructor */
	public CenterTraining(CenterTrainingId id, Training training, Center center,String description) {
		this.id = id;
		this.training = training;
		this.center = center;
                this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}