package rateIceCream.core.validators.ratingValidators;

import org.springframework.stereotype.Component;
import rateIceCream.core.CoreError;
import rateIceCream.core.requests.ratingRequests.GetAverageIceCreamRatingRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetAverageIceCreamRatingRequestValidator {

    public List<CoreError> validate(GetAverageIceCreamRatingRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateId(GetAverageIceCreamRatingRequest request) {
        return (request.getIceCreamId() == null)
                ? Optional.of(new CoreError("ID", "must not be empty!"))
                : Optional.empty();
    }
}
