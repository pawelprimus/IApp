package pl.prim.iapp.weight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prim.iapp.user.User;

import java.util.Collection;
import java.util.List;

@Repository
interface WeightRepository extends JpaRepository<Weight, Long> {
    List<Weight> findAllByUser(User user);
}
