package com.cnqaos.hibernate.pojo;
// Generated 23 Aug, 2014 9:46:56 PM by Hibernate Tools 3.6.0



/**
 * SubjectTeacher generated by hbm2java
 */
public class SubjectTeacher  implements java.io.Serializable {


     private Integer subjectTeacherIdPk;
     private Subject subject;
     private UserMaster userMaster;

    public SubjectTeacher() {
    }

    public SubjectTeacher(Subject subject, UserMaster userMaster) {
       this.subject = subject;
       this.userMaster = userMaster;
    }
   
    public Integer getSubjectTeacherIdPk() {
        return this.subjectTeacherIdPk;
    }
    
    public void setSubjectTeacherIdPk(Integer subjectTeacherIdPk) {
        this.subjectTeacherIdPk = subjectTeacherIdPk;
    }
    public Subject getSubject() {
        return this.subject;
    }
    
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public UserMaster getUserMaster() {
        return this.userMaster;
    }
    
    public void setUserMaster(UserMaster userMaster) {
        this.userMaster = userMaster;
    }




}


