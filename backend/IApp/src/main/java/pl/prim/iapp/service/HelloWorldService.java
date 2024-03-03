package pl.prim.iapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.prim.iapp.model.HelloWorld;
import pl.prim.iapp.repo.HelloWorldRepo;

import java.util.List;

@Service
public class HelloWorldService {

    @Autowired
    HelloWorldRepo helloWorldRepo;

    @Transactional
    public void create() {
        HelloWorld helloWorld = new HelloWorld("Hello");
        helloWorldRepo.save(helloWorld);
    }

    public List<HelloWorld> findAll() {
        List<HelloWorld> helloWorlds = helloWorldRepo.findAll().stream().toList();
        if (helloWorlds.isEmpty()) {
            throw new IllegalStateException("Hello does not exist");
        }
        return helloWorlds;
    }
}
