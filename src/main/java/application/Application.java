package application;

import entity.Songs;
import service.PlaylistService;
import service.SongService;
import java.util.Scanner;

public class Application {
    public static void main( String[] args ) {
        HomeInput HI = new HomeInput();
        Data data = new Data();
        PlaylistService playlistService = new PlaylistService();
//
//        // Step 1
        // Dummy Data
//        data.infromation();
//        playlistService.getUserPlaylist("darlene111");    //  insert Many To many Dummy Data


        //Step 2
        // Applicatie
        HI.frontPage();

//        //Step 3
//        // Play all the songs in database
//        SongService songService = new SongService();
//        for (Songs songs : songService.getAllSongs()) {
//            PlayMusic playlist = new PlayMusic();
//
//            playlist.Play(songs.getName());
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Next song");
//            String next = scanner.nextLine();
//        }
//        System.out.println("Done");


    }
}


