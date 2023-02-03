package controller;

import entity.UserDetails;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import service.UserDetailService;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("UserDetails")
public class UserDetailController{
    private final UserDetailService userDetailService = new UserDetailService();

    @Path("/readUserDetails")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDetails> readUserDetails(){
        return userDetailService.getAllUserDetails();
    }


    @Path("/createUserDetail")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createUserDetail(UserDetails userDetail){
        userDetailService.createUserDetails(userDetail);
    }

    @Path ("/deleteUserDetail")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUserDetail(UserDetails userDetail){
        userDetailService.deleteUserDetail(userDetail.getId());
    }

    @Path ("/updateNameUserDetail")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateNameUserDetail(UserDetails userDetail){
        userDetailService.updateUserDetailName(userDetail.getId(),userDetail.getName());
    }
    @Path ("/updateEmailUserDetail")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateEmailUserDetail(UserDetails userDetail){
        userDetailService.updateUserDetailName(userDetail.getId(),userDetail.getEmail());
    }}
