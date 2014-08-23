package com.cnqaos.hibernate.pojo;
// Generated 23 Aug, 2014 1:07:34 AM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Newsletter generated by hbm2java
 */
public class Newsletter  implements java.io.Serializable {


     private Integer newsletterId;
     private String filename;
     private byte[] file;
     private Date uploadDate;
     private String description;
     private Date issue;

    public Newsletter() {
    }

	
    public Newsletter(String filename, byte[] file, Date uploadDate, Date issue) {
        this.filename = filename;
        this.file = file;
        this.uploadDate = uploadDate;
        this.issue = issue;
    }
    public Newsletter(String filename, byte[] file, Date uploadDate, String description, Date issue) {
       this.filename = filename;
       this.file = file;
       this.uploadDate = uploadDate;
       this.description = description;
       this.issue = issue;
    }
   
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
    public Date getIssue() {
        return this.issue;
    }
    
    public void setIssue(Date issue) {
        this.issue = issue;
    }




}


