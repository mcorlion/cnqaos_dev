package com.cnqaos.hibernate.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer roleIdPk;
	private String roleName;
	private String description;
	private Set userRoles = new HashSet(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String roleName) {
		this.roleName = roleName;
	}

	/** full constructor */
	public Role(String roleName, String description, Set userRoles) {
		this.roleName = roleName;
		this.description = description;
		this.userRoles = userRoles;
	}

	// Property accessors

	public Integer getRoleIdPk() {
		return this.roleIdPk;
	}

	public void setRoleIdPk(Integer roleIdPk) {
		this.roleIdPk = roleIdPk;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}

}