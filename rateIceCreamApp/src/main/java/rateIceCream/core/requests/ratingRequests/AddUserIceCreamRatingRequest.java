package rateIceCream.core.requests.ratingRequests;

import rateIceCream.core.domain.IceCream;
import rateIceCream.core.domain.User;

public class AddUserIceCreamRatingRequest {

    private User user;

    private IceCream iceCream;

    private Long rating;

    public AddUserIceCreamRatingRequest(User user, IceCream iceCream, Long rating) {
        this.user = user;
        this.iceCream = iceCream;
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public IceCream getIceCream() {
        return iceCream;
    }

    public Long getRating() {
        return rating;
    }
}
