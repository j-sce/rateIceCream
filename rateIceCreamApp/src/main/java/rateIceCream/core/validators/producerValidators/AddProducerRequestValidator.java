package rateIceCream.core.validators.producerValidators;

import org.springframework.stereotype.Component;
import rateIceCream.core.CoreError;
import rateIceCream.core.requests.producerRequests.AddProducerRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddProducerRequestValidator {

    public List<CoreError> validate(AddProducerRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateName(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateName(AddProducerRequest request) {
        return (request.getName() == null || request.getName().isEmpty())
                ? Optional.of(new CoreError("Name", "must not be empty!"))
                : Optional.empty();
    }
}
