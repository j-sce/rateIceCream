package rateIceCream.core.validators.userValidators;

import org.springframework.stereotype.Component;
import rateIceCream.core.CoreError;
import rateIceCream.core.requests.userRequests.GetUserRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetUserRequestValidator {

    public List<CoreError> validate(GetUserRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateId(GetUserRequest request) {
        return (request.getUserId() == null)
                ? Optional.of(new CoreError("ID", "must not be empty!"))
                : Optional.empty();
    }
}
