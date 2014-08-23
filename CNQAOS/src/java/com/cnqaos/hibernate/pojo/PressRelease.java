package com.cnqaos.hibernate.pojo;
// Generated 23 Aug, 2014 9:46:56 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * PressRelease generated by hbm2java
 */
public class PressRelease  implements java.io.Serializable {


     private Integer pressreleaseIdPk;
     private String filename;
     private byte[] file;
     private Date uploadDate;
     private String description;
     private Date releaseDate;

    public PressRelease() {
    }

	
    public PressRelease(String filename, byte[] file, Date uploadDate, Date releaseDate) {
        this.filename = filename;
        this.file = file;
        this.uploadDate = uploadDate;
        this.releaseDate = releaseDate;
    }
    public PressRelease(String filename, byte[] file, Date uploadDate, String description, Date releaseDate) {
       this.filename = filename;
       this.file = file;
       this.uploadDate = uploadDate;
       this.description = description;
       this.releaseDate = releaseDate;
    }
   
    public Integer getPressreleaseIdPk() {
        return this.pressreleaseIdPk;
    }
    
    public void setPressreleaseIdPk(Integer pressreleaseIdPk) {
        this.pressreleaseIdPk = pressreleaseIdPk;
    }
    public String getFilename() {
        return this.filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public byte[] getFile() {
        return this.file;
    }
    
    public void setFile(byte[] file) {
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


