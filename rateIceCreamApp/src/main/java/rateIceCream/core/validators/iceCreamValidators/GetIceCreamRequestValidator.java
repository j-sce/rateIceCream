package rateIceCream.core.validators.iceCreamValidators;

import org.springframework.stereotype.Component;
import rateIceCream.core.CoreError;
import rateIceCream.core.requests.iceCreamRequests.GetIceCreamRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetIceCreamRequestValidator {

    public List<CoreError> validate(GetIceCreamRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateId(GetIceCreamRequest request) {
        return (request.getIceCreamId() == null)
                ? Optional.of(new CoreError("ID", "must not be empty!"))
                : Optional.empty();
    }
}
