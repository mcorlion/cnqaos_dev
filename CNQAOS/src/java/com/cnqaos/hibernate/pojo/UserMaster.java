package com.cnqaos.hibernate.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * UserMaster entity. @author MyEclipse Persistence Tools
 */

public class UserMaster implements java.io.Serializable {

	// Fields

	private Integer userIdPk;
	private String id;
	private String name;
	private String surName;
	private Date dateOfBirth;
	private String phoneNumber;
	private String cellphoneNumber;
	private String emailAddress;
	private Set subjectTeachers = new HashSet(0);
	private Set employerStudentsForEmployerIdFk = new HashSet(0);
	private Set studentCentres = new HashSet(0);
	private Set employerStudentsForStudentIdFk = new HashSet(0);
	private Set userRoles = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserMaster() {
	}

	/** minimal constructor */
	public UserMaster(String id, String name, String surName, Date dateOfBirth) {
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.dateOfBirth = dateOfBirth;
	}

	/** full constructor */
	public UserMaster(String id, String name, String surName, Date dateOfBirth,
			String phoneNumber, String cellphoneNumber, String emailAddress,
			Set subjectTeachers, Set employerStudentsForEmployerIdFk,
			Set studentCentres, Set employerStudentsForStudentIdFk,
			Set userRoles) {
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.cellphoneNumber = cellphoneNumber;
		this.emailAddress = emailAddress;
		this.subjectTeachers = subjectTeachers;
		this.employerStudentsForEmployerIdFk = employerStudentsForEmployerIdFk;
		this.studentCentres = studentCentres;
		this.employerStudentsForStudentIdFk = employerStudentsForStudentIdFk;
		this.userRoles = userRoles;
	}

	// Property accessors

	public Integer getUserIdPk() {
		return this.userIdPk;
	}

	public void setUserIdPk(Integer userIdPk) {
		this.userIdPk = userIdPk;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return this.surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCellphoneNumber() {
		return this.cellphoneNumber;
	}

	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Set getSubjectTeachers() {
		return this.subjectTeachers;
	}

	public void setSubjectTeachers(Set subjectTeachers) {
		this.subjectTeachers = subjectTeachers;
	}

	public Set getEmployerStudentsForEmployerIdFk() {
		return this.employerStudentsForEmployerIdFk;
	}

	public void setEmployerStudentsForEmployerIdFk(
			Set employerStudentsForEmployerIdFk) {
		this.employerStudentsForEmployerIdFk = employerStudentsForEmployerIdFk;
	}

	public Set getStudentCentres() {
		return this.studentCentres;
	}

	public void setStudentCentres(Set studentCentres) {
		this.studentCentres = studentCentres;
	}

	public Set getEmployerStudentsForStudentIdFk() {
		return this.employerStudentsForStudentIdFk;
	}

	public void setEmployerStudentsForStudentIdFk(
			Set employerStudentsForStudentIdFk) {
		this.employerStudentsForStudentIdFk = employerStudentsForStudentIdFk;
	}

	public Set getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}

}