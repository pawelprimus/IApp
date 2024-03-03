package pl.prim.iapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.prim.iapp.model.HelloWorld;
import pl.prim.iapp.service.HelloWorldService;

import java.util.List;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

    @Autowired
    HelloWorldService helloWorldService;

    @PostMapping()
    ResponseEntity<?> create() {
        helloWorldService.create();
        return ResponseEntity.ok("");
    }

    //@ApiOperation(value = "Hello world value",
    //            notes = "Hello world notes")
    @GetMapping(value = "/getHello", produces = "application/json")
    public ResponseEntity<?> getAll() {
        List<HelloWorld> hellos = helloWorldService.findAll();
        return ResponseEntity.ok(hellos);
    }

}
