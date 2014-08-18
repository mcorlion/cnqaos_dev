package com.cnqaos.hibernate.pojo;

/**
 * CenterTraining entity. @author MyEclipse Persistence Tools
 */

public class CenterTraining implements java.io.Serializable {

	// Fields

	private CenterTrainingId id;
        private Center center;
        private Training training;
        private String description;

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
	

	// Constructors

	/** default constructor */
	public CenterTraining() {
	}

	/** full constructor */
	public CenterTraining(CenterTrainingId id, Center center, Training training, String description) {
		this.id = id;
                this.center = center;
                this.training = training;
		this.description = description;
	}

	// Property accessors

	public CenterTrainingId getId() {
		return this.id;
	}

	public void setId(CenterTrainingId id) {
		this.id = id;
	}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}