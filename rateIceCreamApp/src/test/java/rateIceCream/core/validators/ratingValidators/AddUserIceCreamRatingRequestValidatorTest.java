package rateIceCream.core.validators.ratingValidators;

import org.junit.jupiter.api.Test;
import rateIceCream.core.CoreError;
import rateIceCream.core.domain.IceCream;
import rateIceCream.core.domain.User;
import rateIceCream.core.requests.ratingRequests.AddUserIceCreamRatingRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static rateIceCream.core.domain.UserRole.USER;

class AddUserIceCreamRatingRequestValidatorTest {

    private AddUserIceCreamRatingRequestValidator validator = new AddUserIceCreamRatingRequestValidator();

    @Test
    public void shouldReturnErrorWhenUserIdIsEmpty() {
        IceCream iceCream = new IceCream("Name1", "Producer1", "1234567890123");
        AddUserIceCreamRatingRequest request = new AddUserIceCreamRatingRequest(null, iceCream, 5L);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "User ID");
        assertEquals(errors.get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenIceCreamIdIsEmpty() {
        User user = new User("Login1", "Password1", USER);
        AddUserIceCreamRatingRequest request = new AddUserIceCreamRatingRequest(user, null, 5L);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "IceCream ID");
        assertEquals(errors.get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenRatingIsEmpty() {
        User user = new User("Login1", "Password1", USER);
        IceCream iceCream = new IceCream("Name1", "Producer1", "1234567890123");
        AddUserIceCreamRatingRequest request = new AddUserIceCreamRatingRequest(user, iceCream, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Rating");
        assertEquals(errors.get(0).getMessage(), "must not be empty or zero!");
    }

    @Test
    public void shouldReturnErrorWhenRatingIsZero() {
        User user = new User("Login1", "Password1", USER);
        IceCream iceCream = new IceCream("Name1", "Producer1", "1234567890123");
        AddUserIceCreamRatingRequest request = new AddUserIceCreamRatingRequest(user, iceCream, 0L);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Rating");
        assertEquals(errors.get(0).getMessage(), "must not be empty or zero!");
    }

    @Test
    public void shouldSuccess() {
        User user = new User("Login1", "Password1", USER);
        IceCream iceCream = new IceCream("Name1", "Producer1", "1234567890123");
        AddUserIceCreamRatingRequest request = new AddUserIceCreamRatingRequest(user, iceCream, 5L);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

}