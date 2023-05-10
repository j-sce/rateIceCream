package rateIceCream.core.services.rating;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.IceCreamRatingRepository;
import rateIceCream.core.domain.IceCream;
import rateIceCream.core.domain.User;
import rateIceCream.core.requests.ratingRequests.AddIceCreamRatingRequest;
import rateIceCream.core.responses.ratingResponses.AddIceCreamRatingResponse;
import rateIceCream.core.services.ratingServices.AddIceCreamRatingService;
import rateIceCream.core.validators.ratingValidators.AddIceCreamRatingRequestValidator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static rateIceCream.core.domain.UserRole.USER;


@ExtendWith(MockitoExtension.class)
class AddIceCreamRatingServiceTest {

    @Mock
    private IceCreamRatingRepository repository;

    @Mock
    private AddIceCreamRatingRequestValidator validator;

    @InjectMocks
    private AddIceCreamRatingService service;

    @Test
    public void shouldReturnErrorWhenUserIdNotProvided() {
        IceCream iceCream = new IceCream("IceCream1", "Producer1", "1234567890123");
        AddIceCreamRatingRequest request = new AddIceCreamRatingRequest(null, iceCream, 5L);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("User ID", "must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        AddIceCreamRatingResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "User ID");
        assertEquals(response.getErrors().get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenIceCreamIdNotProvided() {
        User user = new User("Login1", "Password1", USER);
        AddIceCreamRatingRequest request = new AddIceCreamRatingRequest(user, null, 5L);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("IceCream ID", "must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        AddIceCreamRatingResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "IceCream ID");
        assertEquals(response.getErrors().get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenRatingNotProvided() {
        User user = new User("Login1", "Password1", USER);
        IceCream iceCream = new IceCream("IceCream1", "Producer1", "1234567890123");
        AddIceCreamRatingRequest request = new AddIceCreamRatingRequest(user, iceCream, null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("Rating", "must not be empty or zero!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        AddIceCreamRatingResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "Rating");
        assertEquals(response.getErrors().get(0).getMessage(), "must not be empty or zero!");
    }

    @Test
    public void shouldReturnErrorWhenRatingIsZero() {
        User user = new User("Login1", "Password1", USER);
        IceCream iceCream = new IceCream("IceCream1", "Producer1", "1234567890123");
        AddIceCreamRatingRequest request = new AddIceCreamRatingRequest(user, iceCream, 0L);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("Rating", "must not be empty or zero!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        AddIceCreamRatingResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "Rating");
        assertEquals(response.getErrors().get(0).getMessage(), "must not be empty or zero!");
    }

}