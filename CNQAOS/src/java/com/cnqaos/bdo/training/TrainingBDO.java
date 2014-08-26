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
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

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
        
    }
    
    public void edit(int trainingId,String name,String description,int type,List<String> subjectsId) throws Exception {
    
    }
    
    public void remove(int trainingId) throws Exception {
        
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
