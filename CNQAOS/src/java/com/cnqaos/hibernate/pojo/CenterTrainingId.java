package com.cnqaos.hibernate.pojo;

/**
 * CenterTrainingId entity. @author MyEclipse Persistence Tools
 */

public class CenterTrainingId implements java.io.Serializable {

	// Fields

	private Integer centreIdFk;
	private Integer trainingIdFk;


	// Constructors

	/** default constructor */
	public CenterTrainingId() {
	}

	/** minimal constructor */
	public CenterTrainingId(Integer centreIdFk, Integer trainingIdFk) {
		this.centreIdFk = centreIdFk;
		this.trainingIdFk = trainingIdFk;
	}

	// Property accessors

	public Integer getCentreIdFk() {
		return this.centreIdFk;
	}

	public void setCentreIdFk(Integer centreIdFk) {
		this.centreIdFk = centreIdFk;
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

		return ((this.getCentreIdFk() == castOther.getCentreIdFk()) || (this
				.getCentreIdFk() != null && castOther.getCentreIdFk() != null && this
				.getCentreIdFk().equals(castOther.getCentreIdFk())))
				&& ((this.getTrainingIdFk() == castOther.getTrainingIdFk()) || (this
						.getTrainingIdFk() != null
						&& castOther.getTrainingIdFk() != null && this
						.getTrainingIdFk().equals(castOther.getTrainingIdFk())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCentreIdFk() == null ? 0 : this.getCentreIdFk()
						.hashCode());
		result = 37
				* result
				+ (getTrainingIdFk() == null ? 0 : this.getTrainingIdFk()
						.hashCode());

		return result;
	}

}