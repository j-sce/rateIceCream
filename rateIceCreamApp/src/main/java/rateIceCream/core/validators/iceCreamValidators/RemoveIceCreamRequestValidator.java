package rateIceCream.core.validators.iceCreamValidators;

import org.springframework.stereotype.Component;
import rateIceCream.core.CoreError;
import rateIceCream.core.requests.iceCreamRequests.RemoveIceCreamRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RemoveIceCreamRequestValidator {
    public List<CoreError> validate(RemoveIceCreamRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateId(RemoveIceCreamRequest request) {
        return (request.getIceCreamIdToRemove() == null)
                ? Optional.of(new CoreError("ID", "must not be empty!"))
                : Optional.empty();
    }
}
