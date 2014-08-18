package com.cnqaos.hibernate.pojo;

/**
 * UserRoleId entity. @author MyEclipse Persistence Tools
 */

public class UserRoleId implements java.io.Serializable {

	// Fields

	private Integer userIdFk;
	private Integer roleIdFk;

	// Constructors

	/** default constructor */
	public UserRoleId() {
	}

	/** full constructor */
	public UserRoleId(Integer userIdFk, Integer roleIdFk) {
		this.userIdFk = userIdFk;
		this.roleIdFk = roleIdFk;
	}

	// Property accessors

	public Integer getUserIdFk() {
		return this.userIdFk;
	}

	public void setUserIdFk(Integer userIdFk) {
		this.userIdFk = userIdFk;
	}

	public Integer getRoleIdFk() {
		return this.roleIdFk;
	}

	public void setRoleIdFk(Integer roleIdFk) {
		this.roleIdFk = roleIdFk;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserRoleId))
			return false;
		UserRoleId castOther = (UserRoleId) other;

		return ((this.getUserIdFk() == castOther.getUserIdFk()) || (this
				.getUserIdFk() != null && castOther.getUserIdFk() != null && this
				.getUserIdFk().equals(castOther.getUserIdFk())))
				&& ((this.getRoleIdFk() == castOther.getRoleIdFk()) || (this
						.getRoleIdFk() != null
						&& castOther.getRoleIdFk() != null && this
						.getRoleIdFk().equals(castOther.getRoleIdFk())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserIdFk() == null ? 0 : this.getUserIdFk().hashCode());
		result = 37 * result
				+ (getRoleIdFk() == null ? 0 : this.getRoleIdFk().hashCode());
		return result;
	}

}