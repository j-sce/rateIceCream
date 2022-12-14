package rateIceCream.core.services;

import rateIceCream.IceCream;
import rateIceCream.core.database.Database;
import rateIceCream.core.requests.GetAllIceCreamsRequest;
import rateIceCream.core.responses.GetAllIceCreamsResponse;

import java.util.List;

public class GetAllIceCreamsService {

    private Database database;

    public GetAllIceCreamsService(Database database) {
        this.database = database;
    }

    public GetAllIceCreamsResponse execute(GetAllIceCreamsRequest request) {
        List<IceCream> iceCreams = database.getAllIceCreams();
        return new GetAllIceCreamsResponse(iceCreams);
    }
}
