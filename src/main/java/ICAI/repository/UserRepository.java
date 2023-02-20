package ICAI.repository;

import ICAI.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ICAI.service.UserService;

import java.util.List;


public class UserRepository {

    private final EntityManager entityManager;
    UserService userService = new UserService();

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Users> getAllUsers() {
        String query = "select u from Users u";
        TypedQuery<Users> typedQuery = entityManager.createQuery(query, Users.class);
        return typedQuery.getResultList();
    }

    public void createUsers(Users users) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(users);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

    }

    public Users findUser(Long id) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();
        Users users = entityManager.find(Users.class, id);
        System.out.println(users.toString());
        entityManager.getTransaction().commit();
        return users;
    }

    public void updateUserUsername(Long id, String username) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        Users users = entityManager.find(Users.class, id);
        users.setUsername(username);
        System.out.println(users.toString());
        entityManager.getTransaction().commit();

    }

    public void deleteUser(Long id) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();
        Users users = entityManager.find(Users.class, id);
        System.out.println(users.getUsername() + " has been removed \n");
        entityManager.remove(users);

        entityManager.getTransaction().commit();
    }

    public void updateUserPassword(Long id, String password) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        Users users = entityManager.find(Users.class, id);
        users.setPassword(password);
        System.out.println(users);
        entityManager.getTransaction().commit();

    }

    public void getDetailsofUsers(String name) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();
        TypedQuery<ICAI.entity.Users> query = entityManager.createQuery("from Users u JOIN UserDetails ud ON ud.id = u.userDetails.id where u.userDetails.name =?1", ICAI.entity.Users.class);
        query.setParameter(1, name);

        List<ICAI.entity.Users> users = query.getResultList();
        System.out.println(users);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public boolean signIn(String username, String password) {
        if (("admin".equals(username)) && ("ADMIN".equals(password))) {
            return true;
        }
        for (Users u : userService.getAllUsers()) {
            if ((u.getUsername().equals(username)) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}

