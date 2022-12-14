package rateIceCream.core.database;

import rateIceCream.IceCream;

import java.util.List;

public interface Database {

    void save(IceCream iceCream);

    boolean deleteById(long id);

    List<IceCream> getAllIceCreams();

    List<IceCream> findByName(String name);

    List<IceCream> findByProducer(String producer);

    List<IceCream> findByNameAndProducer(String name, String producer);

    List<IceCream> findByBarcode(long barcode);

}
