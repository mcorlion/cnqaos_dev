/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cnqaos.restful.resources;


import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import java.io.InputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Vimal
 */
@Path("/newsletter")
public class NewsLetterREST {
    
    @Path("/list")
    public Response getNewsLetter(){
    
        return Response.ok().build();
    }
    
    @Path("/add")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response createNewsLetter(){
//        FormDataBodyPart filePart = form.getField("file");
//
//        InputStream fileInputStream = filePart.getValueAs(InputStream.class);
   
        return Response.ok().build();
    }
    
    @Path("/delete")
    public Response deleteNewsLetter(){
    
        return Response.ok().build();
    }
}
