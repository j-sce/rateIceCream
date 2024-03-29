package rateIceCream.core.services.userServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.jpa.JpaUserRepository;
import rateIceCream.core.domain.User;
import rateIceCream.core.requests.userRequests.RegisterUserRequest;
import rateIceCream.core.responses.userResponses.RegisterUserResponse;
import rateIceCream.core.validators.userValidators.RegisterUserRequestValidator;

import java.util.List;

@Component
public class RegisterUserService {

    @Autowired
    private JpaUserRepository userRepository;

    @Autowired
    private RegisterUserRequestValidator validator;

    public RegisterUserResponse execute(RegisterUserRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RegisterUserResponse(errors);
        }
        User user = new User(request.getUsername(), request.getPassword());
        userRepository.save(user);
        return new RegisterUserResponse(user);
    }
}
