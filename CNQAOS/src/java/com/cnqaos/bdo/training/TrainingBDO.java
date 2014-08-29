/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cnqaos.bdo.training;

import com.cnqaos.hibernate.dao.CenterTrainingDAO;
import com.cnqaos.hibernate.dao.SubjectDAO;
import com.cnqaos.hibernate.dao.TrainingDAO;
import com.cnqaos.hibernate.dao.TrainingSubjectDAO;
import com.cnqaos.hibernate.dao.TrainingTypeDAO;
import com.cnqaos.hibernate.pojo.CenterTraining;
import com.cnqaos.hibernate.pojo.Subject;
import com.cnqaos.hibernate.pojo.Training;
import com.cnqaos.hibernate.pojo.TrainingSubject;
import com.cnqaos.hibernate.pojo.TrainingType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import org.hibernate.Transaction;

/**
 *
 * @author Vimal
 */
public class TrainingBDO {
    private TrainingDAO trainingDAO = new  TrainingDAO();
    private TrainingTypeDAO trainingTypeDAO  = new TrainingTypeDAO();
    private SubjectDAO subjectDAO = new SubjectDAO();
    private TrainingSubjectDAO trainingSubjectDAO  = new TrainingSubjectDAO();

    
    public void create(String name,String description,int type,List<String> subjectsId) throws Exception{
        
        String strSubjectIds = subjectsId.toString().substring(1, subjectsId.toString().length()-1);
        TrainingType trainingType = trainingTypeDAO.findById(type);
        List<Subject> subjectList = subjectDAO.findBySubjectIds(strSubjectIds);
        Training training = new Training();
        training.setTrainingName(name);
        training.setDescription(description);
        training.setTrainingType(trainingType);
        
        Transaction transaction = null;
        TrainingSubject trainingSubject = null;
        try {
            transaction = trainingDAO.getSession().getTransaction();
            transaction.begin();
            trainingDAO.save(training);
            
            for (Subject subject : subjectList) {
                trainingSubject = new TrainingSubject(subject, training);
                trainingSubjectDAO.save(trainingSubject);
            }
            
            transaction.commit();
        }catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            throw ex;
        }
        
    }
    
    public void edit(int trainingId, String name, String description, int type, List<String> subjectsId) throws Exception {
        
        List<TrainingSubject> toAddlistTrainingSubject = new ArrayList<TrainingSubject>();
        List<TrainingSubject> toDeletelistTrainingSubject = new ArrayList<TrainingSubject>();
        TrainingSubject newTrainingSubject = null;
        Subject subject = null;
        Training training = trainingDAO.findById(trainingId);
        TrainingType trainingType = trainingTypeDAO.findById(type);
        List<TrainingSubject> oldListTrainingSubject = trainingSubjectDAO.findByProperty("training", training);
        
        training.setTrainingName(name);
        training.setDescription(description);
        training.setTrainingType(trainingType);
        
        for (String subjectId : subjectsId) {
            boolean isNewSubject = true;
            for (TrainingSubject trainingSubject : oldListTrainingSubject) {
                if(trainingSubject.getSubject().getSubjectIdPk() == Integer.parseInt(subjectId)){
                    isNewSubject = false;
                    break;
                }
            }
            if(isNewSubject){
                subject = subjectDAO.findById(Integer.parseInt(subjectId));
                newTrainingSubject = new TrainingSubject(subject, training);
                toAddlistTrainingSubject.add(newTrainingSubject);
            }
        }
        
        for (TrainingSubject trainingSubject : oldListTrainingSubject) {
            boolean isOldTrainingSubject = true;
            for (String subjectId : subjectsId) {
                if(trainingSubject.getSubject().getSubjectIdPk() == Integer.parseInt(subjectId)){
                    isOldTrainingSubject = false;
                    break;
                }
            }
            if(isOldTrainingSubject){
                toDeletelistTrainingSubject.add(trainingSubject);
            }
        }
        Transaction transaction = null;
        try {
            transaction = trainingDAO.getSession().getTransaction();
            transaction.begin();
            trainingDAO.attachDirty(training);
            
            for (TrainingSubject trainingSubject : toDeletelistTrainingSubject) {
                trainingSubjectDAO.delete(trainingSubject);
            }
            for (TrainingSubject trainingSubject : toAddlistTrainingSubject) {
                trainingSubjectDAO.save(trainingSubject);
            }
            transaction.commit();
        }catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            throw ex;
        }        
    }
    
    public void remove(int trainingId) throws Exception {
        Training training = trainingDAO.findById(trainingId);
        List<TrainingSubject> listTrainingSubject = trainingSubjectDAO.findByProperty("training", training);
        Transaction transaction = null;
        try {
            transaction = trainingDAO.getSession().getTransaction();
            transaction.begin();            
            for (TrainingSubject trainingSubject : listTrainingSubject) {
                trainingSubjectDAO.delete(trainingSubject);
            }
            trainingDAO.delete(training);
            transaction.commit();
        }catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            throw ex;
        }
    }
    
    public List<Training> getTrainingList() throws Exception{
        return this.trainingDAO.findAll();       
    }
    
    public JsonArrayBuilder getTrainingCenterJSON() throws Exception{
        JsonArrayBuilder trainingCenterJson = Json.createArrayBuilder();
        for(Training training : trainingDAO.findAll()){
            JsonObjectBuilder trainingJSON = Json.createObjectBuilder();
            trainingJSON.add("id",training.getTrainingIdPk())
                    .add("name", training.getTrainingName())
                    .add("description", training.getDescription())
                    .add("typeId",training.getTrainingType().getTrainingTypeIdPk())
                    .add("type",training.getTrainingType().getTrainingTypeName())
                    .add("subjects", this.getSubjectJSON(training).build());
            trainingCenterJson.add(trainingJSON);
        }
    
        return trainingCenterJson;
    }
    
    public JsonArrayBuilder getSubjectJSON(Training training)throws Exception{
       JsonArrayBuilder centerJson = Json.createArrayBuilder();
            for(TrainingSubject trainingSubject : trainingSubjectDAO.findByProperty("training",training)){
                    centerJson.add(trainingSubject.getSubject().getSubjectIdPk());
            }
       return centerJson;
    }
    
    public List<TrainingType> getTrainingTypeList(){
        return this.trainingTypeDAO.findAll();
    }
    
    public List<Subject> getSubjectList(){
        return this.subjectDAO.findAll();
    }
    
}
