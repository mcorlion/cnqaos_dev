package com.cnqaos.hibernate.pojo;
// Generated 23 Aug, 2014 9:46:56 PM by Hibernate Tools 3.6.0



/**
 * TrainingSubject generated by hbm2java
 */
public class TrainingSubject  implements java.io.Serializable {


     private Integer trainingSubjectIdPk;
     private Subject subject;
     private Training training;

    public TrainingSubject() {
    }

    public TrainingSubject(Subject subject, Training training) {
       this.subject = subject;
       this.training = training;
    }
   
    public Integer getTrainingSubjectIdPk() {
        return this.trainingSubjectIdPk;
    }
    
    public void setTrainingSubjectIdPk(Integer trainingSubjectIdPk) {
        this.trainingSubjectIdPk = trainingSubjectIdPk;
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


