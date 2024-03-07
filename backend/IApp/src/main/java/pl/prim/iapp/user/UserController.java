package pl.prim.iapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    ResponseEntity<?> create(NewUser newUser) {
        User user = userService.createUser(newUser);
        return ResponseEntity.ok(user);
    }

    //@ApiOperation(value = "Hello world value",
    //            notes = "Hello world notes")
    @GetMapping(value = "/getByUsername", produces = "application/json")
    public ResponseEntity<?> get(String userName) {
        User user = userService.findByUserName(userName);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(value = "/delete", produces = "application/json")
    public ResponseEntity<?> delete(Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted");
    }

    @GetMapping(value = "/getById", produces = "application/json")
    public ResponseEntity<?> getById(Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }



}
