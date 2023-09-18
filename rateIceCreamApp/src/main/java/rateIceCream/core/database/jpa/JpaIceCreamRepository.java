package rateIceCream.core.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rateIceCream.core.domain.IceCream;

import java.util.List;

@Repository
public interface JpaIceCreamRepository extends JpaRepository<IceCream, Long> {

    List<IceCream> findByName(String name);

    List<IceCream> findByProducer(String producer);

    List<IceCream> findByNameAndProducer(String name, String producer);

    List<IceCream> findByBarcode(String barcode);


}
