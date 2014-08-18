package com.cnqaos.hibernate.pojo;

/**
 * EmployerStudent entity. @author MyEclipse Persistence Tools
 */

public class EmployerStudent implements java.io.Serializable {

	// Fields

	private EmployerStudentId id;
	private UserMaster userMasterByStudentIdFk;
	private UserMaster userMasterByEmployerIdFk;

	// Constructors

	/** default constructor */
	public EmployerStudent() {
	}

	/** full constructor */
	public EmployerStudent(EmployerStudentId id,
			UserMaster userMasterByStudentIdFk,
			UserMaster userMasterByEmployerIdFk) {
		this.id = id;
		this.userMasterByStudentIdFk = userMasterByStudentIdFk;
		this.userMasterByEmployerIdFk = userMasterByEmployerIdFk;
	}

	// Property accessors

	public EmployerStudentId getId() {
		return this.id;
	}

	public void setId(EmployerStudentId id) {
		this.id = id;
	}

	public UserMaster getUserMasterByStudentIdFk() {
		return this.userMasterByStudentIdFk;
	}

	public void setUserMasterByStudentIdFk(UserMaster userMasterByStudentIdFk) {
		this.userMasterByStudentIdFk = userMasterByStudentIdFk;
	}

	public UserMaster getUserMasterByEmployerIdFk() {
		return this.userMasterByEmployerIdFk;
	}

	public void setUserMasterByEmployerIdFk(UserMaster userMasterByEmployerIdFk) {
		this.userMasterByEmployerIdFk = userMasterByEmployerIdFk;
	}

}