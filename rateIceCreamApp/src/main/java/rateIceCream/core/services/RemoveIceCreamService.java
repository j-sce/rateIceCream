package rateIceCream.core.services;

import rateIceCream.core.CoreError;
import rateIceCream.core.database.Database;
import rateIceCream.core.requests.RemoveIceCreamRequest;
import rateIceCream.core.responses.RemoveIceCreamResponse;
import rateIceCream.core.validators.RemoveIceCreamRequestValidator;

import java.util.List;

public class RemoveIceCreamService {
    private Database database;

    private RemoveIceCreamRequestValidator validator;

    public RemoveIceCreamService(Database database, RemoveIceCreamRequestValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public RemoveIceCreamResponse execute(RemoveIceCreamRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveIceCreamResponse(errors);
        }
        boolean isIceCreamRemoved = database.deleteById(request.getIceCreamIdToRemove());
        return new RemoveIceCreamResponse(isIceCreamRemoved);
    }
}
