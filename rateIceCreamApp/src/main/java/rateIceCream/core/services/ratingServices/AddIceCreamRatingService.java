package rateIceCream.core.services.ratingServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.jpa.JpaIceCreamRatingRepository;
import rateIceCream.core.domain.IceCreamRating;
import rateIceCream.core.requests.ratingRequests.AddIceCreamRatingRequest;
import rateIceCream.core.responses.ratingResponses.AddIceCreamRatingResponse;
import rateIceCream.core.validators.ratingValidators.AddIceCreamRatingRequestValidator;

import java.util.List;

@Component
@Transactional
public class AddIceCreamRatingService {

    @Autowired
    private JpaIceCreamRatingRepository iceCreamRatingRepository;

    @Autowired
    private AddIceCreamRatingRequestValidator validator;

    public AddIceCreamRatingResponse execute(AddIceCreamRatingRequest request) {
        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new AddIceCreamRatingResponse(errors);
        }

        IceCreamRating iceCreamRating = new IceCreamRating(request.getUser(), request.getIceCream(), request.getRating());
        iceCreamRatingRepository.save(iceCreamRating);

        return new AddIceCreamRatingResponse(iceCreamRating);
    }
}
