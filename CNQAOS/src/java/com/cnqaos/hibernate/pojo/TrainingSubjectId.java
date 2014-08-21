package com.cnqaos.hibernate.pojo;

/**
 * TrainingSubjectId entity. @author MyEclipse Persistence Tools
 */

public class TrainingSubjectId implements java.io.Serializable {

	// Fields

	private Integer trainingIdFk;
	private Integer subjectIdFk;
	private String description;

	// Constructors

	/** default constructor */
	public TrainingSubjectId() {
	}

	/** minimal constructor */
	public TrainingSubjectId(Integer trainingIdFk, Integer subjectIdFk) {
		this.trainingIdFk = trainingIdFk;
		this.subjectIdFk = subjectIdFk;
	}

	/** full constructor */
	public TrainingSubjectId(Integer trainingIdFk, Integer subjectIdFk,
			String description) {
		this.trainingIdFk = trainingIdFk;
		this.subjectIdFk = subjectIdFk;
		this.description = description;
	}

	// Property accessors

	public Integer getTrainingIdFk() {
		return this.trainingIdFk;
	}

	public void setTrainingIdFk(Integer trainingIdFk) {
		this.trainingIdFk = trainingIdFk;
	}

	public Integer getSubjectIdFk() {
		return this.subjectIdFk;
	}

	public void setSubjectIdFk(Integer subjectIdFk) {
		this.subjectIdFk = subjectIdFk;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TrainingSubjectId))
			return false;
		TrainingSubjectId castOther = (TrainingSubjectId) other;

		return ((this.getTrainingIdFk() == castOther.getTrainingIdFk()) || (this
				.getTrainingIdFk() != null
				&& castOther.getTrainingIdFk() != null && this
				.getTrainingIdFk().equals(castOther.getTrainingIdFk())))
				&& ((this.getSubjectIdFk() == castOther.getSubjectIdFk()) || (this
						.getSubjectIdFk() != null
						&& castOther.getSubjectIdFk() != null && this
						.getSubjectIdFk().equals(castOther.getSubjectIdFk())))
				&& ((this.getDescription() == castOther.getDescription()) || (this
						.getDescription() != null
						&& castOther.getDescription() != null && this
						.getDescription().equals(castOther.getDescription())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTrainingIdFk() == null ? 0 : this.getTrainingIdFk()
						.hashCode());
		result = 37
				* result
				+ (getSubjectIdFk() == null ? 0 : this.getSubjectIdFk()
						.hashCode());
		result = 37
				* result
				+ (getDescription() == null ? 0 : this.getDescription()
						.hashCode());
		return result;
	}

}