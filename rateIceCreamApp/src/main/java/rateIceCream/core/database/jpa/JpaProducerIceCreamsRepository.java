package rateIceCream.core.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rateIceCream.core.domain.ProducerIceCreams;

@Repository
public interface JpaProducerIceCreamsRepository extends JpaRepository<ProducerIceCreams, Long> {

}
