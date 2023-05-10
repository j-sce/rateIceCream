package rateIceCream.core.requests.ratingRequests;

import rateIceCream.core.domain.IceCream;
import rateIceCream.core.domain.User;

public class AddIceCreamRatingRequest {

    private User user;

    private IceCream iceCream;

    private Long rating;

    public AddIceCreamRatingRequest() {
    }

    public AddIceCreamRatingRequest(User user, IceCream iceCream, Long rating) {
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
