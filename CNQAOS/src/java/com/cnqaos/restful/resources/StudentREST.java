/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cnqaos.restful.resources;

import com.cnqaos.bdo.student.StudentBDO;
import com.cnqaos.hibernate.pojo.Center;
import com.cnqaos.hibernate.pojo.Role;
import com.cnqaos.hibernate.pojo.StudentCenter;
import com.cnqaos.hibernate.pojo.UserMaster;
import com.cnqaos.hibernate.pojo.UserRole;
import com.cnqaos.hibernate.util.HibernateSessionFactory;
import com.cnqaos.util.CnqaosConstant;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@Path("/student")
public class StudentREST {
    
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStudentList() {
        StudentBDO studentBDO = new StudentBDO();
        JsonArrayBuilder studentList = Json.createArrayBuilder();
        try{
            for(UserMaster  student : studentBDO.getStudentList()){
                System.out.println(" data "+student.getJSONObjectForStudent());
                studentList.add(student.getJSONObjectForStudent());
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return Response.status(500).toString();
        }
        return studentList.build().toString();
    }
    
  @POST
    @Path("/add")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCenter(
        @DefaultValue("0")    @FormParam ("idPk") int idPk,
            @FormParam ("id") String id,
            @FormParam ("name") String name,
            @FormParam ("surName") String surName,
            @FormParam ("dateOfBirth") String dateOfBirth,
        @DefaultValue("NA")    @FormParam ("phoneNumber") String phoneNumber,
        @DefaultValue("NA")    @FormParam ("cellphoneNumber") String cellphoneNumber,
        @DefaultValue("NA")    @FormParam ("emailAddress") String emailAddress,
            @FormParam ("centerId") String centerId) {

        UserMaster userMaster  = null;
        UserRole userRole = null;
        StudentCenter studentCenter = null;
        StudentBDO studentBDO = new StudentBDO();
        DateFormat df = new SimpleDateFormat("yyyy-MM-yy");  
        Role role = (Role) HibernateSessionFactory.getSession().get(Role.class, CnqaosConstant.STUDENT_ROLE_ID);
        Center center = (Center) HibernateSessionFactory.getSession().get(Center.class, centerId);
        try{
            Date birthDate = df.parse(dateOfBirth);
            if(idPk == 0){
                userMaster = new UserMaster();
                userMaster.setId(id);
                userMaster.setName(name);
                userMaster.setSurName(surName);
                userMaster.setDateOfBirth(birthDate);
                userMaster.setPhoneNumber(phoneNumber);
                userMaster.setCellphoneNumber(cellphoneNumber);
                userMaster.setEmailAddress(emailAddress);
                
                userRole = new UserRole(userMaster, role);
                studentCenter = new StudentCenter(userMaster, center);
                               
                studentBDO.create(userMaster, userRole, studentCenter);
            }else{
                userMaster = studentBDO.findStudent(idPk);
                userMaster.setId(id);
                userMaster.setName(name);
                userMaster.setSurName(surName);
                userMaster.setDateOfBirth(birthDate);
                userMaster.setPhoneNumber(phoneNumber);
                userMaster.setCellphoneNumber(cellphoneNumber);
                userMaster.setEmailAddress(emailAddress);
                
                studentCenter = new StudentCenter(userMaster, center);
                
                studentBDO.edit(userMaster, studentCenter);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        
        return Response.ok(userMaster.getJSONObjectForStudent().toString(), MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/delete")
    @Consumes("text/plain")
    public Response deleteStudent(String id) {
        StudentBDO studentBDO = new StudentBDO();
        try{
            studentBDO.remove(Integer.parseInt(id));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
           return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        
        return Response.ok().build();
    }
    
    @GET
    @Path("/id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent(@QueryParam("id") int id) {
        StudentBDO studentBDO = new StudentBDO();
        UserMaster student = null;
        JsonObject studentJson = null;
        try{
            student = studentBDO.findStudent(id);
            studentJson = student.getJSONObjectForStudent();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        
         return Response.ok(studentJson.toString(), MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        return "Center";
    }
}
