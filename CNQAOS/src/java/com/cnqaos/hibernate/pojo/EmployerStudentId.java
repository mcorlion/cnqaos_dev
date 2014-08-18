package com.cnqaos.hibernate.pojo;

/**
 * EmployerStudentId entity. @author MyEclipse Persistence Tools
 */

public class EmployerStudentId implements java.io.Serializable {

	// Fields

	private Integer employerIdFk;
	private Integer studentIdFk;

	// Constructors

	/** default constructor */
	public EmployerStudentId() {
	}

	/** full constructor */
	public EmployerStudentId(Integer employerIdFk, Integer studentIdFk) {
		this.employerIdFk = employerIdFk;
		this.studentIdFk = studentIdFk;
	}

	// Property accessors

	public Integer getEmployerIdFk() {
		return this.employerIdFk;
	}

	public void setEmployerIdFk(Integer employerIdFk) {
		this.employerIdFk = employerIdFk;
	}

	public Integer getStudentIdFk() {
		return this.studentIdFk;
	}

	public void setStudentIdFk(Integer studentIdFk) {
		this.studentIdFk = studentIdFk;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EmployerStudentId))
			return false;
		EmployerStudentId castOther = (EmployerStudentId) other;

		return ((this.getEmployerIdFk() == castOther.getEmployerIdFk()) || (this
				.getEmployerIdFk() != null
				&& castOther.getEmployerIdFk() != null && this
				.getEmployerIdFk().equals(castOther.getEmployerIdFk())))
				&& ((this.getStudentIdFk() == castOther.getStudentIdFk()) || (this
						.getStudentIdFk() != null
						&& castOther.getStudentIdFk() != null && this
						.getStudentIdFk().equals(castOther.getStudentIdFk())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getEmployerIdFk() == null ? 0 : this.getEmployerIdFk()
						.hashCode());
		result = 37
				* result
				+ (getStudentIdFk() == null ? 0 : this.getStudentIdFk()
						.hashCode());
		return result;
	}

}