package rateIceCream.core.responses.ratingResponses;

import rateIceCream.core.CoreError;
import rateIceCream.core.CoreResponse;

import java.util.List;

public class GetAverageIceCreamRatingResponse extends CoreResponse {

    private Long averageRating;

    public GetAverageIceCreamRatingResponse(List<CoreError> errors) {
        super(errors);
    }

    public GetAverageIceCreamRatingResponse(Long averageRating) {
        this.averageRating = averageRating;
    }

    public Long getAverageRating() {
        return averageRating;
    }
}
