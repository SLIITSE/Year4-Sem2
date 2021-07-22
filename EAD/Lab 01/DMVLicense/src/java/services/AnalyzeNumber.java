/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.PlateNumberManager;
import java.awt.PageAttributes.MediaType;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author kalub
 */


@Path("scanplate")
public class AnalyzeNumber {

    @Context
    private UriInfo context;
    
    @EJB
    PlateNumberManager pnm;

    /**
     * Creates a new instance of AnalyzeNumber
     */
    public AnalyzeNumber() {
    }

    /**
     * Retrieves representation of an instance of services.AnalyzeNumber
     * @param registration
     * @return an instance of java.lang.String
     */
    @Path("getcategory")
    @Produces(MediaType.TEXT_HTML)
    public String getCategoryParams(@QueryParam("regnum")@DefaultValue("CBE1234") 
    String registration){
        return "<h2> Required Driving License Category :"+pnm.getDLCategory(registration)+"</h2>";
    }

    /**
     * PUT method for updating or creating an instance of AnalyzeNumber
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
    
    /**
     *
     * @param registration
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String getCategoryPost(@FormParam("regnum") String registration){
        return "<h2> Required Driving License Category :"+pnm.getDLCategory(registration)+"</h2>";
    }
}
