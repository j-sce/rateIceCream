package rateIceCream.core.services;

import rateIceCream.IceCream;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.Database;
import rateIceCream.core.requests.AddIceCreamRequest;
import rateIceCream.core.responses.AddIceCreamResponse;
import rateIceCream.core.validators.AddIceCreamRequestValidator;

import java.util.List;

public class AddIceCreamService {

    private Database database;
    private AddIceCreamRequestValidator validator;

    public AddIceCreamService(Database database, AddIceCreamRequestValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public AddIceCreamResponse execute(AddIceCreamRequest request) {
        List<CoreError> errors = validator.validate(request, database);
        if (!errors.isEmpty()) {
            return new AddIceCreamResponse(errors);
        }
        IceCream iceCream = new IceCream(request.getName(), request.getProducer(), request.getBarcode());
        database.save(iceCream);

        return new AddIceCreamResponse(iceCream);
    }
}
