import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;


@Path("/test")
public class Oefen {
        @Path("/oefen1")
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public String oefen1(){
            return "Hi";
        }

        @Path ("/oefen2")
        @POST
        @Produces(MediaType.APPLICATION_JSON)
        public void oefen2(){}



        @Path ("/oefen3")
        @DELETE
        @Produces(MediaType.APPLICATION_JSON)
        public void oefen3(){}

        @Path ("/oefen4")
        @PUT
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public void oefen4(){}

    }

