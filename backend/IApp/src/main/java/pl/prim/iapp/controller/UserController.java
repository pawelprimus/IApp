package pl.prim.iapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.prim.iapp.model.HelloWorld;
import pl.prim.iapp.model.User;
import pl.prim.iapp.model.dto.CreateUserDto;
import pl.prim.iapp.service.HelloWorldService;
import pl.prim.iapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/helloworld")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    ResponseEntity<?> create(CreateUserDto createUserDto) {
        User user = userService.createUser(createUserDto);

        return ResponseEntity.ok(user);
    }

    //@ApiOperation(value = "Hello world value",
    //            notes = "Hello world notes")
    @GetMapping(value = "/getByUsername", produces = "application/json")
    public ResponseEntity<?> get(String userName) {
        User user = userService.findByUserName(userName);
        return ResponseEntity.ok(user);
    }

}
