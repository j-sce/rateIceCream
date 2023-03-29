package rateIceCream.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rateIceCream.core.domain.IceCream;
import rateIceCream.core.database.Database;
import rateIceCream.core.requests.GetAllIceCreamsRequest;
import rateIceCream.core.responses.GetAllIceCreamsResponse;

import java.util.List;

@Component
public class GetAllIceCreamsService {

    @Autowired
    private Database database;

    public GetAllIceCreamsResponse execute(GetAllIceCreamsRequest request) {
        List<IceCream> iceCreams = database.getAllIceCreams();
        return new GetAllIceCreamsResponse(iceCreams);
    }
}
