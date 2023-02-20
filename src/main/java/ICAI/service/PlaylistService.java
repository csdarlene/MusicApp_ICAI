package ICAI.service;

import ICAI.configuration.JPAConfiguration;
import ICAI.entity.Playlists;
import ICAI.repository.PlaylistRepository;
import java.util.List;

public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public PlaylistService() {
        this.playlistRepository = new PlaylistRepository(JPAConfiguration.getEntityManager());
    }

    public List<Playlists> getAllPlaylists() {
        return playlistRepository.getAllPlaylists();
    }

    public void getUserPlaylist( String  username) {
        playlistRepository.getUserPlaylist(username);
    }

    public void createPlaylists( Playlists playlist ) {
        playlistRepository.createPlaylists(playlist);
    }

    public void deletePlaylist( Long id ) {
        playlistRepository.deletePlaylist(id);
    }

    public void updatePlaylistName( Long id, String name ) {
        playlistRepository.updatePlaylistName(id, name);
    }

    public Playlists findPlaylist(Long id) {

        return playlistRepository.findPlaylist(id);
    }}
