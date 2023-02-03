package controller;

import entity.Users;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import service.UserService;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("Users")
public class UserController{
    private final UserService UserService = new UserService();

    @Path("/readUsers")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> readUsers(){
        return UserService.getAllUsers();
    }
    @Path ("/getUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Users getUser(Users Users){
        return UserService.findUser(Users.getId());
    }

    @Path ("/getDetailsOfUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void getDetailsOfUser(Users Users){
         UserService.getDetailsofUsers(Users.getUsername());
    }



    @Path("/createUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createUser(Users User){
        UserService.createUsers(User);
    }

    @Path ("/deleteUser")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUser(Users User){
        UserService.deleteUser(User.getId());
    }

    @Path ("/updatePasswordUser")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateNameUser(Users User){
        UserService.updateUserPassword(User.getId(),User.getPassword());
    }
    @Path ("/updateNameUser")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateEmailUser(Users User){
        UserService.updateUserUsername(User.getId(),User.getUsername());
    }}
