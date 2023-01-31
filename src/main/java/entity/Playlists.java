package entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Playlists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Users user;

    @ManyToMany(cascade= CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable( name="playlist_songs",
                joinColumns = {@JoinColumn(name = "playlist_id")},
                inverseJoinColumns = {@JoinColumn(name = "song_id")},
                uniqueConstraints = {
            @UniqueConstraint(columnNames = {"playlist_id", "song_id"})})

    private Set<Songs> songSet = new HashSet<>();

    public Playlists( String name, Users user_id ) {
        this.name = name;
        this.user = user_id;
    }

    public Playlists( Long id, String name, Set<Songs> songSet ) {
        this.id = id;
        this.name = name;
        this.songSet = songSet;
    }

    public Playlists() {
    }

    public Set<Songs> getSongSet() {
        return songSet;
    }

    public Users getUserID() {
        return user;
    }

    public void setUserID( Users userID ) {
        this.user = userID;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Playlists: " +
                "id=" + id +
                ", name= " + name  +
                ", user = " + user +
                "songs: "+getSongSet()+"\n";
    }

}
