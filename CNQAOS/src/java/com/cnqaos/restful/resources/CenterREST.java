/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cnqaos.restful.resources;

import com.cnqaos.bdo.center.CenterBDO;
import com.cnqaos.hibernate.pojo.Center;
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
@Path("/center")
public class CenterREST {

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCenterList() {
        CenterBDO centerBDO = new CenterBDO();
        JsonArrayBuilder centerList = Json.createArrayBuilder();
        try{
            for(Center center : centerBDO.getCenterList()){
                centerList.add(center.getJSONObject());
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return Response.status(500).toString();
        }
        return centerList.build().toString();
    }
    
//    @POST
//    @Path("/add")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public String createCenter(@PathParam("data") String data){
//        System.out.println("............. "+data);
//        return Response.status(200).toString();
//    }

    @POST
    @Path("/add")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCenter(
        @DefaultValue("0")    @FormParam ("id") int id,
            @FormParam ("centerName") String centerName,
            @FormParam ("addressLine1") String addressLine1,
            @FormParam ("addressLine2") String addressLine2,
            @FormParam ("city") String city,
            @FormParam ("pin") String pin,
        @DefaultValue("NA")    @FormParam ("description") String description,
            @FormParam ("latitude") double latitude,
            @FormParam ("longitude") double longitude) {
        
        Center center  = null;
        CenterBDO centerBDO = new CenterBDO();
        try{
            if(id == 0){
                center  = new Center();
                center.setCenterName(centerName);
                center.setAddressLine1(addressLine1);
                center.setAddressLine2(addressLine2);
                center.setCity(city);
                center.setPin(pin);
                center.setDescription(description);
                center.setLatitude(latitude);
                center.setLongitude(longitude);
                
                centerBDO.create(center);
            }else{
                center = centerBDO.findCenter(id);
                center.setCenterName(centerName);
                center.setAddressLine1(addressLine1);
                center.setAddressLine2(addressLine2);
                center.setCity(city);
                center.setPin(pin);
                center.setDescription(description);
                center.setLatitude(latitude);
                center.setLongitude(longitude);

                centerBDO.edit(center);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }        
        return Response.ok(center.getJSONObject().toString(), MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/delete")
    @Consumes("text/plain")
    public Response deleteCenter(String id) {
        CenterBDO centerBDO = new CenterBDO();
        System.out.println(" remove id "+id);
        try{
            centerBDO.remove(Integer.parseInt(id));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
           return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        
        return Response.ok().build();
    }
    
    @GET
    @Path("/id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCenter(@QueryParam("id") int id) {
        CenterBDO centerBDO = new CenterBDO();
        Center center = null;
        JsonObject centerJson = null;
        try{
            center = centerBDO.findCenter(id);
            centerJson = center.getJSONObject();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        
         return Response.ok(centerJson.toString(), MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        return "Center";
    }
}
