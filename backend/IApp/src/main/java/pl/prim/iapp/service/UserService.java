package pl.prim.iapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.prim.iapp.model.HelloWorld;
import pl.prim.iapp.model.User;
import pl.prim.iapp.model.dto.CreateUserDto;
import pl.prim.iapp.repo.HelloWorldRepo;
import pl.prim.iapp.repo.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Transactional
    public User createUser(CreateUserDto createUserDto) {
        User entity = User.builder()
                .userName(createUserDto.getUserName())
                .password(bCryptPasswordEncoder.encode(createUserDto.getPassword()))
                .build();

        return userRepository.save(entity);
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


}
