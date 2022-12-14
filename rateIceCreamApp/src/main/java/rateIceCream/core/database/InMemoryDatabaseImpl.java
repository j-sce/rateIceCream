package rateIceCream.core.database;

import rateIceCream.IceCream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryDatabaseImpl implements Database {

    private List<IceCream> iceCreams = new ArrayList<>();
    private long nextId = 1L;


    @Override
    public void save(IceCream iceCream) {
        iceCream.setId(nextId);
        nextId++;
        iceCreams.add(iceCream);
    }

    @Override
    public boolean deleteById(long id) {
        boolean isIceCreamRemoved = false;
        Optional<IceCream> iceCreamToDeleteOpt = iceCreams.stream()
                .filter(iceCream -> iceCream.getId() == (id)).findFirst();
        if (iceCreamToDeleteOpt.isPresent()) {
            IceCream iceCreamToRemove = iceCreamToDeleteOpt.get();
            isIceCreamRemoved = iceCreams.remove(iceCreamToRemove);
        }
        return isIceCreamRemoved;
    }

    @Override
    public List<IceCream> getAllIceCreams() {
        return iceCreams;
    }

    @Override
    public List<IceCream> findByName(String name) {
        return iceCreams.stream()
                .filter(iceCream -> iceCream.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<IceCream> findByProducer(String producer) {
        return iceCreams.stream()
                .filter(iceCream -> iceCream.getProducer().equals(producer))
                .collect(Collectors.toList());
    }

    @Override
    public List<IceCream> findByNameAndProducer(String name, String producer) {
        return iceCreams.stream()
                .filter(iceCream -> iceCream.getName().equals(name))
                .filter(iceCream -> iceCream.getProducer().equals(producer))
                .collect(Collectors.toList());
    }

    @Override
    public List<IceCream> findByBarcode(long barcode) {
        return iceCreams.stream()
                .filter(iceCream -> iceCream.getBarcode() == barcode)
                .collect(Collectors.toList());
    }
}
