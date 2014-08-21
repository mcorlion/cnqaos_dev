package com.cnqaos.hibernate.pojo;

/**
 * CenterTrainingId entity. @author MyEclipse Persistence Tools
 */

public class CenterTrainingId implements java.io.Serializable {

	// Fields

	private Integer centerIdFk;
	private Integer trainingIdFk;
	private String description;

	// Constructors

	/** default constructor */
	public CenterTrainingId() {
	}

	/** minimal constructor */
	public CenterTrainingId(Integer centerIdFk, Integer trainingIdFk) {
		this.centerIdFk = centerIdFk;
		this.trainingIdFk = trainingIdFk;
	}

	/** full constructor */
	public CenterTrainingId(Integer centerIdFk, Integer trainingIdFk,
			String description) {
		this.centerIdFk = centerIdFk;
		this.trainingIdFk = trainingIdFk;
		this.description = description;
	}

	// Property accessors

	public Integer getCenterIdFk() {
		return this.centerIdFk;
	}

	public void setCenterIdFk(Integer centerIdFk) {
		this.centerIdFk = centerIdFk;
	}

	public Integer getTrainingIdFk() {
		return this.trainingIdFk;
	}

	public void setTrainingIdFk(Integer trainingIdFk) {
		this.trainingIdFk = trainingIdFk;
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
		if (!(other instanceof CenterTrainingId))
			return false;
		CenterTrainingId castOther = (CenterTrainingId) other;

		return ((this.getCenterIdFk() == castOther.getCenterIdFk()) || (this
				.getCenterIdFk() != null && castOther.getCenterIdFk() != null && this
				.getCenterIdFk().equals(castOther.getCenterIdFk())))
				&& ((this.getTrainingIdFk() == castOther.getTrainingIdFk()) || (this
						.getTrainingIdFk() != null
						&& castOther.getTrainingIdFk() != null && this
						.getTrainingIdFk().equals(castOther.getTrainingIdFk())))
				&& ((this.getDescription() == castOther.getDescription()) || (this
						.getDescription() != null
						&& castOther.getDescription() != null && this
						.getDescription().equals(castOther.getDescription())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCenterIdFk() == null ? 0 : this.getCenterIdFk()
						.hashCode());
		result = 37
				* result
				+ (getTrainingIdFk() == null ? 0 : this.getTrainingIdFk()
						.hashCode());
		result = 37
				* result
				+ (getDescription() == null ? 0 : this.getDescription()
						.hashCode());
		return result;
	}

}