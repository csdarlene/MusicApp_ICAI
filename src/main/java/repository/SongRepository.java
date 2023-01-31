package repository;

import entity.Songs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class SongRepository {
    private final EntityManager entityManager;

    public SongRepository( EntityManager entityManager ) {
        this.entityManager = entityManager;
    }

    public List<Songs> getAllSongs() {
        String query = "select s from Songs s";
        TypedQuery<Songs> typedQuery = entityManager.createQuery(query, Songs.class);
        return typedQuery.getResultList();
    }

    public void createSongs( Songs songs ) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(songs);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

    }

    public Songs findSong( Long id ) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();
        Songs songs = entityManager.find(Songs.class, id);
        System.out.println(songs.toString());
        entityManager.getTransaction().commit();
        return songs;
    }

    public void updateSongName( Long id, String name ) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        Songs songs = entityManager.find(Songs.class, id);
        songs.setName(name);
        System.out.println(songs);
        entityManager.getTransaction().commit();

    }

    public void deleteSong( Long id ) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();
        Songs songs = entityManager.find(Songs.class, id);
        System.out.println(songs.getName() + " has been removed \n");
        entityManager.remove(songs);

        entityManager.getTransaction().commit();
    }

    public void getArtistSong( String song ) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();
        TypedQuery<entity.Songs> query = entityManager.createQuery("select s.artistSet from Songs s where s.name =?1", entity.Songs.class);

        query.setParameter(1, song );

        List<entity.Songs> songs = query.getResultList();
        System.out.println(songs);
        entityManager.getTransaction().commit();
        entityManager.close();

    }


 }


