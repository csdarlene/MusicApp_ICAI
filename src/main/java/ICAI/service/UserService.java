package ICAI.service;

import ICAI.configuration.JPAConfiguration;
import ICAI.entity.Users;
import ICAI.repository.UserRepository;
import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository(JPAConfiguration.getEntityManager());
    }

    public List<Users> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void createUsers( Users users ) {
        userRepository.createUsers(users);
    }

    public Users findUser( Long id ) {
        return userRepository.findUser(id);
    }

    public void deleteUser( Long id ) {
        userRepository.deleteUser(id);
    }

    public void updateUserUsername( Long id, String username ) {
        userRepository.updateUserUsername(id, username);
    }

    public void updateUserPassword( Long id, String password ) {
        userRepository.updateUserPassword(id, password);
    }

    public void getDetailsofUsers( String  username) {
        userRepository.getDetailsofUsers(username);
    }


    public boolean signIn(String username,String password) {
        return userRepository.signIn(username, password);

    }

}
