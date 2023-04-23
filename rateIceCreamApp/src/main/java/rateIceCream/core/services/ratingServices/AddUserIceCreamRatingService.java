package rateIceCream.core.services.ratingServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.IceCreamRatingRepository;
import rateIceCream.core.domain.UserIceCreamRating;
import rateIceCream.core.requests.ratingRequests.AddUserIceCreamRatingRequest;
import rateIceCream.core.responses.ratingResponses.AddUserIceCreamRatingResponse;
import rateIceCream.core.validators.ratingValidators.AddUserIceCreamRatingRequestValidator;

import java.util.List;

@Component
@Transactional
public class AddUserIceCreamRatingService {

    @Autowired
    private IceCreamRatingRepository iceCreamRatingRepository;

    @Autowired
    private AddUserIceCreamRatingRequestValidator validator;

    public AddUserIceCreamRatingResponse execute (AddUserIceCreamRatingRequest request){
        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()){
            return new AddUserIceCreamRatingResponse(errors);
        }

        UserIceCreamRating userIceCreamRating = new UserIceCreamRating(request.getUser(), request.getIceCream(), request.getRating());
        iceCreamRatingRepository.save(userIceCreamRating);

        return new AddUserIceCreamRatingResponse(userIceCreamRating);
    }
}
