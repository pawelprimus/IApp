package pl.prim.iapp.user;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional
    public User createUser(NewUser newUser) {
        checkIfUserExists(newUser.userName());

        return userRepository.save(newUser.toUser());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    private void checkIfUserExists(String userName) {
        if (userRepository.findByUserName(userName) != null) {
            throw new RuntimeException("User already exists");
        }
    }




}
