package com.cnqaos.hibernate.pojo;

/**
 * StudentCenter entity. @author MyEclipse Persistence Tools
 */

public class StudentCenter implements java.io.Serializable {

	// Fields

	private StudentCenterId id;
	private UserMaster userMaster;
	private Center center;

	// Constructors

	/** default constructor */
	public StudentCenter() {
	}

	/** full constructor */
	public StudentCenter(StudentCenterId id, UserMaster userMaster,
			Center center) {
		this.id = id;
		this.userMaster = userMaster;
		this.center = center;
	}

	// Property accessors

	public StudentCenterId getId() {
		return this.id;
	}

	public void setId(StudentCenterId id) {
		this.id = id;
	}

	public UserMaster getUserMaster() {
		return this.userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	public Center getCenter() {
		return this.center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

}