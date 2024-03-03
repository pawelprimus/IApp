package pl.prim.iapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prim.iapp.model.HelloWorld;

@Repository
public interface HelloWorldRepo extends JpaRepository<HelloWorld, Long> {
}
