package controller;

import entity.Songs;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import service.SongService;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("Songs")
public class SongController{
    private final SongService songService = new SongService();

    @Path("/readSongs")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Songs> readSongs(){
        return songService.getAllSongs();
    }

    @Path ("/getSong")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Songs getSong(Songs songs){
        return songService.findSong(songs.getId());
    }
    @Path ("/getSongArtist")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void getSongArtsit(Songs songs){
         songService.getArtistSong(songs.getName());
    }

    @Path("/createSong")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createSong(Songs Songs){
        songService.createSongs(Songs);
    }

    @Path ("/deleteSong")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteSong(Songs songs){
        songService.deleteSong(songs.getId());
          }

    @Path ("/updateSong")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateSong(Songs songs){
        songService.updateSongName(songs.getId(),songs.getName());
    }}