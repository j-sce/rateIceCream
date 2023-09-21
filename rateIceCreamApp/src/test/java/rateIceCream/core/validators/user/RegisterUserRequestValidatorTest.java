package rateIceCream.core.validators.user;

import org.junit.jupiter.api.Test;
import rateIceCream.core.CoreError;
import rateIceCream.core.requests.userRequests.RegisterUserRequest;
import rateIceCream.core.validators.userValidators.RegisterUserRequestValidator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegisterUserRequestValidatorTest {

    private RegisterUserRequestValidator validator = new RegisterUserRequestValidator();

    @Test
    public void shouldReturnErrorWhenLoginIsEmpty() {
        RegisterUserRequest request = new RegisterUserRequest(null, "password");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Login");
        assertEquals(errors.get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenPasswordIsEmpty() {
        RegisterUserRequest request = new RegisterUserRequest("Login", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Password");
        assertEquals(errors.get(0).getMessage(), "must not be empty!");
    }


    @Test
    public void shouldSuccess() {
        RegisterUserRequest request = new RegisterUserRequest("Login", "password");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }
}