package ICAI.app;


import ICAI.service.PlaylistService;
import ICAI.service.SongService;
import ICAI.entity.Songs;
import java.util.Scanner;

public class App {
//    public static void main(String[] args) {
        HomeInput HI = new HomeInput();
        Data data = new Data();
        PlaylistService playlistService = new PlaylistService();
        SongService songService = new SongService();

//        // Step 1
//        // Dummy Data
//        data.infromation();
//        playlistService.getUserPlaylist("darlene111");    //  insert Many To many Dummy Data


//        //Step 2
//        // Applicatie
//        HI.frontPage();

        //Step 3
        // Play all the songs in database
//        for (Songs songs : songService.getAllSongs()) {
//            PlayMusic playlist = new PlayMusic();
//
//            playlist.Play(songs.getName());
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Next song");
//            String next = scanner.nextLine();
//        }
//        System.out.println("Done");
//    }
}


