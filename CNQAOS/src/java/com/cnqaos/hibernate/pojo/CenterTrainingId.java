package com.cnqaos.hibernate.pojo;

/**
 * CenterTrainingId entity. @author MyEclipse Persistence Tools
 */

public class CenterTrainingId implements java.io.Serializable {

	// Fields

	private Integer centerIdFk;
	private Integer trainingIdFk;

	// Constructors

	/** default constructor */
	public CenterTrainingId() {
	}

	/** minimal constructor */
	public CenterTrainingId(Integer centerIdFk, Integer trainingIdFk) {
		this.centerIdFk = centerIdFk;
		this.trainingIdFk = trainingIdFk;
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
						.getTrainingIdFk().equals(castOther.getTrainingIdFk())));
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
		return result;
	}

}