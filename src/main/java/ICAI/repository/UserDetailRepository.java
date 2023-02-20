package ICAI.repository;

import ICAI.entity.UserDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class UserDetailRepository {

    private final EntityManager entityManager;

    public UserDetailRepository( EntityManager entityManager ) {
        this.entityManager = entityManager;
    }

    public List<UserDetails> getAllUserDetails() {
        String query = "select ud from UserDetails ud";
        TypedQuery<UserDetails> typedQuery = entityManager.createQuery(query, UserDetails.class);
        return typedQuery.getResultList();
    }

    public void createUserDetails( UserDetails userDetails ) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userDetails);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

    }

    public void updateUserDetailName( Long id, String name) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        UserDetails userDetails = entityManager.find(UserDetails.class, id);
        userDetails.setName(name);
        System.out.println(userDetails);
        entityManager.getTransaction().commit();

    }

    public void deleteUserDetail( Long id) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();
        UserDetails userDetails = entityManager.find(UserDetails.class, id);
        System.out.println(userDetails.getName()+ " has been removed \n");
        entityManager.remove(userDetails);

        entityManager.getTransaction().commit();
    }

    public void updateUserDetailEmail( Long id, String mail) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        UserDetails userDetails = entityManager.find(UserDetails.class, id);
        userDetails.setEmail(mail);
        System.out.println(userDetails);
        entityManager.getTransaction().commit();

    }
}
