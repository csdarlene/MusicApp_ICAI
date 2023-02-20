package ICAI.controller;

import ICAI.entity.Users;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import ICAI.service.UserService;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("users")
public class UserController {
    private final UserService userService = new UserService();

    @Path("/readUsers")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> readUsers() {
        return userService.getAllUsers();
    }

    @Path("/getUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Users getUser(Users Users) {
        return userService.findUser(Users.getId());
    }

    @Path("/getDetailsOfUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void getDetailsOfUser(Users Users) {
        userService.getDetailsofUsers(Users.getUsername());
    }


    @Path("/createUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createUser(Users User) {
        userService.createUsers(User);
    }

    @Path("/deleteUser")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUser(Users User) {
        userService.deleteUser(User.getId());
    }

    @Path("/updatePasswordUser")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateNameUser(Users User) {
        userService.updateUserPassword(User.getId(), User.getPassword());
    }

    @Path("/updateNameUser")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateEmailUser(Users User) {
        userService.updateUserUsername(User.getId(), User.getUsername());
    }

    @Path("/signIn")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean SignIn(String username,String password) {
       return userService.signIn(username, password);
    }
}
