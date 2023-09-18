package rateIceCream.core.services.ratingServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.jpa.JpaIceCreamRatingRepository;
import rateIceCream.core.requests.ratingRequests.GetAverageIceCreamRatingRequest;
import rateIceCream.core.responses.ratingResponses.GetAverageIceCreamRatingResponse;
import rateIceCream.core.validators.ratingValidators.GetAverageIceCreamRatingRequestValidator;

import java.util.List;

@Component
@Transactional
public class GetAverageIceCreamRatingService {

    @Autowired
    private JpaIceCreamRatingRepository iceCreamRatingRepository;

    @Autowired
    private GetAverageIceCreamRatingRequestValidator validator;

    public GetAverageIceCreamRatingResponse execute(GetAverageIceCreamRatingRequest request) {
        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new GetAverageIceCreamRatingResponse(errors);
        }

        Long averageIceCreamRating = iceCreamRatingRepository.getAvgRatingByIceCreamId(request.getIceCreamId());

        return new GetAverageIceCreamRatingResponse(averageIceCreamRating);
    }
}
