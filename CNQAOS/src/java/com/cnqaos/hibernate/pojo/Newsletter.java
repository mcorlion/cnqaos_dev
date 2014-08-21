package com.cnqaos.hibernate.pojo;

import java.util.Date;

/**
 * Newsletter entity. @author MyEclipse Persistence Tools
 */

public class Newsletter implements java.io.Serializable {

	// Fields

	private Integer newsletterId;
	private String filename;
	private String file;
	private Date uploadDate;
	private String description;
	private Date issue;

	// Constructors

	/** default constructor */
	public Newsletter() {
	}

	/** minimal constructor */
	public Newsletter(String filename, String file, Date uploadDate, Date issue) {
		this.filename = filename;
		this.file = file;
		this.uploadDate = uploadDate;
		this.issue = issue;
	}

	/** full constructor */
	public Newsletter(String filename, String file, Date uploadDate,
			String description, Date issue) {
		this.filename = filename;
		this.file = file;
		this.uploadDate = uploadDate;
		this.description = description;
		this.issue = issue;
	}

	// Property accessors

	public Integer getNewsletterId() {
		return this.newsletterId;
	}

	public void setNewsletterId(Integer newsletterId) {
		this.newsletterId = newsletterId;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getIssue() {
		return this.issue;
	}

	public void setIssue(Date issue) {
		this.issue = issue;
	}

}