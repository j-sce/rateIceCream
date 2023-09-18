package rateIceCream.core.services.iceCreamServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.jpa.JpaIceCreamRepository;
import rateIceCream.core.requests.iceCreamRequests.RemoveIceCreamRequest;
import rateIceCream.core.responses.iceCreamResponses.RemoveIceCreamResponse;
import rateIceCream.core.validators.iceCreamValidators.RemoveIceCreamRequestValidator;

import java.util.List;

@Component
@Transactional
public class RemoveIceCreamService {

    @Autowired
    private JpaIceCreamRepository iceCreamRepository;

    @Autowired
    private RemoveIceCreamRequestValidator validator;

    public RemoveIceCreamResponse execute(RemoveIceCreamRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveIceCreamResponse(errors);
        }
        iceCreamRepository.deleteById(request.getIceCreamIdToRemove());
        return new RemoveIceCreamResponse(true);
    }
}
