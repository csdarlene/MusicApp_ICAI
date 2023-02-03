package controller;

import entity.Playlists;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import service.PlaylistService;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("Playlists")
public class PlaylistController{
    private final PlaylistService playlistService = new PlaylistService();

    @Path("/readPlaylists")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlists> readPlaylists(){
        return playlistService.getAllPlaylists();
    }

    @Path ("/getPlaylist")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Playlists getPlaylist(Playlists playlists){
        return playlistService.findPlaylist(playlists.getId());
    }

    @Path ("/getUserPlaylist")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void getUserPlaylist(Playlists playlists){
         playlistService.getUserPlaylist(playlists.getName());
    }

    @Path("/createPlaylist")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createPlaylist(Playlists playlists){
        playlistService.createPlaylists(playlists);
    }

    @Path ("/deletePlaylist")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePlaylist(Playlists playlists){
        playlistService.deletePlaylist(playlists.getId());
    }

    @Path ("/updatePlaylist")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updatePlaylist(Playlists playlists){
        playlistService.updatePlaylistName(playlists.getId(),playlists.getName());
    }}