package ICAI.repository;

import ICAI.entity.Albums;
import jakarta.persistence.*;
import java.util.List;

public class AlbumRepository {
    private final EntityManager entityManager;

    public AlbumRepository( EntityManager entityManager ) {
        this.entityManager = entityManager;
    }

    public List<Albums> getAllAlbums() {
        String query = "select al from Albums al";
        TypedQuery<Albums> typedQuery = entityManager.createQuery(query, Albums.class);
        return typedQuery.getResultList();
    }

    public void createAlbums( Albums album ) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(album);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public Albums findAlbum(Long id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unasat_persistence");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Albums albums = entityManager.find(Albums.class, id);
        System.out.println(albums.toString());
        entityManager.getTransaction().commit();
        return albums;
        }

    public void updateAlbumName( Long id, String name) {
    entityManager.getEntityManagerFactory();
        entityManager.getTransaction().begin();

        Albums albums = entityManager.find(Albums.class, id);
        albums.setName(name);
        System.out.println(albums);
        entityManager.getTransaction().commit();

    }

    public void deleteAlbum( Long id) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();
        Albums albums = entityManager.find(Albums.class, id);
        System.out.println(albums.getName()+ " has been removed \n");
        entityManager.remove(albums);

        entityManager.getTransaction().commit();
    }

    public void updateAlbumYear( Long id, Integer year) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        Albums albums = entityManager.find(Albums.class, id);
        albums.setYear(year);
        System.out.println(albums);
        entityManager.getTransaction().commit();

    }

}