package rateIceCream.core.services.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.jpa.JpaUserRepository;
import rateIceCream.core.domain.User;
import rateIceCream.core.requests.userRequests.GetUserRequest;
import rateIceCream.core.responses.userResponses.GetUserResponse;
import rateIceCream.core.services.userServices.GetUserService;
import rateIceCream.core.validators.userValidators.GetUserRequestValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class GetUserServiceTest {

    @Mock
    private JpaUserRepository repository;

    @Mock
    private GetUserRequestValidator validator;

    @InjectMocks
    private GetUserService service;

    @Test
    public void shouldReturnErrorWhenUserIdNotProvided() {
        GetUserRequest request = new GetUserRequest(null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("ID", "must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        GetUserResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "ID");
        assertEquals(response.getErrors().get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldGetUserByIdFromDatabase() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(new User("Login1", "Password1")));
        GetUserRequest request = new GetUserRequest(1L);
        GetUserResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getUser().getUsername(), "Login1");
        assertEquals(response.getUser().getPassword(), "Password1");
    }

}