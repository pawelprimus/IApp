package pl.prim.iapp.weight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface WeightRepository extends JpaRepository<Weight, Long> {
}
