package ICAI.controller;

import ICAI.entity.RecordLabels;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import ICAI.service.RecordLabelService;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("RecordLabels")
public class RecordLabelController{
    private final RecordLabelService recordLabelService = new RecordLabelService();

    @Path("/readRecordLabels")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<RecordLabels> readRecordLabels(){
        return recordLabelService.getAllRecordLabels();
    }

    @Path ("/getRecordLabel")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RecordLabels getRecordLabel(RecordLabels recordLabels){
        return recordLabelService.findRecordLabel(recordLabels.getId());
    }

    @Path("/createRecordLabel")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createRecordLabel(RecordLabels recordLabels){
        recordLabelService.createRecordLabel(recordLabels);
    }

    @Path ("/deleteRecordLabel")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteRecordLabel(RecordLabels recordLabels){
        recordLabelService.deleteRecordLabel(recordLabels.getId());
    }

    @Path ("/updateRecordLabel")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateRecordLabel(RecordLabels recordLabels){
        recordLabelService.updateRecordLabelName(recordLabels.getId(),recordLabels.getName());
    }}