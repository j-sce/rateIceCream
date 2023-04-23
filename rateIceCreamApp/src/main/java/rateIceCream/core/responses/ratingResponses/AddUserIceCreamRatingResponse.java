package rateIceCream.core.responses.ratingResponses;

import rateIceCream.core.CoreError;
import rateIceCream.core.CoreResponse;
import rateIceCream.core.domain.UserIceCreamRating;

import java.util.List;

public class AddUserIceCreamRatingResponse extends CoreResponse {

    private UserIceCreamRating newUserIceCreamRating;

    public AddUserIceCreamRatingResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddUserIceCreamRatingResponse(UserIceCreamRating newUserIceCreamRating) {
        this.newUserIceCreamRating = newUserIceCreamRating;
    }

    public UserIceCreamRating getNewUserIceCreamRating() {
        return newUserIceCreamRating;
    }
}
