package pl.prim.iapp.user;


import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User createUser(NewUserDto newUser) {
        checkIfUserExists(newUser.userName());
        User user = newUser.toUser(passwordEncoder.encode(newUser.password()));

        return userRepository.save(user);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(User::toDto).toList();
    }

    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .map(User::toDto)
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public UserDto findByUserName(String userName) {
        return userRepository.findByUserName(userName).map(User::toDto)
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long userId, UpdateUserDto updateUserDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));

        user.update(passwordEncoder.encode(updateUserDto.password()));

        return userRepository.save(user);
    }


    private void checkIfUserExists(String userName) {
        if (userRepository.findByUserName(userName).isPresent()) {
            throw new RuntimeException("User with give username already exists!");
        }
    }

    @PostConstruct
    public void init() {
        try {
            userRepository.save(new User("user1", passwordEncoder.encode("password")));
            userRepository.save(new User("user2", passwordEncoder.encode("password")));
            userRepository.save(new User("user3", passwordEncoder.encode("password")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
