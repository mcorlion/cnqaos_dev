package com.cnqaos.hibernate.pojo;

/**
 * SubjectTeacherId entity. @author MyEclipse Persistence Tools
 */

public class SubjectTeacherId implements java.io.Serializable {

	// Fields

	private Integer subjectIdFk;
	private Integer teacherIdFk;

	// Constructors

	/** default constructor */
	public SubjectTeacherId() {
	}

	/** full constructor */
	public SubjectTeacherId(Integer subjectIdFk, Integer teacherIdFk) {
		this.subjectIdFk = subjectIdFk;
		this.teacherIdFk = teacherIdFk;
	}

	// Property accessors

	public Integer getSubjectIdFk() {
		return this.subjectIdFk;
	}

	public void setSubjectIdFk(Integer subjectIdFk) {
		this.subjectIdFk = subjectIdFk;
	}

	public Integer getTeacherIdFk() {
		return this.teacherIdFk;
	}

	public void setTeacherIdFk(Integer teacherIdFk) {
		this.teacherIdFk = teacherIdFk;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SubjectTeacherId))
			return false;
		SubjectTeacherId castOther = (SubjectTeacherId) other;

		return ((this.getSubjectIdFk() == castOther.getSubjectIdFk()) || (this
				.getSubjectIdFk() != null && castOther.getSubjectIdFk() != null && this
				.getSubjectIdFk().equals(castOther.getSubjectIdFk())))
				&& ((this.getTeacherIdFk() == castOther.getTeacherIdFk()) || (this
						.getTeacherIdFk() != null
						&& castOther.getTeacherIdFk() != null && this
						.getTeacherIdFk().equals(castOther.getTeacherIdFk())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getSubjectIdFk() == null ? 0 : this.getSubjectIdFk()
						.hashCode());
		result = 37
				* result
				+ (getTeacherIdFk() == null ? 0 : this.getTeacherIdFk()
						.hashCode());
		return result;
	}

}