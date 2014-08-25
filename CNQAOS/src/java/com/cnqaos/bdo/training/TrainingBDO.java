/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cnqaos.bdo.training;

import com.cnqaos.hibernate.dao.CenterTrainingDAO;
import com.cnqaos.hibernate.dao.TrainingDAO;
import com.cnqaos.hibernate.dao.TrainingTypeDAO;
import com.cnqaos.hibernate.pojo.CenterTraining;
import com.cnqaos.hibernate.pojo.Training;
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
    private CenterTrainingDAO centerTrainingDAO = new CenterTrainingDAO();

    
    public void create(String name,String description,int type,List<String> centersId) throws Exception{       
        
    }
    
    public void edit(int trainingId,String name,String description,int type,List<String> centersId) throws Exception {
    
    }
    
    public void remove(int trainingId) throws Exception {
        
    }
    
    public List<Training> getTrainingList() throws Exception{
        return this.trainingDAO.findAll();       
    }
    
    public JsonArrayBuilder getTrainingCenterJSON() throws Exception{
        JsonArrayBuilder trainingCenterJson = Json.createArrayBuilder();
        System.out.println(" training list "+trainingDAO.findAll());
        for(Training training : trainingDAO.findAll()){
            JsonObjectBuilder trainingJSON = Json.createObjectBuilder();
            trainingJSON.add("id",training.getTrainingIdPk())
                    .add("name", training.getTrainingName())
                    .add("description", training.getDescription())
                    .add("typeId",training.getTrainingType().getTrainingTypeIdPk())
                    .add("type",training.getTrainingType().getTrainingTypeName())
                    .add("centers", this.getCentersJSON(training).build());
            trainingCenterJson.add(trainingJSON);
        }
    
        return trainingCenterJson;
    }
    
    public JsonArrayBuilder getCentersJSON(Training training)throws Exception{
       JsonArrayBuilder centerJson = Json.createArrayBuilder();
            for(CenterTraining centerTraining : centerTrainingDAO.findByProperty("training",training)){
                    centerJson.add(centerTraining.getCenter().getCenterIdPk());
            }
       return centerJson;
    }
    
    public List<TrainingType> getTrainingTypeList(){
        return this.trainingTypeDAO.findAll();
    }
    
    
    
}
