package rateIceCream.core.services.iceCreamServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.database.jpa.JpaIceCreamRepository;
import rateIceCream.core.domain.IceCream;
import rateIceCream.core.requests.iceCreamRequests.GetAllIceCreamsRequest;
import rateIceCream.core.responses.iceCreamResponses.GetAllIceCreamsResponse;

import java.util.List;

@Component
@Transactional
public class GetAllIceCreamsService {

    @Autowired
    private JpaIceCreamRepository iceCreamRepository;

    public GetAllIceCreamsResponse execute(GetAllIceCreamsRequest request) {
        List<IceCream> iceCreams = iceCreamRepository.findAll();
        return new GetAllIceCreamsResponse(iceCreams);
    }
}
