package com.cnqaos.hibernate.pojo;

/**
 * StudentCenterId entity. @author MyEclipse Persistence Tools
 */

public class StudentCenterId implements java.io.Serializable {

	// Fields

	private Integer studentIdFk;
	private Integer centreIdFk;

	// Constructors

	/** default constructor */
	public StudentCenterId() {
	}

	/** full constructor */
	public StudentCenterId(Integer studentIdFk, Integer centreIdFk) {
		this.studentIdFk = studentIdFk;
		this.centreIdFk = centreIdFk;
	}

	// Property accessors

	public Integer getStudentIdFk() {
		return this.studentIdFk;
	}

	public void setStudentIdFk(Integer studentIdFk) {
		this.studentIdFk = studentIdFk;
	}

	public Integer getCentreIdFk() {
		return this.centreIdFk;
	}

	public void setCentreIdFk(Integer centreIdFk) {
		this.centreIdFk = centreIdFk;
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
				&& ((this.getCentreIdFk() == castOther.getCentreIdFk()) || (this
						.getCentreIdFk() != null
						&& castOther.getCentreIdFk() != null && this
						.getCentreIdFk().equals(castOther.getCentreIdFk())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getStudentIdFk() == null ? 0 : this.getStudentIdFk()
						.hashCode());
		result = 37
				* result
				+ (getCentreIdFk() == null ? 0 : this.getCentreIdFk()
						.hashCode());
		return result;
	}

}