package rateIceCream.services;

import rateIceCream.IceCream;
import rateIceCream.database.Database;

public class AddIceCreamService {

    private Database database;

    public AddIceCreamService(Database database) {
        this.database = database;
    }

    public void execute(String iceCreamName, String iceCreamProducer, long iceCreamVolume) {
        IceCream iceCream = new IceCream(iceCreamName, iceCreamProducer, iceCreamVolume);
        database.save(iceCream);
    }
}
