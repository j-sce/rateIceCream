package rateIceCream.core.services.iceCreamServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.IceCreamRepository;
import rateIceCream.core.domain.IceCream;
import rateIceCream.core.requests.iceCreamRequests.GetIceCreamRequest;
import rateIceCream.core.responses.iceCreamResponses.GetIceCreamResponse;
import rateIceCream.core.validators.iceCreamValidators.GetIceCreamRequestValidator;

import java.util.List;

@Component
@Transactional
public class GetIceCreamService {

    @Autowired
    private IceCreamRepository iceCreamRepository;

    @Autowired
    private GetIceCreamRequestValidator validator;

    public GetIceCreamResponse execute(GetIceCreamRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new GetIceCreamResponse(errors);
        }
        IceCream iceCream = iceCreamRepository.findById(request.getIceCreamId());
        return new GetIceCreamResponse(iceCream);
    }

}
