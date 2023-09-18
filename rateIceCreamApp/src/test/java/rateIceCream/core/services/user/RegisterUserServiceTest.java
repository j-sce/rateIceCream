package rateIceCream.core.services.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.jpa.JpaUserRepository;
import rateIceCream.core.domain.UserRole;
import rateIceCream.core.requests.userRequests.RegisterUserRequest;
import rateIceCream.core.responses.userResponses.RegisterUserResponse;
import rateIceCream.core.services.userServices.RegisterUserService;
import rateIceCream.core.validators.userValidators.RegisterUserRequestValidator;
import rateIceCream.matchers.UserMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;

@ExtendWith(MockitoExtension.class)
class RegisterUserServiceTest {

    @Mock
    private JpaUserRepository userRepository;

    @Mock
    private RegisterUserRequestValidator validator;

    @InjectMocks
    private RegisterUserService registerUserService;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFails() {
        RegisterUserRequest request = new RegisterUserRequest(null, "password", UserRole.USER);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("Login", "must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        RegisterUserResponse response = registerUserService.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "Login");
        assertEquals(response.getErrors().get(0).getMessage(), "must not be empty!");

        Mockito.verifyNoInteractions(userRepository);
    }

    @Test
    public void shouldRegisterUserInDatabase() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        RegisterUserRequest request = new RegisterUserRequest("Login", "password", UserRole.USER);
        RegisterUserResponse response = registerUserService.execute(request);
        assertFalse(response.hasErrors());
        Mockito.verify(userRepository).save(
                argThat(new UserMatcher("Login", "password", UserRole.USER)));
    }
}