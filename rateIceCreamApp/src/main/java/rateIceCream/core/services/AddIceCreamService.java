package rateIceCream.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rateIceCream.core.domain.IceCream;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.Database;
import rateIceCream.core.requests.AddIceCreamRequest;
import rateIceCream.core.responses.AddIceCreamResponse;
import rateIceCream.core.validators.AddIceCreamRequestValidator;

import java.util.List;

@Component
public class AddIceCreamService {

    @Autowired
    private Database database;

    @Autowired
    private AddIceCreamRequestValidator validator;

    public AddIceCreamResponse execute(AddIceCreamRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddIceCreamResponse(errors);
        }
        IceCream iceCream = new IceCream(request.getName(), request.getProducer(), request.getBarcode());
        database.save(iceCream);

        return new AddIceCreamResponse(iceCream);
    }
}
