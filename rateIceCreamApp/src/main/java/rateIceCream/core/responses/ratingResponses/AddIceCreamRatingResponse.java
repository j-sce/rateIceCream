package rateIceCream.core.responses.ratingResponses;

import rateIceCream.core.CoreError;
import rateIceCream.core.CoreResponse;
import rateIceCream.core.domain.IceCreamRating;

import java.util.List;

public class AddIceCreamRatingResponse extends CoreResponse {

    private IceCreamRating newIceCreamRating;

    public AddIceCreamRatingResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddIceCreamRatingResponse(IceCreamRating newIceCreamRating) {
        this.newIceCreamRating = newIceCreamRating;
    }

    public IceCreamRating getNewUserIceCreamRating() {
        return newIceCreamRating;
    }
}
