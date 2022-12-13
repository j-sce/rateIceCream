package rateIceCream.database;

import rateIceCream.IceCream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InMemoryDatabaseImpl implements Database {

    private List<IceCream> iceCreams = new ArrayList<>();
    private Long nextId = 1L;


    @Override
    public void save(IceCream iceCream) {
        iceCream.setId(nextId);
        nextId++;
        iceCreams.add(iceCream);
    }

    @Override
    public void deleteById(Long id) {
        iceCreams.stream()
                .filter(iceCream -> Objects.equals(iceCream.getId(), id))
                .findFirst()
                .ifPresent(iceCream -> iceCreams.remove(iceCream));
    }

    @Override
    public List<IceCream> getAllIceCreams() {
        return iceCreams;
    }
}
