package rateIceCream.core.services.iceCream;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.IceCreamRepository;
import rateIceCream.core.services.iceCreamServices.AddIceCreamService;
import rateIceCream.matchers.IceCreamMatcher;
import rateIceCream.core.requests.iceCreamRequests.AddIceCreamRequest;
import rateIceCream.core.responses.iceCreamResponses.AddIceCreamResponse;
import rateIceCream.core.validators.iceCreamValidators.AddIceCreamRequestValidator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;

@ExtendWith(MockitoExtension.class)
public class AddIceCreamServiceTest {
    @Mock
    private IceCreamRepository iceCreamRepository;
    @Mock
    private AddIceCreamRequestValidator validator;
    @InjectMocks private AddIceCreamService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFails() {
        AddIceCreamRequest request = new AddIceCreamRequest(null, "Producer1", "0123456789012");
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("Name", "must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        AddIceCreamResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "Name");
        assertEquals(response.getErrors().get(0).getMessage(), "must not be empty!");

        Mockito.verifyNoInteractions(iceCreamRepository);
    }

    @Test
    public void shouldAddIceCreamToDatabase() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        AddIceCreamRequest request = new AddIceCreamRequest("Name", "Producer1", "0123456789012");
        AddIceCreamResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        Mockito.verify(iceCreamRepository).save(
                argThat(new IceCreamMatcher("Name", "Producer1", "1234567890123")));
    }

}