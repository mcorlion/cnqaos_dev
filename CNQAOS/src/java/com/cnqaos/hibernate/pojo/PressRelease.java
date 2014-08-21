package com.cnqaos.hibernate.pojo;

import java.util.Date;

/**
 * PressRelease entity. @author MyEclipse Persistence Tools
 */

public class PressRelease implements java.io.Serializable {

	// Fields

	private Integer pressreleaseId;
	private String filename;
	private String file;
	private Date uploadDate;
	private String description;
	private Date releaseDate;

	// Constructors

	/** default constructor */
	public PressRelease() {
	}

	/** minimal constructor */
	public PressRelease(String filename, String file, Date uploadDate,
			Date releaseDate) {
		this.filename = filename;
		this.file = file;
		this.uploadDate = uploadDate;
		this.releaseDate = releaseDate;
	}

	/** full constructor */
	public PressRelease(String filename, String file, Date uploadDate,
			String description, Date releaseDate) {
		this.filename = filename;
		this.file = file;
		this.uploadDate = uploadDate;
		this.description = description;
		this.releaseDate = releaseDate;
	}

	// Property accessors

	public Integer getPressreleaseId() {
		return this.pressreleaseId;
	}

	public void setPressreleaseId(Integer pressreleaseId) {
		this.pressreleaseId = pressreleaseId;
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

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

}