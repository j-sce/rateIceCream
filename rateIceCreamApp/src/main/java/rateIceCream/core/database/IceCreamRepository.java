package rateIceCream.core.database;

import rateIceCream.core.domain.IceCream;

import java.util.List;

public interface IceCreamRepository {

    void save(IceCream iceCream);

    boolean deleteById(Long id);

    List<IceCream> getAllIceCreams();

    List<IceCream> findByName(String name);

    List<IceCream> findByProducer(String producer);

    List<IceCream> findByNameAndProducer(String name, String producer);

    List<IceCream> findByBarcode(String barcode);

    IceCream findById(Long id);

}
