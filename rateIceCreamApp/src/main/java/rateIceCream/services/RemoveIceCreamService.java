package rateIceCream.services;

import rateIceCream.database.Database;

public class RemoveIceCreamService {
    private Database database;

    public RemoveIceCreamService(Database database) {
        this.database = database;
    }

    public void execute(Long iceCreamId) {
        database.deleteById(iceCreamId);
    }
}
