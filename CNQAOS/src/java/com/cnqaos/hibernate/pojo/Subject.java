package com.cnqaos.hibernate.pojo;
// Generated 23 Aug, 2014 9:46:56 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 * Subject generated by hbm2java
 */
public class Subject  implements java.io.Serializable {


     private Integer subjectIdPk;
     private String subjectName;
     private Set trainingSubjects = new HashSet(0);
     private Set subjectTeachers = new HashSet(0);

    public Subject() {
    }

	
    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }
    public Subject(String subjectName, Set trainingSubjects, Set subjectTeachers) {
       this.subjectName = subjectName;
       this.trainingSubjects = trainingSubjects;
       this.subjectTeachers = subjectTeachers;
    }
   
    public Integer getSubjectIdPk() {
        return this.subjectIdPk;
    }
    
    public void setSubjectIdPk(Integer subjectIdPk) {
        this.subjectIdPk = subjectIdPk;
    }
    public String getSubjectName() {
        return this.subjectName;
    }
    
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public Set getTrainingSubjects() {
        return this.trainingSubjects;
    }
    
    public void setTrainingSubjects(Set trainingSubjects) {
        this.trainingSubjects = trainingSubjects;
    }
    public Set getSubjectTeachers() {
        return this.subjectTeachers;
    }
    
    public void setSubjectTeachers(Set subjectTeachers) {
        this.subjectTeachers = subjectTeachers;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.subjectName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Subject other = (Subject) obj;
        if (!Objects.equals(this.subjectName, other.subjectName)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString(){
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("id",subjectIdPk)
                .add("subjectName", subjectName);
        return builder.build().toString();
    }
    
    public JsonObject getJSONObject(){
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("id",subjectIdPk)
                .add("subjectName", subjectName);
        return builder.build();
    }
}


