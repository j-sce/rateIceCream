package rateIceCream.core.services.iceCreamServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.jpa.JpaIceCreamRepository;
import rateIceCream.core.domain.IceCream;
import rateIceCream.core.requests.iceCreamRequests.AddIceCreamRequest;
import rateIceCream.core.responses.iceCreamResponses.AddIceCreamResponse;
import rateIceCream.core.validators.iceCreamValidators.AddIceCreamRequestValidator;

import java.util.List;

@Component
@Transactional
public class AddIceCreamService {

    @Autowired
    private JpaIceCreamRepository iceCreamRepository;

    @Autowired
    private AddIceCreamRequestValidator validator;

    public AddIceCreamResponse execute(AddIceCreamRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddIceCreamResponse(errors);
        }
        IceCream iceCream = new IceCream(request.getName(), request.getProducer(), request.getBarcode());
        iceCreamRepository.save(iceCream);

        return new AddIceCreamResponse(iceCream);
    }
}
