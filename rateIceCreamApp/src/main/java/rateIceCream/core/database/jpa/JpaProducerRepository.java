package rateIceCream.core.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rateIceCream.core.domain.Producer;

import java.util.List;

@Repository
public interface JpaProducerRepository extends JpaRepository<Producer, Long> {

    List<Producer> findByName(String name);

}
