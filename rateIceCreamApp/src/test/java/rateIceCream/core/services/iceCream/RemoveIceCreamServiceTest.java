package rateIceCream.core.services.iceCream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import rateIceCream.core.CoreError;
import rateIceCream.core.database.jpa.JpaIceCreamRepository;
import rateIceCream.core.requests.iceCreamRequests.RemoveIceCreamRequest;
import rateIceCream.core.responses.iceCreamResponses.RemoveIceCreamResponse;
import rateIceCream.core.services.iceCreamServices.RemoveIceCreamService;
import rateIceCream.core.validators.iceCreamValidators.RemoveIceCreamRequestValidator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class RemoveIceCreamServiceTest {
    @Mock
    private JpaIceCreamRepository iceCreamRepository;
    @Mock
    private RemoveIceCreamRequestValidator validator;
    @InjectMocks
    private RemoveIceCreamService service;

    @Test
    public void shouldReturnErrorWhenIceCreamIdNotProvided() {
        RemoveIceCreamRequest request = new RemoveIceCreamRequest(null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("ID", "must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        RemoveIceCreamResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "ID");
        assertEquals(response.getErrors().get(0).getMessage(), "must not be empty!");
    }

    @Test
    public void shouldDeleteIceCreamByIdFromDatabase() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        Mockito.doNothing().when(iceCreamRepository).deleteById(Mockito.any());
        RemoveIceCreamRequest request = new RemoveIceCreamRequest(1L);
        RemoveIceCreamResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertTrue(response.isIceCreamRemoved());
        Mockito.verify(iceCreamRepository).deleteById(Mockito.any());
    }

}