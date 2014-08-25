/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cnqaos.restful.resources;

import com.cnqaos.bdo.subject.SubjectBDO;
import com.cnqaos.hibernate.pojo.Subject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Vimal
 */
@Path("/subject")
public class SubjectREST {
    
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubjectList() {
        SubjectBDO subjectBDO = new SubjectBDO();
        JsonArrayBuilder subjectList = Json.createArrayBuilder();
        try{
            for(Subject subject : subjectBDO.getSubjectList()){
                     subjectList.add(subject.getJSONObject());
            }

        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok(subjectList.build().toString(), MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/add")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSubject(
        @DefaultValue("0")    @FormParam ("id") int id,
            @FormParam ("subjectName") String subjectName) {
        Subject subject=null;
        SubjectBDO subjectBDO = new SubjectBDO();
        try{
            if(id == 0){
                subject = new Subject(subjectName);
                subjectBDO.create(subject);
            }else{
                subject  = new Subject();
                subject.setSubjectIdPk(id);
                subject.setSubjectName(subjectName);
                subjectBDO.edit(subject);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok(subject.getJSONObject().toString(), MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/delete")
    @Consumes("text/plain")
    public Response deleteSubject(String id) {
        SubjectBDO subjectBDO = new SubjectBDO();
        System.out.println(" remove id "+id);
        try{
            subjectBDO.remove(Integer.parseInt(id));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
           return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        
        return Response.ok().build();
    }
    
    @GET
    @Path("/id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubject(@QueryParam("id") int id) {
        SubjectBDO subjectBDO = new SubjectBDO();
        Subject subject = null;
        JsonObject centerJson = null;
        try{
            subject = subjectBDO.findSubject(id);
            centerJson = subject.getJSONObject();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        
         return Response.ok(centerJson.toString(), MediaType.APPLICATION_JSON).build();
    }
    
}
