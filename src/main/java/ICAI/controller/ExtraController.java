package ICAI.controller;

import ICAI.entity.Users;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import ICAI.service.UserService;

import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

@Path("extra")
public class ExtraController {
    private final UserService userService = new UserService();
    @Path("/signin")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void SignIn(Users users) {
        userService.signIn(users.getUsername(),users.getPassword());
    }
}
