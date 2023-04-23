package rateIceCream.core.validators.user;

import org.junit.jupiter.api.Test;
import rateIceCream.core.CoreError;
import rateIceCream.core.requests.userRequests.GetUserRequest;
import rateIceCream.core.validators.userValidators.GetUserRequestValidator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetUserRequestValidatorTest {

    private GetUserRequestValidator validator = new GetUserRequestValidator();

    @Test
    public void shouldReturnErrorWhenIdIsEmpty() {
        GetUserRequest request = new GetUserRequest(null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "ID");
        assertEquals(errors.get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldSuccess() {
        GetUserRequest request = new GetUserRequest(1L);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

}