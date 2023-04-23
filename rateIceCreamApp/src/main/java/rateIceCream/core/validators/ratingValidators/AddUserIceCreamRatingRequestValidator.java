package rateIceCream.core.validators.ratingValidators;

import org.springframework.stereotype.Component;
import rateIceCream.core.CoreError;
import rateIceCream.core.requests.ratingRequests.AddUserIceCreamRatingRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddUserIceCreamRatingRequestValidator {

    public List<CoreError> validate(AddUserIceCreamRatingRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateUser(request).ifPresent(errors::add);
        validateIceCream(request).ifPresent(errors::add);
        validateRating(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateUser(AddUserIceCreamRatingRequest request) {
        return (request.getUser() == null)
                ? Optional.of(new CoreError("User ID", "must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateIceCream(AddUserIceCreamRatingRequest request) {
        return (request.getIceCream() == null)
                ? Optional.of(new CoreError("IceCream ID", "must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateRating(AddUserIceCreamRatingRequest request) {
        return (request.getRating() == null || request.getRating().equals(0L))
                ? Optional.of(new CoreError("Rating", "must not be empty or zero!"))
                : Optional.empty();
    }
}
