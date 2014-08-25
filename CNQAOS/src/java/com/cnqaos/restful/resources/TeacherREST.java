/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cnqaos.restful.resources;

import com.cnqaos.bdo.teacher.TeacherBDO;
import com.cnqaos.hibernate.pojo.Role;
import com.cnqaos.hibernate.pojo.Subject;
import com.cnqaos.hibernate.pojo.SubjectTeacher;
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
@Path("/teacher")
public class TeacherREST {
    
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTeacherList() {
        TeacherBDO teacherBDO = new TeacherBDO();
        JsonArrayBuilder teacherList = Json.createArrayBuilder();
        try{
            for(UserMaster  teacher : teacherBDO.getTeacherList()){
                System.out.println(" data "+teacher.getJSONObjectForTeacher());
                teacherList.add(teacher.getJSONObjectForTeacher());
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return Response.status(500).toString();
        }
        return teacherList.build().toString();
    }
    
  @POST
    @Path("/add")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTeacher(
        @DefaultValue("0")    @FormParam ("idPk") int idPk,
            @FormParam ("id") String id,
            @FormParam ("name") String name,
            @FormParam ("surName") String surName,
            @FormParam ("dateOfBirth") String dateOfBirth,
        @DefaultValue("NA")    @FormParam ("phoneNumber") String phoneNumber,
        @DefaultValue("NA")    @FormParam ("cellphoneNumber") String cellphoneNumber,
        @DefaultValue("NA")    @FormParam ("emailAddress") String emailAddress,
            @FormParam ("subjectId") int subjectId) {

        UserMaster userMaster  = null;
        UserRole userRole = null;
        SubjectTeacher subjectTeacher = null;
        TeacherBDO teacherBDO = new TeacherBDO();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
        Role role = (Role) HibernateSessionFactory.getSession().get(Role.class, CnqaosConstant.TEACHER_ROLE_ID);
        Subject subject = (Subject) HibernateSessionFactory.getSession().get(Subject.class, subjectId);
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
                userMaster.setPassword("changemenow");
                
                userRole = new UserRole(userMaster, role);
                subjectTeacher = new SubjectTeacher(subject, userMaster);
                               
                teacherBDO.create(userMaster, userRole, subjectTeacher);
            }else{
                userMaster = teacherBDO.findTeacher(idPk);
                userMaster.setId(id);
                userMaster.setName(name);
                userMaster.setSurName(surName);
                userMaster.setDateOfBirth(birthDate);
                userMaster.setPhoneNumber(phoneNumber);
                userMaster.setCellphoneNumber(cellphoneNumber);
                userMaster.setEmailAddress(emailAddress);
                
                teacherBDO.edit(userMaster, subject);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok(userMaster.getJSONObjectForTeacher().toString(), MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/delete")
    @Consumes("text/plain")
    public Response deleteTeacher(String id) {
        TeacherBDO teacherBDO = new TeacherBDO();
        try{
            teacherBDO.remove(Integer.parseInt(id));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
           return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        
        return Response.ok().build();
    }
    
    @GET
    @Path("/id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeacher(@QueryParam("id") int id) {
        TeacherBDO teacherBDO = new TeacherBDO();
        UserMaster teacher = null;
        JsonObject teacherJson = null;
        try{
            teacher = teacherBDO.findTeacher(id);
            teacherJson = teacher.getJSONObjectForTeacher();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        
         return Response.ok(teacherJson.toString(), MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        return "Teacher";
    }
}
