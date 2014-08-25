/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cnqaos.restful.resources;

import com.cnqaos.bdo.training.TrainingBDO;
import com.cnqaos.hibernate.pojo.Training;
import com.cnqaos.hibernate.pojo.TrainingType;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Vimal
 */
@Path("/training")
public class TrainingREST {

    @GET
    @Path("/trainingcenter/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrainingCenterList() {
        TrainingBDO trainingBDO = new TrainingBDO();
        JsonArrayBuilder trainingJSON = null;
        try {
            trainingJSON = trainingBDO.getTrainingCenterJSON();
            System.out.println(" training center " + trainingJSON.build().toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok(trainingJSON.build().toString(), MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/typelist")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrainingTypeList() {
        TrainingBDO trainingBDO = new TrainingBDO();
        JsonArrayBuilder trainingTypeJSON = Json.createArrayBuilder();
        try {
            for (TrainingType trainingType : trainingBDO.getTrainingTypeList()) {
                trainingTypeJSON.add(trainingType.getJSONObject());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok(trainingTypeJSON.build().toString(), MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrainingList() {
        TrainingBDO trainingBDO = new TrainingBDO();
        JsonArrayBuilder trainingJSON = Json.createArrayBuilder();
        try {
            for (Training training : trainingBDO.getTrainingList()) {
                trainingJSON.add(training.getJSONObject());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok(trainingJSON.build().toString(), MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/add")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTraining(
            @DefaultValue("0") @FormParam("id") int id,
            @FormParam("name") String trainingName,
            @DefaultValue("NA") @FormParam("description") String description,
            @FormParam("typeId") int typeId,
            @FormParam("centers") List<String> centerIds
    ) {
        TrainingBDO trainingBDO = new TrainingBDO();
        try {
            System.out.println(" " + id);
            System.out.println(" " + trainingName);
            System.out.println(" " + description);
            System.out.println(" " + typeId);
            System.out.println(" " + centerIds);
            if (id == 0) {
                trainingBDO.create(trainingName, description, typeId, centerIds);
            }else {
                trainingBDO.edit(typeId, trainingName, description, typeId, centerIds);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok().build();
    }

    @POST
    @Path("/delete")
    @Consumes("application/x-www-form-urlencoded")
    public Response deleteTraining(
            @FormParam("id") int trainingId) {
        TrainingBDO trainingBDO = new TrainingBDO();
        try {
            System.out.println(" " + trainingId);
            trainingBDO.remove(trainingId);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok().build();
    }
}
