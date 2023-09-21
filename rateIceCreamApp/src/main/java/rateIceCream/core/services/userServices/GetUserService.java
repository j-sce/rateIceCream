package rateIceCream.core.services.userServices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.jpa.JpaUserRepository;
import rateIceCream.core.domain.User;
import rateIceCream.core.requests.userRequests.GetUserRequest;
import rateIceCream.core.responses.userResponses.GetUserResponse;
import rateIceCream.core.validators.userValidators.GetUserRequestValidator;

import java.util.List;

@Component
@Transactional
public class GetUserService {

    @Autowired
    private JpaUserRepository userRepository;

    @Autowired
    private GetUserRequestValidator validator;

    public GetUserResponse execute(GetUserRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new GetUserResponse(errors);
        }
        User user = userRepository.findById(request.getUserId()).get();
        return new GetUserResponse(user);
    }
}
