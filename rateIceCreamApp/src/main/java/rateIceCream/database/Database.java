package rateIceCream.database;

import rateIceCream.IceCream;

import java.util.List;

public interface Database {

    void save(IceCream iceCream);

    void deleteById(Long id);//TODO in the future method will delete by ID:   void deleteById(Long id);

    List<IceCream> getAllIceCreams();

}
