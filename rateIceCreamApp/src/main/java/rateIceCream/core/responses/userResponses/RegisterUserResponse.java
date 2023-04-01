package rateIceCream.core.responses.userResponses;

import rateIceCream.core.CoreError;
import rateIceCream.core.CoreResponse;
import rateIceCream.core.domain.User;

import java.util.List;

public class RegisterUserResponse extends CoreResponse {

    private User newUser;

    public RegisterUserResponse(List<CoreError> errors) {
        super(errors);
    }

    public RegisterUserResponse(User newUser) {
        this.newUser = newUser;
    }

    public User getNewUser() {
        return newUser;
    }
}
