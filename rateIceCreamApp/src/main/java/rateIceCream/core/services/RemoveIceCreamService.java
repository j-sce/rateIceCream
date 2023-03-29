package rateIceCream.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.Database;
import rateIceCream.core.requests.RemoveIceCreamRequest;
import rateIceCream.core.responses.RemoveIceCreamResponse;
import rateIceCream.core.validators.RemoveIceCreamRequestValidator;

import java.util.List;

@Component
public class RemoveIceCreamService {

    @Autowired
    private Database database;

    @Autowired
    private RemoveIceCreamRequestValidator validator;

    public RemoveIceCreamResponse execute(RemoveIceCreamRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveIceCreamResponse(errors);
        }
        boolean isIceCreamRemoved = database.deleteById(request.getIceCreamIdToRemove());
        return new RemoveIceCreamResponse(isIceCreamRemoved);
    }
}
