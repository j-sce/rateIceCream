package rateIceCream.services;

import rateIceCream.IceCream;
import rateIceCream.database.Database;

import java.util.List;

public class GetAllIceCreamsService {

    private Database database;

    public GetAllIceCreamsService(Database database) {
        this.database = database;
    }

    public List<IceCream> execute() {
        return database.getAllIceCreams();
    }
}
