package com.cnqaos.hibernate.pojo;
// Generated 23 Aug, 2014 1:07:34 AM by Hibernate Tools 3.6.0



/**
 * TrainingSubject generated by hbm2java
 */
public class TrainingSubject  implements java.io.Serializable {


     private TrainingSubjectId id;
     private Subject subject;
     private Training training;

    public TrainingSubject() {
    }

    public TrainingSubject(TrainingSubjectId id, Subject subject, Training training) {
       this.id = id;
       this.subject = subject;
       this.training = training;
    }
   
    public TrainingSubjectId getId() {
        return this.id;
    }
    
    public void setId(TrainingSubjectId id) {
        this.id = id;
    }
    public Subject getSubject() {
        return this.subject;
    }
    
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public Training getTraining() {
        return this.training;
    }
    
    public void setTraining(Training training) {
        this.training = training;
    }




}


