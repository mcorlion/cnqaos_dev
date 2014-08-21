package com.cnqaos.hibernate.pojo;

/**
 * StudentCenterId entity. @author MyEclipse Persistence Tools
 */

public class StudentCenterId implements java.io.Serializable {

	// Fields

	private Integer studentIdFk;
	private Integer centerIdFk;

	// Constructors

	/** default constructor */
	public StudentCenterId() {
	}

	/** full constructor */
	public StudentCenterId(Integer studentIdFk, Integer centerIdFk) {
		this.studentIdFk = studentIdFk;
		this.centerIdFk = centerIdFk;
	}

	// Property accessors

	public Integer getStudentIdFk() {
		return this.studentIdFk;
	}

	public void setStudentIdFk(Integer studentIdFk) {
		this.studentIdFk = studentIdFk;
	}

	public Integer getCenterIdFk() {
		return this.centerIdFk;
	}

	public void setCenterIdFk(Integer centerIdFk) {
		this.centerIdFk = centerIdFk;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StudentCenterId))
			return false;
		StudentCenterId castOther = (StudentCenterId) other;

		return ((this.getStudentIdFk() == castOther.getStudentIdFk()) || (this
				.getStudentIdFk() != null && castOther.getStudentIdFk() != null && this
				.getStudentIdFk().equals(castOther.getStudentIdFk())))
				&& ((this.getCenterIdFk() == castOther.getCenterIdFk()) || (this
						.getCenterIdFk() != null
						&& castOther.getCenterIdFk() != null && this
						.getCenterIdFk().equals(castOther.getCenterIdFk())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getStudentIdFk() == null ? 0 : this.getStudentIdFk()
						.hashCode());
		result = 37
				* result
				+ (getCenterIdFk() == null ? 0 : this.getCenterIdFk()
						.hashCode());
		return result;
	}

}