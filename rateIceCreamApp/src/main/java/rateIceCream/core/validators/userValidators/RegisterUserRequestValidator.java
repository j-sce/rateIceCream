package rateIceCream.core.validators.userValidators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.UserRepository;
import rateIceCream.core.requests.userRequests.RegisterUserRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RegisterUserRequestValidator {

    @Autowired
    UserRepository userRepository;

    public List<CoreError> validate(RegisterUserRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateLogin(request).ifPresent(errors::add);
        validatePassword(request).ifPresent(errors::add);
        validateRole(request).ifPresent(errors::add);
        validateUnique(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateLogin(RegisterUserRequest request) {
        return (request.getLogin() == null || request.getLogin().isEmpty())
                ? Optional.of(new CoreError("Login", "must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePassword(RegisterUserRequest request) {
        return (request.getPassword() == null || request.getPassword().isEmpty())
                ? Optional.of(new CoreError("Password", "must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateRole(RegisterUserRequest request) {
        return (request.getUserRole() == null)
                ? Optional.of(new CoreError("User role", "must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateUnique(RegisterUserRequest request) {
        return (userRepository.findByLogin(request.getLogin()).size() > 0)
                ? Optional.of(new CoreError("Login", "is not unique!"))
                : Optional.empty();
    }
}
