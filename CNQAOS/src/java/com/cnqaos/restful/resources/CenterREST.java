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
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
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

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createCenter(
        @DefaultValue("0")    @QueryParam("id") int id,
            @QueryParam("centerName") String centerName,
            @QueryParam("centerAddress") String centerAddress,
            @QueryParam("street") String street,
            @QueryParam("city") String city,
            @QueryParam("pin") String pin,
        @DefaultValue("NA")    @QueryParam("description") String description,
            @QueryParam("latitude") double latitude,
            @QueryParam("longitude") double longitude) {
        Center center  = new Center();
        center.setCenterIdPk(id);
        center.setCenterName(centerName);
        center.setCenterAddress(centerAddress);
        center.setStreet(street);
        center.setCity(city);
        center.setPin(pin);
        center.setDescription(description);
        center.setLatitude(latitude);
        center.setLongitude(longitude);
        CenterBDO centerBDO = new CenterBDO();
        try{
            if(center.getCenterIdPk() == null){
                centerBDO.create(center);
            }else{
                centerBDO.edit(center);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return Response.status(200).toString();
        }
        
        return Response.status(200).toString();
    }
    
    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteCenter(@QueryParam("id") int id) {
        CenterBDO centerBDO = new CenterBDO();
        try{
            centerBDO.remove(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return Response.status(500).toString();
        }
        
        return Response.status(200).toString();
    }
    
    @GET
    @Path("/id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCenter(@QueryParam("id") int id) {
        CenterBDO centerBDO = new CenterBDO();
        try{
            centerBDO.remove(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return Response.status(500).build();
        }
        
        return Response.status(200).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        return "Center";
    }
}
