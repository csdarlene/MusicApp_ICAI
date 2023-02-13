package app;

import entity.*;
import service.*;
import userInput.*;
import java.util.*;

public class HomeInput {
    UserDetails ud1;
    UserService userService = new UserService();
    UserDetailService userDetailService = new UserDetailService();
    String username;
    Scanner scanner;
    String search;
    AlbumService albumService = new AlbumService();
    ArtistService artistService = new ArtistService();
    SongService songService = new SongService();
    PlaylistService playlistService = new PlaylistService();


    public void frontPage() {
        try {
            scanner = new Scanner(System.in);
            System.out.println("--------Welcome--------\n1- Sign In \n2- Sign Up\n0- Quit");
            new Scanner(System.in);
            do {
                int option = scanner.nextInt();
                switch (option) {
                    case 1 -> {
                        scanner = new Scanner(System.in);
                        System.out.print("Enter username: ");
                        username = scanner.nextLine().toLowerCase();

                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();

                        signIn(username, password);
                        homePage();
                    }
                    case 2 -> signUp();
                    case 0 -> System.exit(0);
                    default -> System.out.println("Invalid option");
                }
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public void signIn(String username,String password) {
        if (("admin".equals(username)) && ("ADMIN".equals(password))) {
            maintenance();
        }
        for (Users u : userService.getAllUsers()) {
            if ((u.getUsername().equals(username)) && u.getPassword().equals(password)) {
                System.out.println(".....Signing in.....");
                return;
            }
        }
        System.out.println("Username and/or password is incorrect");
        frontPage();
    }

    public void maintenance() {
        try {
            String entities = """
                    1- Albums\s
                    2- Artists
                    3- Playlists\s
                    4- Record Label
                    5- Songs
                    6- User Details\s
                    7- Users
                    0- Exit
                    """;

            scanner = new Scanner(System.in);
            System.out.println(entities);
            int opt;
            do {
                opt = scanner.nextInt();
                switch (opt) {
                    case 0 -> System.exit(0);
                    case 1 -> AlbumInput.albumMenu();
                    case 2 -> ArtistInput.artistMenu();
                    case 3 -> PlaylistInput.playlistMenu();
                    case 4 -> RecordLabelInput.recordLabelMenu();
                    case 5 -> SongInput.songMenu();
                    case 6 -> UserDetailInput.userDetailMenu();
                    case 7 -> UserInput.userMenu();
                    default -> System.out.println("Invalid option");
                }
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public void signUp() {
        createUser();
        if (createUser() == 1) {
            homePage();
        } else {
            signUp();
        }
    }

    public void createUserDetail() {

        InputChecker inputChecker = new InputChecker();
        scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter mail: ");
        String email = scanner.nextLine();

        if (Objects.equals(email, inputChecker.MailCheck(email))) {

            System.out.print("Enter birthday(DD-MM-YY): ");
            String birthday = scanner.nextLine();

            if (Objects.equals(birthday, inputChecker.BirthdayCheck(birthday))) {

                for (UserDetails ud : userDetailService.getAllUserDetails()) {
                    if (!(ud.getEmail().equals(email))) {
                        ud1 = new UserDetails(name, birthday, email);
                        userDetailService.createUserDetails(ud1);
                        return;
                    }
                }
            } else {
                System.out.println("Invalid birthday\n Try again");
                createUserDetail();
            }


        } else {
            System.out.println("Invalid email\n Try again");
            createUserDetail();
        }

    }

    public int createUser() {
        scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        username = scanner.nextLine().toLowerCase();
        for (Users u : userService.getAllUsers()) {
            if ((u.getUsername().equals(username))) {
                System.out.println("Choose a different username");
                return 0;
            }
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        createUserDetail();
        Users u1 = new Users(username, password, ud1);
        userService.createUsers(u1);
        System.out.println(".....Signing in.....");
        return 1;
    }

    public void homePage() {
        try {
            String account = """
                    1- Search\s
                    2- List playlists
                    3- Select playlist
                    4- Upload a Song
                    5- Edit account
                    0- Exit
                    """;

            scanner = new Scanner(System.in);
            System.out.println(account);
            int opt;
            do {
                opt = scanner.nextInt();
                switch (opt) {
                    case 0 -> System.exit(0);
                    case 1 -> {
                        Search();
                        System.out.println(account);
                    }
                    case 2 -> {
                        playlistService.getUserPlaylist(username);
                        System.out.println(account);
                    }
                    case 3 -> {
                        PlaylistInput.selectPlaylist();
                        System.out.println(account);
                    }
                    case 4 -> {
                        SongInput.insertSong();
                        System.out.println(account);
                    }
                    case 5 -> {
                        UserInput.updateUserByUser();
                        System.out.println(account);
                    }
                    default -> System.out.println("Invalid option");
                }
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public void Search() {
        String menuHome = """
                Search
                1- Album
                2- Artist
                3- Song
                4- Account
                5- Go back
                0- Exit
                """;
        try {
            scanner = new Scanner(System.in);
            System.out.println(menuHome);
            int opt;
            do {
                opt = scanner.nextInt();
                switch (opt) {
                    case 0 -> System.exit(0);
                    case 1 -> {
                        System.out.println("Search Album: ");
                        scanner = new Scanner(System.in);
                        search = scanner.nextLine().toLowerCase();
                        for (Albums albums : albumService.getAllAlbums()) {
                            if (((albums.getName().toLowerCase()).equals(search))) {
                                Long id1 = albums.getId();
                                albumService.findAlbums(id1);
                                return;
                            }
                        }
                        System.out.println("Could not find album\n");
                        System.out.println(menuHome);
                    }
                    case 2 -> {
                        System.out.println("Search Artist: ");
                        scanner = new Scanner(System.in);
                        search = scanner.nextLine().toLowerCase();
                        for (Artists artists : artistService.getAllArtists()) {
                            if (((artists.getName().toLowerCase()).equals(search))) {
                                Long id2 = artists.getId();
                                artistService.findArtist(id2);
                                return;
                            }
                        }
                        System.out.println("Could not find artist\n");
                        System.out.println("\n" + menuHome);
                    }
                    case 3 -> {
                        System.out.println("Search Song: ");
                        scanner = new Scanner(System.in);
                        search = scanner.nextLine().toLowerCase();
                        for (Songs songs : songService.getAllSongs()) {
                            if (((songs.getName().toLowerCase()).equals(search))) {
                                Long id3 = songs.getId();
                                songService.findSong(id3);
                                return;
                            }
                        }
                        System.out.println("Could not find song\n");
                        System.out.println("\n" + menuHome);
                    }
                    case 4 -> {
                        System.out.println("Search Account:");
                        scanner = new Scanner(System.in);
                        search = scanner.nextLine().toLowerCase();
                        userService.getDetailsofUsers(search);
                        System.out.println("\n" + menuHome);
                    }
                    case 5 -> homePage();
                    default -> System.out.println("Invalid option");
                }
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }
}
