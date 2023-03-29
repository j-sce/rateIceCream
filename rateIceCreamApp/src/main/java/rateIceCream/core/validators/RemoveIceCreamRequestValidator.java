package rateIceCream.core.validators;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import rateIceCream.core.CoreError;
import rateIceCream.core.requests.RemoveIceCreamRequest;

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
