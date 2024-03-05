package pl.prim.iapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prim.iapp.model.HelloWorld;
import pl.prim.iapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

}
