package rateIceCream.core.responses.userResponses;

import rateIceCream.core.CoreError;
import rateIceCream.core.CoreResponse;
import rateIceCream.core.domain.User;

import java.util.List;

public class GetUserResponse extends CoreResponse {

    private User user;

    public GetUserResponse(List<CoreError> errors) {
        super(errors);
    }

    public GetUserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
